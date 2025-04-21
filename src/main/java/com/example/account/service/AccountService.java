package com.example.account.service;

import com.example.account.dtos.AccountDTO;
import com.example.account.dtos.BookDTO;
import com.example.account.dtos.StudentDTO;
import com.example.account.exception.AccountNotFoundException;
import com.example.account.external.BookFeignClient;
import com.example.account.external.StudentFeignClient;
import com.example.account.model.Account;
import com.example.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor()
public class AccountService {

    private final AccountRepository accountRepository;
    private final BookFeignClient bookFeignClient;
    private final StudentFeignClient studentFeignClient;
    private ModelMapper modelMapper;

    @Autowired
    public AccountService(
            AccountRepository accountRepository,
            BookFeignClient bookFeignClient,
            StudentFeignClient studentFeignClient,
            ModelMapper modelMapper
    ) {
        this.accountRepository = accountRepository;
        this.bookFeignClient = bookFeignClient;
        this.studentFeignClient = studentFeignClient;
        this.modelMapper = modelMapper;
    }

//    public AccountDTO createAccount(AccountDTO accountDTO) {
////        StudentDTO std = studentFeignClient.getStudentById(accountDTO.getStudent());
////        BookDTO book = bookFeignClient.getBookById(accountDTO.getBooks());
//        StudentDTO std = (StudentDTO) studentFeignClient.getStudents();
//        List<BookDTO> book = bookFeignClient.getBooks();
//        if (book == null || std == null) {
//            throw new AccountNotFoundException("Book And Student of this ID is not found");
//        }
//        Account account = new Account();
//        account.setBorrowDate(LocalDateTime.now());
//        account.setBorrowPrice(accountDTO.getBorrowPrice());
//        account.setStudentId(std.getId());
//        account.setBookId(book.getFirst().getId());
//        account.setIsReturn(false);
//        account.setReturnDate(accountDTO.getReturnDate());
    ////        account.setStudentId((long) accountDTO.getStudent());
    ////        account.setBookId((long) accountDTO.getBooks());
//        accountRepository.save(account);
//        return accountDTO;
//    }
    public AccountDTO createAccount(Account account) {
        StudentDTO std = (StudentDTO) studentFeignClient.getStudents();
        List<BookDTO> book = bookFeignClient.getBooks();
        if (book == null || std == null) {
            throw new AccountNotFoundException("Book And Student of this ID is not found");
        }
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setIsReturn(Boolean.FALSE);
        accountDTO.setReturnDate(null);
        accountDTO = modelMapper.map(account, AccountDTO.class);//(data, to which source will it go)
        log.info(accountDTO.toString());
        return accountDTO;
    }

    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountById(long id) throws Exception {
        return accountRepository.findById(id).orElseThrow(() -> new Exception("Account not found"));
    }

    public Account returnBook(long id) throws Exception {
        Account account = accountRepository.findById(id).orElseThrow(() -> new Exception("Account not found"));
        account.setReturnDate(LocalDateTime.now());
        account.setIsReturn(true);
        accountRepository.save(account);
        return account;
    }


}
