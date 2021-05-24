
package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.GeneratedValue;

@Entity
@Table( name ="Company" , schema = "53Programming" )
public class Company {
    private int company_id;
    private int branch_id;
    private String title;
    private String roles;
    // private String company;
    private String description;


    @Id
    @GeneratedValue
    @Column(name = "company_id")
    public int getId() {
        return company_id;
    }

    public void setId(int company_id) {
        this.company_id = company_id;
    }

    @Basic
    @Column(name = "branch_id")
    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
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
    @Column(name = "roles")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

/* ausgeklammert wegen Entrepeneur
    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
*/
    @Basic
    @Column(name = "description")
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
        Company company = (Company) o;
        return company_id == company.company_id &&
                Objects.equals(branch_id, company.branch_id) &&
                Objects.equals(title, company.title) &&
                Objects.equals(roles, company.roles) &&
                //Objects.equals(company, company.company) &&
                Objects.equals(description, company.description) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(company_id, branch_id, title,roles, /*company, */description);
    }
}
