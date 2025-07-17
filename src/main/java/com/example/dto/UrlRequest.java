package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UrlRequest {
    @NotBlank
    @Pattern(regexp = "^(http|https)://.*$", message = "Invalid URL")
    private String originalUrl;


}
