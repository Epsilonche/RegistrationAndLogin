package org.hbrs.se2.project.collhbrs.control;

import org.hbrs.se2.project.collhbrs.control.exception.DatabaseUserException;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Von Micha Ã¼berarbeitet
// Login mit JPA

@Component
public class LoginControl {

    @Autowired
    private UserRepository repository;

    private UserDTO userDTO = null;

    public boolean authentificate(String username, String password ) throws DatabaseUserException {
        UserDTO tmpUser = this.getUserWithJPA( username , password );

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

    private UserDTO getUserWithJPA( String username , String password ) throws DatabaseUserException {
        UserDTO userTmp;
        try {
            userTmp = repository.findUserByUsernameAndPassword(username, password);
        } catch ( org.springframework.dao.DataAccessResourceFailureException e ) {

            // Analyse und Umwandlung der technischen Errors in 'lesbaren' Darstellungen

            throw new DatabaseUserException("A failure occured while trying to connect to database with JPA");
        }
        return userTmp;
    }

}

