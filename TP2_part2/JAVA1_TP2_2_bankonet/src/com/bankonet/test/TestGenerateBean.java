package com.bankonet.test;

import java.lang.reflect.Method;
import java.util.*;

import com.bankonet.model.*;

public class TestGenerateBean {

	public void generateBeanInstance(Client client){
		
		Map clientData = getClientData();
		Set clientDataKeys = clientData.keySet();
		Iterator clientDataKeysIte = clientDataKeys.iterator();
		try {
			Class clientClass = client.getClass();
			while(clientDataKeysIte.hasNext()){
			String key  =(String) clientDataKeysIte.next();
			Class[] parameterTypes = new Class[] {clientData.get(key).getClass()};
			String methodName = "set" + key;
			Method setterMethod = clientClass.getMethod(methodName,parameterTypes);
			Object[] arguments = new Object[] {getClientData().get(key)};
			System.out.println("Invocation de la mthode trouvée("+ setterMethod + ")...");
			setterMethod.invoke(client, arguments);
			
			}
			System.out.println(" ");
			System.out.println("2ème méthode d'instanciation(par réflexion avec la méthode generateBeanInstance :");
			System.out.println(" ");
			//this.print(client);
		} catch(Exception e){
			System.out.println("Construction de l'objet impossible");
		}
	}
	
	public Map getClientData() {
		Map dataBeans = new HashMap();
		dataBeans.put("Identifiant", new Integer(43));
		dataBeans.put("Prenom", "Marcel");
		dataBeans.put("Nom", "Aymé");
		return dataBeans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGenerateBean gb =  new TestGenerateBean();
		Client client = new Client("","","");
		gb.generateBeanInstance(client);
		//gb.generateBean(client);
	}

}
