package toba.business;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import toba.util.AccountType;
@Entity
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private Long transId;
	private User user;
	private String fromType;
	private String toType;
	private BigDecimal amount;
	
        public Transaction() {
        }
        
	public Transaction( User user, AccountType fromType, AccountType toType, BigDecimal amount) {
		this.user = user;
		this.fromType = ( fromType == AccountType.SAVING) ? "SAVINGS" : "CHECKING";
		this.toType = ( toType == AccountType.SAVING) ? "SAVINGS" : "CHECKING";
		this.amount = amount;
	}
	
	public User getUser() {
		return this.user;
	}
	public void setUser( User user) {
		this.user = user;
	}
	
	public String getFromType() {
		return this.fromType;
	}
	public void setFromType( String fromType) {
		this.fromType = fromType;
	}
	
	public String getToType() {
		return this.toType;
	}
	public void setToType( String toType) {
		this.toType = toType;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}
	public void setAmount( BigDecimal amount) {
		this.amount = amount;
	}
	
}
