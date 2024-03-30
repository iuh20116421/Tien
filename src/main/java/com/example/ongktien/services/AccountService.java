package com.example.ongktien.services;
import com.example.ongktien.models.Account;
import org.springframework.stereotype.Service;
@Service
public interface AccountService {
    public boolean AddAccount(Account account);
}
