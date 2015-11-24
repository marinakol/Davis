package toba.business;

import java.math.BigDecimal;

import toba.util.AccountType;

public class Transaction {
	private User user;
	private AccountType.Type fromType;
	private AccountType.Type toType;
	private BigDecimal amount;
	
	public Transaction( User user, AccountType.Type fromType, AccountType.Type toType, BigDecimal amount) {
		this.user = user;
		this.fromType = fromType;
		this.toType = toType;
		this.amount = amount;
	}
	
	public User getUser() {
		return this.user;
	}
	public void setUser( User user) {
		this.user = user;
	}
	
	public AccountType.Type getFromType() {
		return this.fromType;
	}
	public void setFromType( AccountType.Type fromType) {
		this.fromType = fromType;
	}
	
	public AccountType.Type getToType() {
		return this.toType;
	}
	public void setToType( AccountType.Type toType) {
		this.toType = toType;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}
	public void setAmount( BigDecimal amount) {
		this.amount = amount;
	}
	
}
