package com.example.account.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_return")
    private Boolean isReturn = false;

    @Column(name = "borrowPrice")
    private Double borrowPrice = 0.0;

    @Column(name = "borrow_date", nullable = false)
    private LocalDateTime borrowDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name="student_id")
    private Long studentId;

    @Column(name = "book_id")
    private Long bookId;
}
