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
        newUser.setUserTyp(userDTO.getUserTyp());
        newUser.setProfilePicture(userDTO.getProfilePicture());
        return newUser;
    }

    public Company createCompany(CompanyDTO companyDTO,UserDTO userDTO){

        Company newCompany = new Company();

        newCompany.setCompanyId(userDTO.getUserId());
        newCompany.setCompany(companyDTO.getCompany());
        newCompany.setDescription(companyDTO.getDescription());
        newCompany.setTitle(companyDTO.getTitle());
        newCompany.setRoles(companyDTO.getRoles());

        return newCompany;
    }

    public Student createStudent(StudentDTO studentDTO,UserDTO userDTO){

        Student newStudent = new Student();

        newStudent.setStudentId(userDTO.getUserId());
        newStudent.setMatrikelNr(studentDTO.getMatrikelNr());
        newStudent.setUniversity(studentDTO.getUniversity());
        newStudent.setDegreeCourse(studentDTO.getDegreeCourse());


        return newStudent;
    }

}
