package org.psvmsa.dao;

import org.psvmsa.db.DataBaseConnectionManager;
import org.psvmsa.entity.Currency;
import org.psvmsa.exception.DatabaseException;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcCurrencyDao implements CurrencyDao {


    @Override
    public Currency create(Currency entity) {
        String query = "INSERT INTO Currencies (code, full_name, sign) VALUES (?, ?, ?) RETURNING *";
        try (Connection conn = DataBaseConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);) {
            stmt.setString(1, entity.getCode());
            stmt.setString(2, entity.getFull_name());
            stmt.setString(3, entity.getSign());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new Currency(
                            rs.getLong("id"),
                            rs.getString("code"),
                            rs.getString("full_name"),
                            rs.getString("sign")
                    );

        } catch (SQLException e) {
            throw new DatabaseException("Failed to create currency.");
        }
    }

    @Override
    public Optional<Currency> get(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Currency> getAll() {
        try (Connection conn = DataBaseConnectionManager.getConnection();
             Statement stmt = conn.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Currencies");
            List<Currency> currencies = new ArrayList<>();
            while (rs.next()) {
                currencies.add(new Currency(
                                rs.getLong("id"),
                                rs.getString("code"),
                                rs.getString("full_name"),
                                rs.getString("sign")
                        )
                );
            }
            return currencies;
        } catch (SQLException e) {
            throw new DatabaseException("Failed to get currencies from database.");
        }
    }

    @Override
    public void update(Currency entity) {

    }

    @Override
    public void delete(Currency entity) {

    }
}
