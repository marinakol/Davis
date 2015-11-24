package toba.business;

import java.math.BigDecimal;

import toba.util.AccountType.Type;

public class Account {
	
	public Type acctType;
	public BigDecimal balance;
	public User usr;

	public Account() {
	}
	
	public Account(User usr, BigDecimal balance, Type acctType) {
		this.usr = usr;
		this.balance = balance;
		this.acctType = acctType;
	}
	
	public void credit( BigDecimal creditAmount) {
		balance.add( creditAmount);
	}
	public void debit( BigDecimal debitAmount) {
		balance.subtract( debitAmount);
	}
	
	public Type getAccountType() {
		return acctType;
	}
	public void setAccountType( Type acctType) {
		this.acctType = acctType;
	}
	
	public BigDecimal getBalance() {
		return this.balance;
	}
	public void setBalance( BigDecimal balance) {
		this.balance = balance;
	}
	
	public User getUser() {
		return this.usr;
	}
	public void setUser( User usr) {
		this.usr = usr;
	}
}

