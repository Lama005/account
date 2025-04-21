package com.example.account.dtos;

import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private BigInteger isbn;
    private Integer stock;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
