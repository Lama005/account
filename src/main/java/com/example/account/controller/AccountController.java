package com.example.account.controller;

import com.example.account.dtos.AccountDTO;
import com.example.account.model.Account;
import com.example.account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/account")
@RequiredArgsConstructor
@Tag(name = "Account Controller",description = "Api of Account")

public class AccountController {
    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description ="Create A New Account",summary = "Create A New Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create New Record of the borrow Book!",content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public AccountDTO createAccount(@RequestBody Account account) throws Exception {
        return accountService.createAccount(account);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccount(@PathVariable long id) throws Exception {
        return accountService.returnBook(id);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAccounts();
    }
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable long id) throws Exception {
        return accountService.getAccountById(id);
    }
}
