package com.example.account.external;

import com.example.account.dtos.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book", url = "http://192.168.1.141:8080", path = "book")
public interface BookFeignClient {

    @GetMapping
    List<BookDTO> getBooks();

    @GetMapping("/{id}")
    BookDTO getBookById(@PathVariable int id);
}