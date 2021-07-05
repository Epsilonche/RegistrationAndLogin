package org.hbrs.se2.project.collhbrs.control;
import org.hbrs.se2.project.collhbrs.control.factories.UserFactory;
import org.hbrs.se2.project.collhbrs.datatypes.RegistrationResult;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hbrs.se2.project.collhbrs.entities.User;

@Component
public class RegistrationControl {

    @Autowired
    private UserRepository repository;
    private UserFactory userFactory = new UserFactory();

    public RegistrationResult createUser(UserDTO userDTO){

        RegistrationResult dataCheck = checkRegistrationData(userDTO);
        if(dataCheck.isResult()){
            User newUser = userFactory.createUser(userDTO);
            this.repository.save(newUser);
            dataCheck.setSaved(true);
        }
        return dataCheck;
    }
    private RegistrationResult checkRegistrationData(UserDTO userDTO){
        //TODO muss erweitert werden
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
