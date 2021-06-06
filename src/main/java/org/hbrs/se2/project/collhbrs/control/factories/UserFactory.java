package org.hbrs.se2.project.collhbrs.control.factories;
import org.hbrs.se2.project.collhbrs.dtos.CompanyDTO;
import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.entities.Company;
import org.hbrs.se2.project.collhbrs.entities.Student;
import org.hbrs.se2.project.collhbrs.entities.User;

public class UserFactory {

    public User createUser(UserDTO userDTO){
        User newUser = new User();

        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.seteMail(userDTO.geteMail());
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());

        //newUser.setUserTypeId(1);//TODO: set User Type Id to the appropriate type id ( What is UsertypeId?)

        return newUser;
    }

    public Company createCompany(CompanyDTO companyDTO){
        return null;//TODO must create a Company entity
    }

    public Student createStudent(StudentDTO studentDTO){
        return null;//TODO must create a Student entity
    }

}
