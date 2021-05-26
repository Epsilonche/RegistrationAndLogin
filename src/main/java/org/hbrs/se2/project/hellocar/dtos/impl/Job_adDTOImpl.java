package org.hbrs.se2.project.hellocar.dtos.impl;
import org.hbrs.se2.project.hellocar.dtos.Job_adDTO;

import java.sql.Date;
import java.time.LocalDate;

public class Job_adDTOImpl implements Job_adDTO {

    private int     job_id;
    private int     company_id;
    private int     application_id;
    private String  skills;
    private String  description;
    private String  title;
    private int     salary;
    private Date    end_date;
    private Date    start_date;
    private String  homeoffice;
    private String  workplace;
    private String  status;

    public int getId() {
        return job_id;
    }

    public void setId(int job_id) {
        this.job_id = job_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getStart_date() {
        return end_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getHomeoffice() {
        return homeoffice;
    }

    public void setHomeoffice(String homeoffice) {
        this.homeoffice = homeoffice;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
