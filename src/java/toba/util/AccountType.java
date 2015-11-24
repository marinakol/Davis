package toba.util;

public class AccountType {
	public enum Type {
	    SAVING("saving"), CHECKING("checking");
	  
	    private String action;
	  
	    public String getAction(){
	        return this.action;
	    }
	    private Type(String action){
	        this.action = action;
	    }
	}
}

