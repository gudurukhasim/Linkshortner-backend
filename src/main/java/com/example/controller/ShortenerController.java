package com.example.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.example.dto.UrlRequest;
import com.example.service.UrlShortnerService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ShortenerController {

    private final UrlShortnerService service;

    @PostMapping("/api/shorten")
    public ResponseEntity<?> shorten(@Valid @RequestBody UrlRequest request) {
        String code = service.shortenUrl(request.getOriginalUrl());
        return ResponseEntity.ok("https://linkshortener-backend.koyeb.app/" + code); //"http://localhost:8081/"
    }

    @GetMapping("/{code}")
    public void redirect(@PathVariable String code, HttpServletResponse response) throws IOException {
        String original = service.getOriginalUrl(code);
        if (original == null) {
            response.sendRedirect("https://linkshortner-frontend.vercel.app/error?type=expired_or_not_found");//"http://localhost:5173/error?type=expired_or_not_found"
        } else {
            response.sendRedirect(original);
        }
    }
} 
