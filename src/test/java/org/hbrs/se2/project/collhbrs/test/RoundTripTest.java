package org.hbrs.se2.project.collhbrs.test;

import org.hbrs.se2.project.collhbrs.control.RegistrationControl;
import org.hbrs.se2.project.collhbrs.datatypes.RegistrationResult;
import static org.junit.Assert.*;
import org.hbrs.se2.project.collhbrs.control.ProfileManager;
import org.hbrs.se2.project.collhbrs.dtos.CompanyDTO;
import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;
import org.hbrs.se2.project.collhbrs.dtos.impl.CompanyDTOImpl;
import org.hbrs.se2.project.collhbrs.dtos.impl.StudentDTOImpl;
import org.hbrs.se2.project.collhbrs.dtos.impl.UserDTOImpl;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoundTripTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationControl registrationService;
    @Autowired
    private ProfileManager profileManagerservice;

    private  static UserDTOImpl createUserDTO(String firstName, String lastName,String eMail,String userName,String password ){
        UserDTOImpl userDTOTest = new UserDTOImpl();
        userDTOTest.setFirstName(firstName);
        userDTOTest.setLastName(lastName);
        userDTOTest.seteMail(eMail);
        userDTOTest.setUsername(userName);
        userDTOTest.setPassword(password);
        return userDTOTest;
    }
    public static StudentDTOImpl createStudentDTO(Integer matrikelNr, String university, String degreeCourse){
        StudentDTOImpl newStudent = new StudentDTOImpl();
        newStudent.setMatrikelNr(matrikelNr);
        newStudent.setUniversity( university);
        newStudent.setDegreeCourse(degreeCourse);
        return newStudent;
    }
    public static CompanyDTOImpl createCompanyDTO(String company,String title,String roles,String description ){
        CompanyDTOImpl newCompany= new CompanyDTOImpl();
        newCompany.setCompany(company);
        newCompany.setTitle(title);
        newCompany.setRoles(roles);
        newCompany.setDescription(description);
        return newCompany;
    }
    // SUCCESSFUL User Registration
    @Test
    public void registerUser(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser= createUserDTO("Sarah","Linden","s.lind@smail.inf","slind","Abc1");
        RegistrationResult result = registrationService.createUser(testUser);
        assertEquals(true,result.isResult());

    }
    @Test
    public void registerUserWithoutUsername(){
        UserDTOImpl testuser = new UserDTOImpl();
        testuser.setFirstName("Jörgen");
        testuser.setLastName("Baum");
        testuser.seteMail("jörgen.baum@gmx.de");
        testuser.setPassword("Abc1");

        RegistrationResult result = registrationService.createUser(testuser);
        assertEquals("a mandatory field is empty",result.getResultDescription());

    }

    //Es ist momentan noch Möglich einen User doppelt einzuspeichern
    @Test
    public void registerExistingUser(){
        UserDTOImpl testuser = new UserDTOImpl();
        testuser.setFirstName("Sarah");
        testuser.setLastName("Linden");
        testuser.seteMail("s.lind@smail.inf");
        testuser.setUsername("slind");
        testuser.setPassword("Abc1");
        try{
            registrationService.createUser(testuser);
            fail();
        }catch(Exception e){
        }
    }
    //Es wird nicht erkannt das eine E-Mail falsch ist und der User wird erzeugt
    @Test
    public void registerWithFalseEmail(){
        UserDTOImpl testuser = new UserDTOImpl();
        testuser.setFirstName("Jörgen");
        testuser.setLastName("Baum");
        testuser.seteMail("jörgen.baum");
        testuser.setUsername("jbaum");
        testuser.setPassword("Abc1");
        try{
            registrationService.createUser(testuser);
            fail();
        }catch(Exception e){
        }
    }


    @Test
    public void registerWithoutPassword(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser=createUserDTO("Jörgen","Baum","jörgen.baum@gmx.de","jbaum","");
        RegistrationResult result = registrationService.createUser(testUser);
        assertEquals("a mandatory field is empty",result.getResultDescription());
    }
    @Test
    public void registerWithPasswordWithoutNumbers(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser=createUserDTO("Jörgen","Baum","jörgen.baum@gmx.de","jbaum","Baumchen");
        assertEquals("the password you chose is not secure (weak)",registrationService.createUser(testUser).getResultDescription());
    }
    @Test
    public void registerWithPasswordWithoutCapitalLetters(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser.setFirstName("Jörgen");
        testUser.setLastName("Baum");
        testUser.seteMail("jörgen.baum@gmx.de");
        testUser.setUsername("jbaum");
        testUser.setPassword("baumchen123");
        assertEquals("the password you chose is not secure (weak)",registrationService.createUser(testUser).getResultDescription());
    }
    @Test
    public void registerWithPasswordWithoutLetters(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser=createUserDTO("Jörgen","Baum","jörgen.baum@gmx.de","jbaum","56456456");
        assertEquals("the password you chose is not secure (weak)",registrationService.createUser(testUser).getResultDescription());
    }
    /*
    @Test
    public void createStudentProfileTest(){
        StudentDTOImpl testStudent = new StudentDTOImpl();
        testStudent = createStudentDTO(123456,"HBRS","Master");
        profileManagerservice.createStudentProfile(testStudent);
        assertEquals(true,profileManagerservice.checkIfProfileIsCreated());

    }
    @Test
    public void createCompanyProfileTest(){
        CompanyDTOImpl testComapny = new CompanyDTOImpl();
        testComapny = createCompanyDTO("Adesso","KG","Dienstleistungen","innovative solutions!");
        profileManagerservice.createCompanyProfile(testComapny);
        assertEquals(true,profileManagerservice.checkIfProfileIsCreated());

    }
    */




}
