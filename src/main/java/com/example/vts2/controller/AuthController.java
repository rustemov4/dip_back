package com.example.vts2.controller;

import com.example.vts2.entity.Account;
import com.example.vts2.jwt.JwtTokenProvider;
import com.example.vts2.request.AuthRequest;
import com.example.vts2.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AccountService accountService;

    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        String accountId = authRequest.getAccountID();
        String password = authRequest.getPassword();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountId, password));
            Account account = accountService.getAccount(accountId);
            if (account == null) {
                throw new UsernameNotFoundException("Username not found");
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email or password");
        }
        UserDetails userDetails = accountService.loadUserByUsername(accountId);
        Account account = accountService.getAccount(accountId);
        long timestamp = System.currentTimeMillis();
        int timestampAsInt = (int) (timestamp / 1000);
        account.setLastlogintime(timestampAsInt);
        accountService.updateAccount(account);
        final String token = new JwtTokenProvider().generateToken(userDetails);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
