package com.example.springbootredisrepeatlimiting.controller;

import com.example.springbootredisrepeatlimiting.annotation.CacheLock;
import com.example.springbootredisrepeatlimiting.annotation.CacheParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookController
 *
 * @author Una Ma
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @CacheLock(prefix = "books")
    @GetMapping
    public String query(@CacheParam(name = "token") @RequestParam String token) {
        return "success - " + token;
    }

}
