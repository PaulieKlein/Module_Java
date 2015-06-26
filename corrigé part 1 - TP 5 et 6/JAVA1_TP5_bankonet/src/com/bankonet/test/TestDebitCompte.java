package com.bankonet.test;

import java.util.ArrayList;
import java.util.Collection;

import com.bankonet.model.BankonetException;
import com.bankonet.model.CompteCourant;


public class TestDebitCompte {

	 public static void main(String[] args) {
		 
		 CompteCourant c1 = new CompteCourant(4, "compte courant 1", 0, 1000);
		 try {
			if (c1.debitAutorise(500)) {
				 c1.debiter(500);
			 }
		} catch (BankonetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	 
}
}
