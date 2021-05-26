package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.GeneratedValue;

@Entity
@Table( name ="student" , schema = "53Programming" )
public class Student {
    private int     student_id;
    private int     matrikel_nr;
    private int     application_id;
    private String  skills;
    private String  university;
    private String  degree_course;



    @Id
    @GeneratedValue
    @Column(name = "Student_id")
    public int getId() {
        return student_id;
    }

    public void setId(int student_id) {
        this.student_id = student_id;
    }

    @Basic
    @Column(name = "matrikel_nr")
    public int getMatrikel_nr() {
        return matrikel_nr;
    }

    public void setMatrikel_nr(int matrikel_nr) {
        this.matrikel_nr = matrikel_nr;
    }

    @Basic
    @Column(name = "application_id")
    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }


    @Basic
    @Column(name = "skills")
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Basic
    @Column(name = "university")
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Basic
    @Column(name = "degree_course")
    public String getDegree_course() {
        return degree_course;
    }

    public void setDegree_course(String degree_course) {
        this.degree_course = degree_course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student s = (Student) o;
        return student_id == s.student_id &&
                Objects.equals(matrikel_nr, s.matrikel_nr) &&
                Objects.equals(application_id, s.application_id) &&
                Objects.equals(skills, s.skills) &&
                Objects.equals(university, s.university) &&
                Objects.equals(degree_course, s.degree_course) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, matrikel_nr, application_id, skills,university,degree_course);
    }
}
