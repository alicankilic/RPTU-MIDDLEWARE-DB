package com.rptu.alicankilic.dbdersi.Controller;


import com.rptu.alicankilic.dbdersi.Services.DatabaseServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DBController {

    private final DatabaseServices databaseService;

    public DBController(DatabaseServices databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/db")
    public String testDatabase() {
        return "Connected to database: "
                + databaseService.testConnection();
    }

    @GetMapping("/accounts")
    public List<Map<String, Object>> getAccounts() {
        return databaseService.getAccounts();
    }
}
