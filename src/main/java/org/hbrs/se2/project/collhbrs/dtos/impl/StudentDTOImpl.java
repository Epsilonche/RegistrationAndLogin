package org.hbrs.se2.project.collhbrs.dtos.impl;

import org.hbrs.se2.project.collhbrs.dtos.StudentDTO;

public class StudentDTOImpl implements StudentDTO {
    private Integer matrikelNr;
    private String university;
    private String degreeCourse;
    private Integer applicationId;
    private int studentId;

    /*
    Add a nested comment explaining why this method is empty, throw an UnsupportedOperationException or complete the implementation.
    unused, because of that commet out
    public StudentDTOImpl() { }
    */


    public Integer getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(Integer matrikelNr) {
        this.matrikelNr = matrikelNr;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegreeCourse() {
        return degreeCourse;
    }

    public void setDegreeCourse(String degreeCourse) {
        this.degreeCourse = degreeCourse;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
