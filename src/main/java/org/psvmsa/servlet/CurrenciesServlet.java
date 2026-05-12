package org.psvmsa.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.psvmsa.dao.CurrencyDao;
import org.psvmsa.dao.JdbcCurrencyDao;
import org.psvmsa.dto.CurrencyRequestDto;
import org.psvmsa.entity.Currency;
import org.psvmsa.servlet.request_validator.CurrenciesRequestValidator;
import org.psvmsa.servlet.request_validator.RequestValidator;
import org.psvmsa.utils.Mapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/currencies")
public class CurrenciesServlet extends HttpServlet {

    CurrencyDao currencyDao = new JdbcCurrencyDao();
    RequestValidator<CurrencyRequestDto> requestValidator = new CurrenciesRequestValidator();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        List<Currency> currencies = currencyDao.getAll();
        out.print(currencies);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name =  req.getParameter("name");
        String code = req.getParameter("code");
        String sign = req.getParameter("sign");

        CurrencyRequestDto requestDto = new CurrencyRequestDto(name, code, sign);
        requestValidator.validate(requestDto);
        Currency currency = Mapper.convertToEntity(requestDto);
        currencyDao.create(currency);

    }

}
