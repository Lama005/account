package com.example.account.dtos;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class StudentDTO {
    private Long id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private Integer roll_number;
    private String email;
    private BigInteger phone_number;
    private String address;
    private Date dob;
}
