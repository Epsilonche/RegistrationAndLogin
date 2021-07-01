package org.hbrs.se2.project.collhbrs.control;

import com.vaadin.flow.component.UI;
import org.hbrs.se2.project.collhbrs.control.factories.UserFactory;
import org.hbrs.se2.project.collhbrs.dtos.CompanyDTO;
import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;
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

    UserFactory userFactory = new UserFactory();
    private UserRepository userRepository;

    private UserDTO current_user = null;
    private Student current_student = null;

    public boolean checkIfProfileIsCreated(UserDTO current_user){
        int currentUserId = current_user.getUserId();
        return studentRepository.findByStudentId(currentUserId) != null || companyRepository.findByCompanyId(currentUserId) != null;
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

    public UserDTO getCurrent_user() {
        return current_user;
    }

    public Student getCurrent_student() {
        return current_student;
    }

    public StudentDTOImpl getCurrentStudentDTO(){
        StudentDTOImpl student = new StudentDTOImpl();
        //TODO creates a dto to pass to views
        student.setStudentId(current_student.getStudentId());
        student.setDegreeCourse(current_student.getDegreeCourse());
        student.setMatrikelNr(current_student.getMatrikelNr());
        student.setUniversity(current_student.getUniversity());

        return student;
    }
}
