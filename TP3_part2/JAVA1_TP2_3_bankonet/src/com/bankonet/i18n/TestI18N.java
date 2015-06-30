package com.bankonet.i18n;

import java.util.*; 
import java.text.*;

public class TestI18N {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String language;	
		String country;   
		language = new String("en");	
		country = new String("US");          
		Locale currentLocale = new Locale(language, country);
		ResourceBundle bundleFr = ResourceBundle.getBundle("com.bankonet.i18n.resources", currentLocale);

		System.out.println(bundleFr.getString("WELCOME"));

		DateFormat dFormat;
		dFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
		Date today = new Date();
		String dateOut = dFormat.format(today);
		System.out.println( dateOut + " " + currentLocale.toString());
		
	}

}
