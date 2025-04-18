package com.example.miniproj.controller;

import org.springframework.web.bind.annotation.*;
import com.example.miniproj.service.BranchService;
import com.example.miniproj.entity.Account;
import com.example.miniproj.entity.Branch;
import java.util.List;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BranchController {

    @Autowired
    private BranchService service;

    @PutMapping("/rate/{branchId}")
    public ResponseEntity<String> updateRate(@PathVariable Long branchId, @RequestParam double rate) {
        service.updateRate(branchId, rate);
        return ResponseEntity.ok("Rate updated and propagated");
    }

    @PostMapping("/branch")
    public Branch createBranch(@RequestBody Branch branch) {
        return service.createBranch(branch);
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @GetMapping("/branches")
    public List<Branch> getBranches() {
        return service.getAllBranches();
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return service.getAllAccounts();
    }
}
