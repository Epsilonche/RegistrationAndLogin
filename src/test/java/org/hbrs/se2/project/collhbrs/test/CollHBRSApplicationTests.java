package org.hbrs.se2.project.collhbrs.test;


import org.hbrs.se2.project.collhbrs.control.LoginControl;
import org.hbrs.se2.project.collhbrs.control.RegistrationControl;
import org.hbrs.se2.project.collhbrs.control.VacancyManager;
import org.hbrs.se2.project.collhbrs.control.exception.DatabaseUserException;
import org.hbrs.se2.project.collhbrs.control.factories.UserFactory;
import org.hbrs.se2.project.collhbrs.datatypes.RegistrationResult;
import static org.junit.Assert.*;
import org.hbrs.se2.project.collhbrs.control.ProfileManager;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.dtos.VacDTO;
import org.hbrs.se2.project.collhbrs.dtos.impl.UserDTOImpl;
import org.hbrs.se2.project.collhbrs.dtos.impl.VacDTOImpl;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.hbrs.se2.project.collhbrs.repository.VacancyRepository;
import org.hbrs.se2.project.collhbrs.util.Utils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CollHBRSApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private LoginControl loginControl;
    @Autowired
    private VacancyManager vacancyManager;

    boolean isAuthenticated = false;

    private UserFactory userFactory = new UserFactory();

    @Autowired
    private RegistrationControl registrationService;
    @Autowired
    private ProfileManager profileManagerservice;

    private UserDTO testUserCreate() {
        UserDTOImpl testUser = new UserDTOImpl();
        testUser= createUserDTO("Sarah","Linden","s.lind@smail.inf","slind","Abc1","Student");
        return testUser;
    }
    private static UserDTOImpl createUserDTO(String firstName, String lastName,String eMail,String userName,String password,String user_typ ){
        UserDTOImpl userDTOTest = new UserDTOImpl();
        userDTOTest.setFirstName(firstName);
        userDTOTest.setLastName(lastName);
        userDTOTest.seteMail(eMail);
        userDTOTest.setUsername(userName);
        userDTOTest.setPassword(password);
        userDTOTest.setUserTyp(user_typ);
        return userDTOTest;
    }


    //Erfolgreiche Registrierung
    @Order(1)
    @Test
    public void registerUser(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser= createUserDTO("Sarah","Linden","s.lind@smail.inf","slind","Abc1","Student");
        RegistrationResult result = registrationService.createUser(testUser);
        UserDTO user = userRepository.findUserByUsernameAndPassword(testUser.getUsername(),testUser.getPassword());
        assertTrue(result.isResult());
        assertTrue(result.isSaved());
        assertEquals(testUser.getFirstName(),user.getFirstName());
        assertEquals(testUser.getLastName(),user.getLastName());
        assertEquals(testUser.geteMail(),user.geteMail());
        assertEquals(testUser.getUserTyp(),user.getUserTyp());
        assertEquals(testUser.getProfilePicture(),user.getProfilePicture());
        assertFalse(profileManagerservice.checkIfCompanyProfileIsCreated(testUserCreate()));


    }
    //Fehlerhafte Registrierung durch falsche Eingabe
    /*
    @Test
    public void registerUserWithoutUsername(){
        UserDTOImpl testuser = new UserDTOImpl();
        testuser.setFirstName("Jörgen");
        testuser.setLastName("Baum");
        testuser.seteMail("jörgen.baum@gmx.de");
        testuser.setPassword("Abc1");
        testuser.setUsername("");
        RegistrationResult result = registrationService.createUser(testuser);
        assertEquals("Ein notwendiges Feld (Username, Passwort) ist leer!",result.getResultDescription());

    }
    @Test
    public void registerWithoutPassword(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser=createUserDTO("Jörgen","Baum","jörgen.baum@gmx.de","jbaum","","Student");
        RegistrationResult result = registrationService.createUser(testUser);
        assertEquals("Ein notwendiges Feld (Username, Passwort) ist leer!",result.getResultDescription());
    }
    @Test
    public void registerWithPasswordWithoutNumbers(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser=createUserDTO("Jörgen","Baum","jörgen.baum@gmx.de","jbaum","Baumchen","Student");
        assertEquals("Das Passwort muss aus Zahlen, großen und kleinen Buchstaben bestehen!",registrationService.createUser(testUser).getResultDescription());
    }

    @Test
    public void registerWithPasswordWithoutCapitalLetters(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser=createUserDTO("Jörgen","Baum","jörgen.baum@gmx.de","jbaum","baumchen123","Student");
        assertEquals("Das Passwort muss aus Zahlen, großen und kleinen Buchstaben bestehen!",registrationService.createUser(testUser).getResultDescription());
    }
    @Test
    public void registerWithPasswordWithoutLetters(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser=createUserDTO("Jörgen","Baum","jörgen.baum@gmx.de","jbaum","56456456","Student");
        assertEquals("Das Passwort muss aus Zahlen, großen und kleinen Buchstaben bestehen!",registrationService.createUser(testUser).getResultDescription());
    }

    @Test
    public void registerWithoutDataInput(){
        UserDTOImpl testUser = new UserDTOImpl();
        testUser=createUserDTO("Jörgen","Baum","jörgen.baum@gmx.de","","","Student");
        RegistrationResult result = registrationService.createUser(testUser);
        assertEquals("Ein notwendiges Feld (Username, Passwort) ist leer!",result.getResultDescription());
    }
    */
    //Erfolgreicher Login
    @Test
    @Order(2)
    public void loginUser() {
        try {
            isAuthenticated = loginControl.authentificate( "slind" , "Abc1" );

        } catch (Exception exception) {

        }
        assertEquals(true,isAuthenticated);

    }
    //Fehlerhafter Login durch falsche Eingabe
    @Test
    public void loginUserWithWrongPassword(){
        try {
            isAuthenticated = loginControl.authentificate( "slind" , "abc1" );

        } catch (DatabaseUserException databaseException) {

        }
        assertEquals(false,isAuthenticated);

    }
    @Test
    public void loginUserWithWrongUsername(){
        try {
            isAuthenticated = loginControl.authentificate( "slin" , "Abc1" );

        } catch (DatabaseUserException databaseException) {

        }
        assertEquals(false,isAuthenticated);
    }
    @Test
    public void loginUserWithoutPassword(){
        try {
            isAuthenticated = loginControl.authentificate( "slind" , "" );

        } catch (DatabaseUserException databaseException) {

        }
        assertEquals(false,isAuthenticated);
    }
    @Test
    public void loginUserWithoutUsername(){
        try {
            isAuthenticated = loginControl.authentificate( "" , "Abc1" );

        } catch (DatabaseUserException databaseException) {

        }
        assertEquals(false,isAuthenticated);
    }
    @Test
    public void loginUserWithoutAll(){
        try {
            isAuthenticated = loginControl.authentificate( "" , "" );

        } catch (DatabaseUserException databaseException) {

        }
        assertFalse(isAuthenticated);
    }

    //Fehlerhaftes Löschen des Profils

    @Test
    public void deleteUserWithoutPasswordInput(){
        UserDTO testUser = testUserCreate();
        UserDTOImpl UserDataInput = new UserDTOImpl();
        UserDataInput= createUserDTO("Sarah","Linden","s.lind@smail.inf","slind","","Student");
        assertFalse(profileManagerservice.deleteUser(UserDataInput,testUser));
        UserDTO user = userRepository.findUserByUsernameAndPassword(testUser.getUsername(),testUser.getPassword());
        assertEquals("slind",user.getUsername());
    }
    @Test
    public void deleteUserWithWrongPasswordInput(){
        UserDTO testUser = testUserCreate();
        UserDTOImpl UserDataInput = new UserDTOImpl();
        UserDataInput= createUserDTO("Sarah","Linden","s.lind@smail.inf","slind","adsasd","Student");
        assertFalse(profileManagerservice.deleteUser(UserDataInput,testUser));
        UserDTO user = userRepository.findUserByUsernameAndPassword(testUser.getUsername(),testUser.getPassword());
        assertEquals("slind",user.getUsername());

    }
    @Test
    public void deleteUserWithWrongUsernameInput(){
        UserDTO testUser = testUserCreate();
        UserDTOImpl UserDataInput = new UserDTOImpl();
        UserDataInput= createUserDTO("Sarah","Linden","s.lind@smail.inf","asdas","Abc1","Student");
        assertFalse(profileManagerservice.deleteUser(UserDataInput,testUser));
        UserDTO user = userRepository.findUserByUsernameAndPassword(testUser.getUsername(),testUser.getPassword());
        assertEquals("slind",user.getUsername());
    }
    @Test
    public void deleteUserWithoutDataInput(){
        UserDTO testUser = testUserCreate();
        UserDTOImpl UserDataInput = new UserDTOImpl();
        UserDataInput= createUserDTO("Sarah","Linden","s.lind@smail.inf","","","Student");
        assertFalse(profileManagerservice.deleteUser(UserDataInput,testUser));
        UserDTO user = userRepository.findUserByUsernameAndPassword(testUser.getUsername(),testUser.getPassword());
        assertEquals("slind",user.getUsername());

    }

    //Erfolgreiches Löschen des Profils
    @Test
    public void deleteUser() throws DatabaseUserException {
        UserDTOImpl testUser = new UserDTOImpl();
        testUser= createUserDTO("Sarah","Linden","s.lind@smail.inf","slind","Abc1","Student");
        UserDTO userDTO = userRepository.findUserByUsernameAndPassword(testUser.getUsername(),testUser.getPassword());
        assertTrue(profileManagerservice.deleteUser(userDTO,userDTO));
        assertNull(userRepository.findUserByUsernameAndPassword(userDTO.getUsername(),userDTO.getPassword()));
    }

    //Hinzufügen einer Stellenanzeige
    @Test
    @Transactional
    public void addVacancy(){
        VacDTOImpl vacDTOTest = new VacDTOImpl();
        vacDTOTest.setDescription("Tolle Arbeitszeiten");
        vacDTOTest.setTitle("Guter Job");
        vacDTOTest.setHomeoffice("Ja");
        vacDTOTest.setSalary(12345);
        vacDTOTest.setWorkplace("Bonn");
        UserDTOImpl testUser= createUserDTO("Sarah","Linden","s.lind@smail.inf","slind","Abc1","Student");
        vacancyManager.createVac(vacDTOTest,testUser);
        VacDTO vacancy = vacancyRepository.findVacancyByTitleAndDescription(vacDTOTest.getTitle(),vacDTOTest.getDescription());
        assertEquals(vacDTOTest.getTitle(),vacancy.getTitle());
        assertEquals(vacDTOTest.getDescription(),vacancy.getDescription());
        assertEquals(vacDTOTest.getHomeoffice(),vacancy.getHomeoffice());
        assertEquals(vacDTOTest.getSalary(),vacancy.getSalary());
        assertEquals(vacDTOTest.getWorkplace(),vacancy.getWorkplace());
        assertTrue(vacDTOTest.equals(vacDTOTest));
        vacancyRepository.deleteVacancyByDescriptionAndTitle(vacDTOTest.getDescription(),vacDTOTest.getTitle());



    }
    @Test
    public void UtilTest(){
        UserDTO [] a = {testUserCreate()};
        a = Utils.append(a,createUserDTO("Jörgen","Baum","jörgen.baum@gmx.de","jbaum","56456456","Student"));
        assertEquals("Jörgen",a[1].getFirstName());
    }

}
