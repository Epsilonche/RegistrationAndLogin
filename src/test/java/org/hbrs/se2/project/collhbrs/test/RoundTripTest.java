package org.hbrs.se2.project.collhbrs.test;

import org.hbrs.se2.project.collhbrs.control.RegistrationControl;
import org.hbrs.se2.project.collhbrs.control.factories.UserFactory;
import org.hbrs.se2.project.collhbrs.datatypes.RegistrationResult;
import static org.junit.Assert.*;
import org.hbrs.se2.project.collhbrs.control.ProfileManager;
import org.hbrs.se2.project.collhbrs.dtos.CompanyDTO;
import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.dtos.impl.CompanyDTOImpl;
import org.hbrs.se2.project.collhbrs.dtos.impl.StudentDTOImpl;
import org.hbrs.se2.project.collhbrs.dtos.impl.UserDTOImpl;
import org.hbrs.se2.project.collhbrs.entities.Company;
import org.hbrs.se2.project.collhbrs.entities.Student;
import org.hbrs.se2.project.collhbrs.entities.User;
import org.hbrs.se2.project.collhbrs.repository.CompanyRepository;
import org.hbrs.se2.project.collhbrs.repository.StudentRepository;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoundTripTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    private UserFactory userFactory = new UserFactory();

    @Autowired
    private RegistrationControl registrationService;
    @Autowired
    private ProfileManager profileManagerservice;



    @Test
    public void testCRUDUser(){
        User new_user = new User();
        new_user.seteMail("test@gmail.com");
        new_user.setUsername("testUsername");
        new_user.setFirstName("testfirstName");
        new_user.setPassword("testPassworD123");
        new_user.setLastName("testlastName");
        new_user.setUserTyp("Student");

        //CREATE
        userRepository.save(new_user);

        //READ
        UserDTO fetchedUserDTO = userRepository.findUserByUsernameAndPassword(new_user.getUsername(),new_user.getPassword());
        User fetchedUser = userRepository.findByUserId(fetchedUserDTO.getUserId());
        assertEquals(fetchedUser,new_user);

        //DELETE
        userRepository.delete(new_user);
        fetchedUser = userRepository.findByUserId(fetchedUserDTO.getUserId());
        assertNull(fetchedUser);

    }
    @Test
    public void testCRUDStudent(){
        //user
        User new_user = new User();
        new_user.seteMail("test@gmail.com");
        new_user.setUsername("testUsername");
        new_user.setFirstName("testfirstName");
        new_user.setPassword("testPassworD123");
        new_user.setLastName("testlastName");
        new_user.setUserTyp("Student");
        userRepository.save(new_user);
        //student is a user
        UserDTO fetchedUserDTO = userRepository.findUserByUsernameAndPassword(new_user.getUsername(),new_user.getPassword());
        Student new_student = new Student();
        new_student.setStudentId(fetchedUserDTO.getUserId());


        //CREATE
        studentRepository.save(new_student);

        //READ
        Student fetchedStudent = studentRepository.findByStudentId(fetchedUserDTO.getUserId());
        assertEquals(fetchedStudent,new_student);

        //DELETE
        studentRepository.delete(new_student);
        fetchedStudent = studentRepository.findByStudentId(fetchedUserDTO.getUserId());
        assertNull(fetchedStudent);

        //DELETE USER AFTER USE
        userRepository.delete(new_user);

    }
    @Test
    public void testCRUDCompany(){
        //user
        User new_user = new User();
        new_user.seteMail("test@gmail.com");
        new_user.setUsername("testUsername");
        new_user.setFirstName("testfirstName");
        new_user.setPassword("testPassworD123");
        new_user.setLastName("testlastName");
        new_user.setUserTyp("Unternehmen");
        userRepository.save(new_user);
        //company is a user
        UserDTO fetchedUserDTO = userRepository.findUserByUsernameAndPassword(new_user.getUsername(),new_user.getPassword());
        Company new_company = new Company();
        new_company.setCompanyId(fetchedUserDTO.getUserId());


        //CREATE
        companyRepository.save(new_company);

        //READ
        Company fetchedStudent = companyRepository.findByCompanyId(fetchedUserDTO.getUserId());
        assertEquals(fetchedStudent,new_company);

        //DELETE
        companyRepository.delete(new_company);
        fetchedStudent = companyRepository.findByCompanyId(fetchedUserDTO.getUserId());
        assertNull(fetchedStudent);
        //DELETE USER AFTER USE
        userRepository.delete(new_user);

    }

}
