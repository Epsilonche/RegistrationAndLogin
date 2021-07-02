package org.hbrs.se2.project.collhbrs.control;

import com.vaadin.flow.component.UI;
import org.hbrs.se2.project.collhbrs.control.factories.UserFactory;
import org.hbrs.se2.project.collhbrs.dtos.CompanyDTO;
import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;
import org.hbrs.se2.project.collhbrs.dtos.impl.CompanyDTOImpl;
import org.hbrs.se2.project.collhbrs.dtos.impl.StudentDTOImpl;
import org.hbrs.se2.project.collhbrs.entities.Student;
import org.hbrs.se2.project.collhbrs.repository.StudentRepository;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;

import org.hbrs.se2.project.collhbrs.entities.Company;
import org.hbrs.se2.project.collhbrs.entities.User;
import org.hbrs.se2.project.collhbrs.repository.CompanyRepository;
import org.hbrs.se2.project.collhbrs.repository.UserRepository;
import org.hbrs.se2.project.collhbrs.util.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileManager {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;

    UserFactory userFactory = new UserFactory();

    private UserDTO current_user = null;
    private Student current_student = null;
    private Company current_company = null;

    public boolean checkIfProfileIsCreated(UserDTO current_user){
        int currentUserId = current_user.getUserId();
        return studentRepository.findByStudentId(currentUserId) != null || companyRepository.findByCompanyId(currentUserId) != null;
    }
    public boolean checkIfStudentProfileIsCreated(UserDTO current_user){
        int currentUserId = current_user.getUserId();
        return studentRepository.findByStudentId(currentUserId) != null;
    }
    public boolean checkIfCompanyProfileIsCreated(UserDTO current_user){
        int currentUserId = current_user.getUserId();
        return companyRepository.findByCompanyId(currentUserId) != null;
    }


    public User getUserById(int id){
        return userRepository.getUserByUserId(id);
    }

    public void createStudentProfile(StudentDTO studentDTO,UserDTO currentUser){
        Student newStudent= userFactory.createStudent(studentDTO,currentUser);
        this.studentRepository.save(newStudent);
    }

    public void createCompanyProfile(CompanyDTO companyDTO,UserDTO currentUser){
        Company newCompany = userFactory.createCompany(companyDTO,currentUser);
        companyRepository.save(newCompany);
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


    public void setUserIntoSession(UserDTO current_user) {
        this.current_user = current_user;
    }

    public void setStudentIntoSession() {
        this.current_student = studentRepository.findByStudentId(current_user.getUserId());
    }
    public void setCompanyIntoSession() {
        this.current_company = companyRepository.findByCompanyId(current_user.getUserId());
    }

    public UserDTO getCurrent_user() {
        return current_user;
    }

    public Student getStudentById(int userId) {
        return studentRepository.findByStudentId(userId);
    }
    public Company getCompanyById(int userId) {
        return companyRepository.findByCompanyId(userId);
    }
    public StudentDTOImpl getCurrentStudentDTO(){
        StudentDTOImpl student = new StudentDTOImpl();
        student.setStudentId(current_student.getStudentId());
        student.setDegreeCourse(current_student.getDegreeCourse());
        student.setMatrikelNr(current_student.getMatrikelNr());
        student.setUniversity(current_student.getUniversity());

        return student;
    }


    public CompanyDTOImpl getCurrentCompanyDTO() {
        CompanyDTOImpl company = new CompanyDTOImpl();
        company.setCompanyId(current_company.getCompanyId());
        company.setCompany(current_company.getCompany());
        company.setDescription(current_company.getDescription());
        company.setTitle(current_company.getTitle());
        company.setRoles(current_company.getRoles());
        return company;
    }


}
