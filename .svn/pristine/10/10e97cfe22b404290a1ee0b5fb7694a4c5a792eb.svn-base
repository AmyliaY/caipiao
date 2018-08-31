package com.util;



	   import javax.mail.Authenticator;
	   import javax.mail.PasswordAuthentication;

	 
	   public class SMTPAuthenticator extends Authenticator {
	   	private String name = "";
	   	private String password = "";

	   	public SMTPAuthenticator(String name, String password) {
	   		this.name = name;
	   		this.password = password;
	   	}

	   	public PasswordAuthentication getPasswordAuthentication() {
	   		return new PasswordAuthentication(name, password);
	   	}

	  
	     

} 
