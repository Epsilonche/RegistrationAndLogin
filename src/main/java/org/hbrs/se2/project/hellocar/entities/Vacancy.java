package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.GeneratedValue;

@Entity
@Table( name ="Vacancy" , schema = "53Programming" )
public class Vacancy {
    private int     job_id;
    private int     entrepeneur_id;
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


    @Id
    @GeneratedValue
    @Column(name = "job_id")
    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    @Basic
    @Column(name = "entrepeneur_id")
    public int getEntrepeneur_id() {
        return entrepeneur_id;
    }

    public void setEntrepeneur_id(int entrepeneur_id) {
        this.entrepeneur_id = entrepeneur_id;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    @Basic
    @Column(name = "homeoffice")
    public String getHomeoffice() {
        return homeoffice;
    }

    public void setHomeoffice(String homeoffice) {
        this.homeoffice = homeoffice;
    }


    @Basic
    @Column(name = "workplace")
    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy j = (Vacancy) o;
        return job_id== j.job_id &&
                Objects.equals(entrepeneur_id, j.entrepeneur_id) &&
                Objects.equals(application_id, j.application_id) &&
                Objects.equals(skills, j.skills) &&
                Objects.equals(description, j.description) &&
                Objects.equals(title, j.title) &&
                Objects.equals(salary, j.salary) &&
                Objects.equals(end_date, j.end_date) &&
                Objects.equals(start_date,j.start_date) &&
                Objects.equals(homeoffice, j.homeoffice) &&
                Objects.equals(workplace, j.workplace) &&
                Objects.equals(status, j.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job_id, entrepeneur_id, application_id, skills,description,title,salary,end_date,start_date, homeoffice,workplace,status);
    }
}
