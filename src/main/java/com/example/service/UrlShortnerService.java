package com.example.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.model.shortUrl;
import com.example.repository.ShorturlRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlShortnerService {
    private final ShorturlRepository repository;

    public String shortenUrl(String originalUrl) {
        return repository.findByOriginalUrl(originalUrl).map(shortUrl::getShortCode).orElseGet(() -> {
            String code = generateCode();
            shortUrl shorturl = new shortUrl();
            shorturl.setOriginalUrl(originalUrl);
            shorturl.setShortCode(code);
            shorturl.setCreatedAt(LocalDateTime.now());
            shorturl.setExpiresAt(LocalDateTime.now().plusMinutes(5));
            repository.save(shorturl);
            return code;
        });
    }

    public String getOriginalUrl(String code) {
        return repository.findByShortCode(code)
                .filter(s -> s.getExpiresAt().isAfter(LocalDateTime.now()))
                .map(shortUrl::getOriginalUrl)
                .orElse(null);
    }

    private String generateCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
