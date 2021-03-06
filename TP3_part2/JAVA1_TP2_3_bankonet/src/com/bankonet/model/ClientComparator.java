package com.bankonet.model;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ClientComparator implements Comparator {
	
	public int compare(Object o1,Object o2){
		if(!(o1 instanceof Client))
			throw new ClassCastException();
		if(!(o2 instanceof Client))
			throw new ClassCastException();
		String nom1 = ((Client)o1).getNom().toUpperCase();
		String prenom1 = ((Client)o1).getPrenom().toUpperCase();
		String nom2 = ((Client)o2).getNom().toUpperCase();
		String prenom2 = ((Client)o2).getPrenom().toUpperCase();
		
		int retour = prenom1.compareTo(prenom2);
		if(retour==0)retour = nom1.compareTo(nom2);
		return retour ;
	}
}
