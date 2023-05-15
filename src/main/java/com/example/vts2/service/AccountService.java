package com.example.vts2.service;

import com.example.vts2.entity.Account;
import com.example.vts2.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class AccountService implements UserDetailsService {
    AccountRepository accountRepository;

    public Account getAccount(String accountId) {
        return accountRepository.findAccountByAccountID(accountId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByAccountID(username);
        if (account == null) {
            throw new UsernameNotFoundException("Account not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(account.getAccountID(), account.getPassword(), authorities);
    }
}
