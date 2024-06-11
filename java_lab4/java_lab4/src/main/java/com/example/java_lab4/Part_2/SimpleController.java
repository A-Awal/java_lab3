package com.example.java_lab4.Part_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simple")
public class SimpleController {
    @Value("${spring.application.name}")
    String msg;

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok(msg);
    }
}
