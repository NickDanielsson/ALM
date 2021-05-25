package com.example.springdocker.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  //  @Value("${spring.data.mongodb.database}")
    private String dbname;

    @GetMapping("/env")
    public Response getEnv() {
        return new Response(dbname);
    }

    @Data
    @AllArgsConstructor
    class Response {
        String dbname;
    }
}
