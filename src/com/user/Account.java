package com.user;

import java.util.ArrayList;
import java.util.List;

public class Account implements java.io.Serializable {

	private String accountId;
	private String checkSave;
	private String odp;
	private String balance;
	private List<String> transactions = new ArrayList<>(0);

	public Account() {}

	public Account(String accountId, String checkSave, String odp, String balance, List<String> transactions) {

		this.accountId = accountId;
		this.checkSave = checkSave;
		this.odp = odp;
		this.balance = balance;
		this.transactions = transactions;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCheckSave() {
		return checkSave;
	}

	public void setCheckSave(String checkSave) {
		this.checkSave = checkSave;
	}

	public String getOdp() {
		return odp;
	}

	public void setOdp(String odp) {
		this.odp = odp;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public List<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<String> transactions) {
		this.transactions = transactions;
	}
	
	public void addTransaction(String transaction) {
	  this.transactions.add(transaction);
	}
	
	public String toString() {
		return "\nID: " + this.accountId + ", Type: " + this.checkSave + ", ODP: " + this.odp + ", Bal: $" + this.balance + ", Trans: "
				+ this.transactions + "\n";
	}
}
