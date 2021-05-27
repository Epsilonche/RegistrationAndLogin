package org.hbrs.se2.project.hellocar.control;
/*
*   Klasse für das Einarbeiten in JPA
*   Autor : Othman
*   Übergangsweise
 */
import org.hbrs.se2.project.hellocar.dtos.impl.UserDTO;
import org.hbrs.se2.project.hellocar.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowUserControl {
   // @Autowired
    private UserRepository repository;

    public ShowUserControl() {
    }

    public List<UserDTO> readAllUsers() {
        return repository.findAllUsers();
    }
}
