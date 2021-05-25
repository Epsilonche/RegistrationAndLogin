package org.hbrs.se2.project.collHbrs.control.factories;
import org.hbrs.se2.project.collHbrs.dtos.impl.UserDTO;
import org.hbrs.se2.project.collHbrs.entities.User;

public class UserFactory {
    static int current_id=0;
    public User createUser(UserDTO userDTO){
        User newUser = new User();
        newUser.setId(++current_id);
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());
        newUser.setFirst_name(userDTO.getFirst_name());
        newUser.setLast_name(userDTO.getLast_name());
        newUser.setEmail(userDTO.getEmail());


        return newUser;
    }
}