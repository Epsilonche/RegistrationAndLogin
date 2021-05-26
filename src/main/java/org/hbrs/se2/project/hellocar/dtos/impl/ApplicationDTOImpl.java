package org.hbrs.se2.project.hellocar.dtos.impl;

import org.hbrs.se2.project.hellocar.dtos.ApplicationDTO;

import java.sql.Date;
import java.time.LocalDate;

public class ApplicationDTOImpl implements ApplicationDTO {

    private int application_id;
    private int job_id;
    private int student_id;
    private String application_text;

    public int getId() {
        return application_id;
    }

    public void setId(int application_id) {
        this.application_id = application_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getApplication_text() {
        return application_text;
    }

    public void setApplication_text(String application_text) {
        this.application_text = application_text;
    }
}
