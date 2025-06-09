package com.amigurumis_atelier.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://127.0.0.1:5501", "http://localhost:5501", "https://main.d2pyfqpvl5zw8r.amplifyapp.com"}, allowCredentials = "true")
public class PingController {
    @GetMapping("/ping")
    public String ping() {
        return "Conectado correctamente";
    }
}
