package org.hbrs.se2.project.hellocar.dtos.impl;

import org.hbrs.se2.project.hellocar.dtos.EntrepeneurDTO;
import java.sql.Date;
import java.time.LocalDate;


public class EntrepeneurDTOImpl implements EntrepeneurDTO {
    private int entrepeneur_id;
    private int branch_id;
    private String title;
    private String roles;
    private String company;
    private String description;

    public int getId() {
        return entrepeneur_id;
    }

    public void setId(int entrepeneur_id) {
        this.entrepeneur_id = entrepeneur_id;
    }


    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
