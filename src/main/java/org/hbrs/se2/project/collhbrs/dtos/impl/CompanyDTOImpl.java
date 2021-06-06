package org.hbrs.se2.project.collhbrs.dtos.impl;

import org.hbrs.se2.project.collhbrs.dtos.CompanyDTO;

public class CompanyDTOImpl implements CompanyDTO {
    private String company;
    private String title;
    private String roles;
    private String description;
    private int branch_id;

    public CompanyDTOImpl() { }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

}
