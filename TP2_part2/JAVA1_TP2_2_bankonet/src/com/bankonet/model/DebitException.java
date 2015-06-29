package com.bankonet.model;

public class DebitException extends Exception {
	
	public DebitException(){
		super();
	}
	public DebitException(String _message) {
		super(_message);
	}
}
