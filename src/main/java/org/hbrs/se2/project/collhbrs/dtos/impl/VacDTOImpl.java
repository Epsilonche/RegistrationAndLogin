package org.hbrs.se2.project.collhbrs.dtos.impl;

import org.hbrs.se2.project.collhbrs.dtos.VacDTO;

import java.util.Date;

public class VacDTOImpl implements VacDTO {

    private int status;
    private Date startDate;
    private Date endDate;
    private String title;
    private String description;
    private String workplace;
    private Integer salary;
    private String homeoffice;

    public int getStatus(){
        return status;
    }

    public void setStatus(int status) { this.status = status;
    }

    public Date getStartDate(){
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate(){
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkplace(){
        return workplace;
    }
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Integer getSalary(){
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getHomeoffice(){
        return homeoffice;
    }
    public void setHomeoffice(String homeoffice) {
        this.homeoffice = homeoffice;
    }
}
