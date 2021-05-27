package org.hbrs.se2.project.hellocar.dtos.impl;

import org.hbrs.se2.project.hellocar.dtos.StudentDTO;

import java.sql.Date;
import java.time.LocalDate;

public class StudentDTOImpl implements StudentDTO {

    private int     student_id;
    private int     matrikel_nr;
    private int     application_id;
    private String  skills;
    private String  university;
    private String  degree_course;

    public int getId() {
        return student_id;
    }

    public void setId(int student_id) {
        this.student_id = student_id;
    }

    public int getMatrikel_nr() {
        return matrikel_nr;
    }

    public void setMatrikel_nr(int matrikel_nr) {
        this.matrikel_nr = matrikel_nr;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree_course() {
        return degree_course;
    }

    public void setDegree_course(String degree_course) {
        this.degree_course = degree_course;
    }
}
