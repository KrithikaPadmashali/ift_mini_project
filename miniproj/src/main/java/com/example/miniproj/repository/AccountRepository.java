package com.example.miniproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.miniproj.entity.Account;
public interface AccountRepository extends JpaRepository<Account, Long> {}
