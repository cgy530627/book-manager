package com.example.bookmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 根路径控制器
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "service", "图书管理系统 API",
                "version", "1.0.0",
                "status", "running",
                "timestamp", LocalDateTime.now().toString(),
                "endpoints", Map.of(
                        "list", "GET  /api/books",
                        "search", "GET  /api/books?q={keyword}",
                        "detail", "GET  /api/books/{id}",
                        "create", "POST /api/books",
                        "update", "PUT  /api/books/{id}",
                        "delete", "DELETE /api/books/{id}"
                )
        );
    }
}
