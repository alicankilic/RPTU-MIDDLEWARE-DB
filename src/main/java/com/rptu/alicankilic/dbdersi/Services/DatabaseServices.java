
package com.rptu.alicankilic.dbdersi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatabaseServices {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String testConnection() {
        return jdbcTemplate.queryForObject(
                "SELECT current_database()",
                String.class
        );
    }

    public List<Map<String, Object>> getAccounts() {
        String sql = """
                SELECT "CustID", "AccountNumber",
                       "AccountType", "Balance"
                FROM "OnlineBank"."CustomerAccounts"
                ORDER BY "CustID"
                """;

        return jdbcTemplate.queryForList(sql);
    }
}
