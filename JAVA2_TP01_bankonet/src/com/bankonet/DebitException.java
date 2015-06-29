package com.bankonet;

/**
 * Classe utilisee pour lancer les exceptions liees à la partie "metier"
 * de l'application Bankonet.
 * 
 * @author fguibert
 */
public class DebitException extends Exception {

	public DebitException()
	{
		super();
	}
	
	public DebitException(String _message) {
		super(_message);
	}
	
}
