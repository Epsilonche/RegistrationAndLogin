package org.hbrs.se2.project.collhbrs.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "company", schema = "collhbrs")
public class Company {
    private String title;
    private String roles;
    private String company;
    private String description;
    private int companyId;

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "roles")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "company_id")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company1 = (Company) o;

        if (companyId != company1.companyId) return false;
        if (title != null ? !title.equals(company1.title) : company1.title != null) return false;
        if (roles != null ? !roles.equals(company1.roles) : company1.roles != null) return false;
        if (company != null ? !company.equals(company1.company) : company1.company != null) return false;
        if (description != null ? !description.equals(company1.description) : company1.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + companyId;
        return result;
    }
}
