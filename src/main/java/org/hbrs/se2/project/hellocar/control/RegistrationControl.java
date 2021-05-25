package org.hbrs.se2.project.hellocar.control;

import org.hbrs.se2.project.hellocar.control.factories.UserFactory;
import org.hbrs.se2.project.hellocar.dtos.impl.UserDTO;
import org.hbrs.se2.project.hellocar.services.db.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hbrs.se2.project.hellocar.dtos.RegistrationResult;
import org.hbrs.se2.project.hellocar.entities.User;


@Component
public class RegistrationControl {
    public RegistrationControl() {
    }
    public RegistrationResult createUser(UserDTO userDTO){

        RegistrationResult dataCheck = checkRegistrationData(userDTO);
        if(dataCheck.isResult()){
            UserFactory userFactory = new UserFactory();
            User newUser = userFactory.createUser(userDTO);
            UserDB.saveUser(newUser);//todo implement method saveUser
            dataCheck.setSaved(true);
        }
        return dataCheck;
    }
    private RegistrationResult checkRegistrationData(UserDTO userDTO){
        RegistrationResult result = new RegistrationResult();
        if(userDTO.getUsername().isEmpty() || userDTO.getPassword().isEmpty() ){
            result.setResultDescription("a mandatory field is empty");
            result.setResult(false);
            return result;
        }
        if(!userDTO.getPassword().matches(".*[0-9].*") || !userDTO.getPassword().matches(".*[A-Z].*") || !userDTO.getPassword().matches(".*[a-z].*") )
        {// contains numbers , Capital letters and letters
            result.setResultDescription("the password you chose is not secure (weak)");
            result.setResult(false);
            return result;
        }
        result.setResultDescription("Correct Data");
        result.setResult(true);
        return result;
    }

}
