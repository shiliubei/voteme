package com.example.voting.repository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class JdbcRepository {

    @GetMapping("/echo/{message}")
    public String echo (@PathVariable String message){
        return message;
    }

}
