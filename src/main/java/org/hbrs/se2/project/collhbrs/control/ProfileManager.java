package org.hbrs.se2.project.collhbrs.control;

import org.hbrs.se2.project.collhbrs.control.factories.UserFactory;
import org.hbrs.se2.project.collhbrs.dtos.CompanyDTO;
import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileManager {
    private boolean profile_created = true;

    UserFactory userFactory = new UserFactory();
    @Autowired
    private UserRepository userRepository;

    public boolean checkIfProfileIsCreated(){
        return profile_created;// TODO : must check if database contains a Student or Company profile assigned to a User ID instead of using the variable
    }
    public boolean isStudent(){
        return true;//TODO to be implemented
    }
    public boolean isCompany(){
        return false;//TODO has to be implemented
    }


    public void createStudentProfile(StudentDTO studentDTO){
        userFactory.createStudent(studentDTO);
        //TODO : use repository to save the entity
        profile_created = true;
    }

    public void createdCompanyProfile(CompanyDTO companyDTO){
        userFactory.createCompany(companyDTO);
        //TODO : use the repository to save the entity
        profile_created = true;
    }
    // Methode zum löschen eines Users
    // Achtung mögliche Exception ergänzen
    // Vergleich zwischen currentUser und dem Binder-element
    public boolean deleteUser(UserDTO userDTO, UserDTO current_user) {

        //Eingabe nicht erfolgreich
        //Eingabe erfolgreich
        // -> Löschen des Users aus der Datenbank
        if(userDTO.getUsername().equals(current_user.getUsername())
                && userDTO.getPassword().equals(current_user.getPassword())) {
            userRepository.deleteById(current_user.getUserId());
            // delete in Student/Company tables too ? what about related tables? Skills, Branches, Vacancies...

            return true;
        }
        else return false;
    }






}
