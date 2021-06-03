package org.hbrs.se2.project.collhbrs.control;

import org.hbrs.se2.project.collhbrs.control.factories.UserFactory;
import org.hbrs.se2.project.collhbrs.dtos.CompanyDTO;
import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfileManager {
    private boolean profile_created = false;

    UserFactory userFactory = new UserFactory();

    public boolean checkIfProfileIsCreated(){
        return profile_created;// TODO : must check if database contains a Student or Company profile assigned to a User ID instead of using the variable
    }
    public boolean isStudent(){
        return false;//TODO to be implemented
    }
    public boolean isCompany(){
        return true;//TODO has to be implemented
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




}
