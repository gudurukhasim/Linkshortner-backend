package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.shortUrl;

@Repository
public interface ShorturlRepository extends MongoRepository<shortUrl, String>{
    Optional<shortUrl> findByShortCode(String shortCode);
    Optional<shortUrl> findByOriginalUrl(String originalUrl);


}
