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

        Company newCompany = new Company();

        newCompany.setCompany(companyDTO.getCompany());
        newCompany.setDescription(companyDTO.getDescription());
        newCompany.setTitle(companyDTO.getTitle());
        newCompany.setRoles(companyDTO.getRoles());

        return newCompany;
    }

    public Student createStudent(StudentDTO studentDTO){
        Student newStudent = new Student();

        newStudent.setMatrikelNr(studentDTO.getMatrikelNr());
        newStudent.setUniversity(studentDTO.getUniversity());
        newStudent.setDegreeCourse(studentDTO.getDegreeCourse());

        return newStudent;
    }
}
