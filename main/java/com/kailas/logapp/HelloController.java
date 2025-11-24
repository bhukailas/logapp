package com.kailas.logapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
public class HelloController {

    @Value("${app.message:default message}")
    //@Value("${app.message}")
    private String message;

    @GetMapping("/msg")
    public String getMessage() {
        return message;
    }
}
