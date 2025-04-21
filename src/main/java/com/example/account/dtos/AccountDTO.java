package com.example.account.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class  AccountDTO {

    private Long id;
    private Boolean isReturn = false;
    private Double borrowPrice;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    //    private int student;
//    private int books;
    private StudentDTO student;
    private List<BookDTO> books;
}
