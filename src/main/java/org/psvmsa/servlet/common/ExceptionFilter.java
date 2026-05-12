package org.psvmsa.servlet.common;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.psvmsa.dto.ResponseExceptionDto;
import org.psvmsa.exception.DatabaseException;
import org.psvmsa.exception.InvalidParameterException;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static jakarta.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

@WebFilter("/*")
public class ExceptionFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (DatabaseException e){
            createResponseExceptionMessage(servletResponse, e.getMessage(), SC_INTERNAL_SERVER_ERROR);
        } catch (InvalidParameterException e){
            createResponseExceptionMessage(servletResponse, e.getMessage(), SC_BAD_REQUEST);
        }
    }

    private void createResponseExceptionMessage(HttpServletResponse servletResponse, String message, int statusCode) throws IOException {
        servletResponse.getWriter().print(new ResponseExceptionDto(message, statusCode));
        servletResponse.setStatus(statusCode);
    }
}
