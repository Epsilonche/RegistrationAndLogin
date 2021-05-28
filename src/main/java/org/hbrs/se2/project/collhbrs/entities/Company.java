package org.hbrs.se2.project.collhbrs.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
    private int entrepeneurId;

    @Id
    @javax.persistence.Column(name = "entrepeneur_id")
    public int getEntrepeneurId() {
        return entrepeneurId;
    }

    public void setEntrepeneurId(int entrepeneurId) {
        this.entrepeneurId = entrepeneurId;
    }

    private String title;

    @Basic
    @javax.persistence.Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String roles;

    @Basic
    @javax.persistence.Column(name = "roles")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    private String company;

    @Basic
    @javax.persistence.Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    private String description;

    @Basic
    @javax.persistence.Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company1 = (Company) o;

        if (entrepeneurId != company1.entrepeneurId) return false;
        if (title != null ? !title.equals(company1.title) : company1.title != null) return false;
        if (roles != null ? !roles.equals(company1.roles) : company1.roles != null) return false;
        if (company != null ? !company.equals(company1.company) : company1.company != null) return false;
        if (description != null ? !description.equals(company1.description) : company1.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = entrepeneurId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
