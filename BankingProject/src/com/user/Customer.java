package com.user;

import java.util.ArrayList;
import java.util.List;

public class Customer implements java.io.Serializable {

	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private String password;
	private List<Account> accounts = new ArrayList<>(0);
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, String email, Address address, String password, List<Account> accounts) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.password = password;
		this.accounts = accounts;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
	  this.accounts.add(account);
	}
	
	public String toString() {
		return "First Name: " + this.firstName + " Last Name: "+ this.lastName + " Email: " + this.email + " Address: " + this.address + " Password: " + this.password
		+ " Accounts: " + this.accounts;
	}
	
	public Account getAccountById(String accountId) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accountId.equalsIgnoreCase(accounts.get(i).getAccountId())) {
				
					return accounts.get(i);
				}
			 }
			return null;
	}

}
