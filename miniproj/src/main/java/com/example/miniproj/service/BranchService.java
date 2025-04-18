package com.example.miniproj.service;
import com.example.miniproj.entity.Account;
import com.example.miniproj.entity.Branch;
import com.example.miniproj.repository.BranchRepository;
import com.example.miniproj.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepo;

    @Autowired
    private AccountRepository accountRepo;

    public void updateRate(Long branchId, double newRate) {
        Branch branch = branchRepo.findById(branchId).orElseThrow();
        applyRateRecursive(branch, newRate);
    }

    private void applyRateRecursive(Branch branch, double newRate) {
        branch.setRate(newRate);
        for (Account acc : branch.getAccounts()) {
            acc.setRate(newRate);
        }
        accountRepo.saveAll(branch.getAccounts());

        for (Branch child : branch.getChildren()) {
            applyRateRecursive(child, newRate);
        }
        branchRepo.save(branch);
    }

    public List<Branch> getAllBranches() {
        return branchRepo.findAll();
    }

    public Branch createBranch(Branch branch) {
        return branchRepo.save(branch);
    }

    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }
}
