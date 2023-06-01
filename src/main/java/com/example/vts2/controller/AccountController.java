package com.example.vts2.controller;

import com.example.vts2.entity.Account;
import com.example.vts2.request.AccountRequest;
import com.example.vts2.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/account")
    public ResponseEntity<?> addAccount(@RequestBody AccountRequest accountRequest) {
        Account account = accountService.addAccount(accountRequest);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account exists");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Add account");
    }
    @GetMapping("/accounts")
    public ResponseEntity<?> getAllAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccounts());
    }
}
