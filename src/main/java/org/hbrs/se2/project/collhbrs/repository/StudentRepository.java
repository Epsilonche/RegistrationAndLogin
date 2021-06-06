package org.hbrs.se2.project.collhbrs.repository;

import org.hbrs.se2.project.collhbrs.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
