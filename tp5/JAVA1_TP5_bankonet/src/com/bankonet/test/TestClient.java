package com.bankonet.test;
import com.bankonet.model.Client;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;
public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CompteCourant compteCourant1 = new CompteCourant(1,"courant1",-100F,10F);
		CompteCourant compteCourant2 = new CompteCourant(2,"courant2",200F,20F);
		CompteCourant compteCourant3 = new CompteCourant(3,"courant3",300F,5F);
		
		CompteEpargne compteEpargne1 = new CompteEpargne("E1","epargne1",1000,10);
		CompteEpargne compteEpargne2 = new CompteEpargne("E2","epargne2",200,5);
		CompteEpargne compteEpargne3 = null;
		
		
		Client client1 = new Client("id1","klein1","pauline1",compteCourant1,compteEpargne1);
		Client client2 = new Client("id2","klein2","pauline2",compteCourant2,compteEpargne2);
		Client client3 = new Client("id3","klein3","pauline3",compteCourant3, compteEpargne3);
		
		Client [] clientTab =  {client1,client2,client3};
		
	
		for(int i = 0;i<clientTab.length;i++) {
			if ( clientTab[i].getCompteCourant()==null){
				System.out.println("vous n'avez pas de compte courant ,\n le compte épargne \n " + 
					clientTab[i].getCompteEpargne().toString()+
				    " et le solde total est :" + clientTab[i].calculerAvoirGlobal()+ "\n");
				
			}else if (clientTab[i].getCompteEpargne()==null){
				System.out.println("le compte courant :\n "+clientTab[i].getCompteCourant().toString() +" ,\n vous n'avez pas de compte épargne "+
					    " et le solde total est :" + clientTab[i].calculerAvoirGlobal()+ "\n");
			} else {
			
			System.out.println("le compte courant :\n "+clientTab[i].getCompteCourant().toString() +" ,\n le compte épargne \n " + 
		clientTab[i].getCompteEpargne().toString()+
	    " et le solde total est :" + clientTab[i].calculerAvoirGlobal()+ "\n");
			}
		
		}
	}

}
