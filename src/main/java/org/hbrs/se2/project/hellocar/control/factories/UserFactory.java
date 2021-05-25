package org.hbrs.se2.project.hellocar.control.factories;
import org.hbrs.se2.project.hellocar.dtos.impl.UserDTO;
import org.hbrs.se2.project.hellocar.entities.User;

public class UserFactory {
    static int current_id=0;
    public User createUser(UserDTO userDTO){
        User newUser = new User();
        newUser.setId(++current_id);
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());

        return newUser;
    }
}