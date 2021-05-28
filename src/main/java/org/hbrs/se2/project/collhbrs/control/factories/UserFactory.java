package org.hbrs.se2.project.collhbrs.control.factories;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.entities.User;

public class UserFactory {

    public User createUser(UserDTO userDTO){
        User newUser = new User();

        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.seteMail(userDTO.geteMail());
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());

        newUser.setUserTypeId(1);//TODO: set User Type Id to the appropriate type id ( What is UsertypeId?)

        return newUser;
    }
}
