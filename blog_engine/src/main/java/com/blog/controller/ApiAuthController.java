package com.blog.controller;

import com.blog.api.response.CheckResponse;
import com.blog.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    private final CheckService checkService;

    @Autowired
    public ApiAuthController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping("/check")
    public CheckResponse check() {
        return checkService.getResult();
    }
}