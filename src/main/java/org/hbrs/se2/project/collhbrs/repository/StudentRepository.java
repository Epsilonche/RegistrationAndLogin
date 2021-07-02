package org.hbrs.se2.project.collhbrs.repository;

import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.entities.Student;
import org.hbrs.se2.project.collhbrs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByStudentId(int id);
    StudentDTO findStudentByMatrikelNr(int matrikelNr);
    int deleteByMatrikelNr(int matrikelNr);

}
