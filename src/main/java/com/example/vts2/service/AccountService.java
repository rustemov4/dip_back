package com.example.vts2.service;

import com.example.vts2.entity.Account;
import com.example.vts2.repository.AccountRepository;
import com.example.vts2.request.AccountRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService implements UserDetailsService {
    AccountRepository accountRepository;

    public Account getAccount(String accountId) {
        return accountRepository.findAccountByAccountID(accountId);
    }
    public Account addAccount(AccountRequest accountRequest){
        Account account = new Account();
        if (accountRepository.existsAccountByAccountID(accountRequest.getAccountID())) {
            return null;
        }
        account.setAccountID(accountRequest.getAccountID());
        account.setPassword(accountRequest.getPassword());
        long timestamp = System.currentTimeMillis();
        int timestampAsInt = (int) (timestamp / 1000);
        account.setCreationtime(timestampAsInt);
        accountRepository.save(account);
        return account;
    }
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    public void updateAccount(Account account){
        accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByAccountID(username);
        if (account == null) {
            throw new UsernameNotFoundException("Account not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (account.getAccountID().equals("logitex")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new org.springframework.security.core.userdetails.User(account.getAccountID(), account.getPassword(), authorities);
    }
}
