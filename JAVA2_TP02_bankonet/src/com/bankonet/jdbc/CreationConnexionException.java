package com.bankonet.jdbc;

/**
 * @author sysdeo
 * 
 * Exception levée lorsque la connexion ne peut être créée
 * <ul>
 * Résolution :
 * </ul>
 * <li>ajouter le driver dans le CLASSPATH</li>
 * <li>vérifier l'existence de l'utilisateur dans le référentiel</li>
 * <li>vérifier le format de l'URL</li>
 */
public class CreationConnexionException extends Exception {

    public CreationConnexionException() {
        super();
    }

    public CreationConnexionException(String message) {
        super(message);
    }
}