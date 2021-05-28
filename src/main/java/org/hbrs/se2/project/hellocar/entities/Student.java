package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    private int studentId;

    @Id
    @javax.persistence.Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    private Integer matrikelNr;

    @Basic
    @javax.persistence.Column(name = "matrikel_nr")
    public Integer getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(Integer matrikelNr) {
        this.matrikelNr = matrikelNr;
    }

    private String university;

    @Basic
    @javax.persistence.Column(name = "university")
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    private String degreeCourse;

    @Basic
    @javax.persistence.Column(name = "degree_course")
    public String getDegreeCourse() {
        return degreeCourse;
    }

    public void setDegreeCourse(String degreeCourse) {
        this.degreeCourse = degreeCourse;
    }

    private String skills;

    @Basic
    @javax.persistence.Column(name = "skills")
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != student.studentId) return false;
        if (matrikelNr != null ? !matrikelNr.equals(student.matrikelNr) : student.matrikelNr != null) return false;
        if (university != null ? !university.equals(student.university) : student.university != null) return false;
        if (degreeCourse != null ? !degreeCourse.equals(student.degreeCourse) : student.degreeCourse != null)
            return false;
        if (skills != null ? !skills.equals(student.skills) : student.skills != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (matrikelNr != null ? matrikelNr.hashCode() : 0);
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (degreeCourse != null ? degreeCourse.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
    }
}
