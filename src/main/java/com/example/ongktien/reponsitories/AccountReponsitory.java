package com.example.ongktien.reponsitories;


import com.example.ongktien.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountReponsitory extends JpaRepository<Account,Long> {
}
