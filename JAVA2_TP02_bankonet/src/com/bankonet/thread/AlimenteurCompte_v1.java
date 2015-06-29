package com.bankonet.thread;

import com.bankonet.model.Compte;

public class AlimenteurCompte_v1 implements Runnable {
	private Float somme;
	private Integer timer;
	private Compte compte;

	public AlimenteurCompte_v1(Compte compte, Float somme, Integer timer) {
		this.compte = compte;
		this.somme = somme;
		this.timer = timer;
	}

	public void run() {
		
		Float solde = compte.getSolde();
		System.out.println("Thread (" + this.toString()
				+ ") Solde du compte = " + solde);
			
		//Sleep pour laisser le temps au deuxième thread de démarrer et de récupérer
		//le meme solde en entree
		try {
			Thread.sleep(timer.intValue());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Mise à jour du solde du compte
		compte.setSolde(new Float(solde.floatValue() + somme.floatValue()));
		System.out.println("Thread (" + this.toString()
				+ ") Solde mis à jour = " + compte.getSolde());
	}
}