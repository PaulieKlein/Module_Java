package com.bankonet.model;

public class CreditException extends Exception{
	public CreditException(){
		super();
	}
	public CreditException(String _message) {
		super(_message);
	}
}
