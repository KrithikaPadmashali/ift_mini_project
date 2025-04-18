package com.example.miniproj.entity;

import jakarta.persistence.*;


@Entity
public class Account {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private Double rate;

    @ManyToOne
    private Branch branch;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

    // getters, setters, constructors
    
}
