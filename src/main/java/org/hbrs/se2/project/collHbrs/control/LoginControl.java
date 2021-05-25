package org.hbrs.se2.project.collHbrs.control;

import org.hbrs.se2.project.collHbrs.control.exception.DatabaseUserException;
import org.hbrs.se2.project.collHbrs.dao.UserDAO;
import org.hbrs.se2.project.collHbrs.dtos.UserDTO;
import org.hbrs.se2.project.collHbrs.repository.UserRepository;
import org.hbrs.se2.project.collHbrs.services.db.exceptions.DatabaseLayerException;
import org.hbrs.se2.project.collHbrs.util.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Von Micha überarbeitet
// Login mit JDBC

@Component
public class LoginControl {

    @Autowired
    private UserRepository repository;

    private UserDTO userDTO = null;

        public boolean authentificate(String username, String password ) throws DatabaseUserException {
        //UserDTO tmpUser = this.getUserWithJPA( username , password );

        UserDTO tmpUser = this.getUserWithJDBC( username , password );

        if ( tmpUser == null ) {
            System.out.println("User = NULL");
            return false;
        }
        this.userDTO = tmpUser;
        return true;
    }

    public UserDTO getCurrentUser(){
        return this.userDTO;

    }

    private UserDTO getUserWithJDBC( String username , String password ) throws DatabaseUserException {
        UserDTO userTmp = null;
        UserDAO dao = new UserDAO();
        try {
            userDTO = dao.findUserByUseridAndPassword( username , password );
        }
        catch ( DatabaseLayerException e) {

            String reason = e.getReason();

            // Nutzer nicht gefunden
            if (reason.equals(Globals.Errors.NOUSERFOUND)) {
                throw new DatabaseUserException("Es wurde kein Nutzer unter diesen Daten gefunden!");
                //return userTmp;
            }
            // SQL Fehler
            else if ( reason.equals((Globals.Errors.SQLERROR))) {
                throw new DatabaseUserException("Ein SQL-Fehler ist aufgetreten. Bitte den Admin kontaktieren!");
            }
            // DB Connection fehlgeschlagen
            else if ( reason.equals((Globals.Errors.DATABASE ) )) {
                throw new DatabaseUserException("Es konnte keine Verbindung zur Datenbank hergestellt werden!");
            }
            // Anderer/unbekannter Fehler
            else {
                throw new DatabaseUserException("Unbekannter Fehler aufgetreten. Bitte den Admin kontaktieren!");
            }

        }
        return userDTO;
    }

    /*private UserDTO getUserWithJPA( String username , String password ) throws DatabaseUserException {
        UserDTO userTmp;
        try {
            userTmp = repository.findUserByUseridAndPassword(username, password);
        } catch ( org.springframework.dao.DataAccessResourceFailureException e ) {
            // Analyse und Umwandlung der technischen Errors in 'lesbaren' Darstellungen (ToDo!)
           throw new DatabaseUserException("A failure occured while trying to connect to database with JPA");
        }
        return userTmp;
    }*/

}
