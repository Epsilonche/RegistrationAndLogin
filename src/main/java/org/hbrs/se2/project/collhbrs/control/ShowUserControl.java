package org.hbrs.se2.project.collhbrs.control;
/*
*   Klasse für das Einarbeiten in JPA
*   Autor : Othman
*   Übergangsweise
 */
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowUserControl {
    @Autowired
    private UserRepository repository;

    /* Add a nested comment explaining why this method is empty, throw an UnsupportedOperationException or complete the implementation.
    unused, because of that commet out
    public ShowUserControl() {
    }
    */
    public List<UserDTO> readAllUsers() {

        return this.repository.findUsersByUserIdIsNotNull();
    }
}
