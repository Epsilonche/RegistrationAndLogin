package org.hbrs.se2.project.collhbrs.control;

import org.hbrs.se2.project.collhbrs.control.exception.DatabaseUserException;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// von Michael Klein abgeändert und kommentiert

@Component
public class LoginControl {

    @Autowired
    // Erstellung eines UserRepositorys
    private UserRepository repository;
    // Erstellung eines UserDTOs
    private UserDTO userDTO = null;

    //Methode zur Überprüfung der Logindaten per JPA
    //wenn tmpUser nach Ausführung der Methode "getUserWithJPA" leer bleibt, wird boolean false returned und der Loginprozess abgebrochen.
    //Andernfalls wird das UserDTO tmpUser in userDTO gespeichert und ein boolean true zurückgegeben
    public boolean authentificate(String username, String password ) throws DatabaseUserException {
        UserDTO tmpUser = this.getUserWithJPA( username , password );
        //Login nicht erfolgreich
        if ( tmpUser == null ) {
            return false;
        }
        //Login erfolgreich
        this.userDTO = tmpUser;
        return true;
    }
    // Klassische Getter-Methode, um ein UserDTO Objekt zu returnen
    public UserDTO getCurrentUser(){
        return this.userDTO;

    }
    // UserDaten mit Daten aus Datenbank vergleichen
    //Es wird ein UserDTO Objekt erzeugt und geschaut, ob die Logindaten per repository.findUserByUsernameAndPassword(username, password) Methode in der Datenbank gefunden werden können
    //Falls die Ausführung der Methode fehlschlägt, wird eine DataAcessResourceFailureException gecatched und eine DatabaseUserException ausgegeben
    private UserDTO getUserWithJPA( String username , String password ) throws DatabaseUserException {
        UserDTO userTmp;
        try {
            userTmp = repository.findUserByUsernameAndPassword(username, password);
        } catch ( org.springframework.dao.DataAccessResourceFailureException e ) {
            throw new DatabaseUserException("Bei dem Verbindungsaufbau zur Datenbank ist ein Fehler aufgetreten!");
        }
        return userTmp;
    }

}

