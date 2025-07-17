package com.example.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class shortUrl {

    @Id
    private String id;
    private String originalUrl;
    private String shortCode;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

}
