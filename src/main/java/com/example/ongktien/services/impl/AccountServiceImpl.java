package com.example.ongktien.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.ongktien.models.Account;
import com.example.ongktien.reponsitories.AccountReponsitory;
import com.example.ongktien.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountReponsitory accountReponsitory;
    @Override
    public boolean AddAccount(Account account) {
        accountReponsitory.save(account);
        return true;
    }
}
