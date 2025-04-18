package com.example.miniproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.miniproj.entity.Branch;
public interface BranchRepository extends JpaRepository<Branch, Long> {}
