package com.bankonet.jdbc;

/**
 * @author sysdeo
 * 
 * Exception lev�e lorsque la connexion ne peut �tre cr��e
 * <ul>
 * R�solution :
 * </ul>
 * <li>ajouter le driver dans le CLASSPATH</li>
 * <li>v�rifier l'existence de l'utilisateur dans le r�f�rentiel</li>
 * <li>v�rifier le format de l'URL</li>
 */
public class CreationConnexionException extends Exception {

    public CreationConnexionException() {
        super();
    }

    public CreationConnexionException(String message) {
        super(message);
    }
}