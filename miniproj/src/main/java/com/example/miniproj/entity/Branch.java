package com.example.miniproj.entity;
//import com.example.miniproj.entity.Account;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
@Entity
public class Branch {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private Double rate;

    @ManyToOne
    private Branch parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Branch> children = new ArrayList<>();

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

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

	public Branch getParent() {
		return parent;
	}

	public void setParent(Branch parent) {
		this.parent = parent;
	}

	public List<Branch> getChildren() {
		return children;
	}

	public void setChildren(List<Branch> children) {
		this.children = children;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

    // getters, setters, constructors
    
}
