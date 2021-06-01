package org.hbrs.se2.project.collhbrs.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    private Integer matrikelNr;
    private String university;
    private String degreeCourse;
    private Integer applicationId;
    private int studentId;

    @Basic
    @Column(name = "matrikel_nr")
    public Integer getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(Integer matrikelNr) {
        this.matrikelNr = matrikelNr;
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
    public String getDegreeCourse() {
        return degreeCourse;
    }

    public void setDegreeCourse(String degreeCourse) {
        this.degreeCourse = degreeCourse;
    }

    @Basic
    @Column(name = "application_id")
    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    @Id
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
        if (applicationId != null ? !applicationId.equals(student.applicationId) : student.applicationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = matrikelNr != null ? matrikelNr.hashCode() : 0;
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (degreeCourse != null ? degreeCourse.hashCode() : 0);
        result = 31 * result + (applicationId != null ? applicationId.hashCode() : 0);
        result = 31 * result + studentId;
        return result;
    }
}
