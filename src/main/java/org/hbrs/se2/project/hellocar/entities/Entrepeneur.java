
package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.GeneratedValue;

@Entity
@Table( name ="Entrepeneur" , schema = "53Programming" )
public class Entrepeneur {
    private int entrepeneur_id;
    private int branch_id;
    private String title;
    private String roles;
    private String company;
    private String description;


    @Id
    @GeneratedValue
    @Column(name = "entrepeneur_id")
    public int getId() {
        return entrepeneur_id;
    }

    public void setId(int entrepeneur_id) {
        this.entrepeneur_id = entrepeneur_id;
    }

    @Basic
    @Column(name = "branch_id")
    public int getbranch_id() {
        return branch_id;
    }

    public void setbranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    @Basic
    @Column(name = "title")
    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "roles")
    public String getroles() {
        return roles;
    }

    public void setroles(String roles) {
        this.roles = roles;
    }


    @Basic
    @Column(name = "company")
    public String getcompany() {
        return company;
    }

    public void setcompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "description")
    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrepeneur entrepeneur = (Entrepeneur) o;
        return entrepeneur_id == entrepeneur.entrepeneur_id &&
                Objects.equals(branch_id, entrepeneur.branch_id) &&
                Objects.equals(title, entrepeneur.title) &&
                Objects.equals(roles, entrepeneur.roles) &&
                Objects.equals(company, entrepeneur.company) &&
                Objects.equals(description, entrepeneur.description) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrepeneur_id, branch_id, title,roles, company, description);
    }
}
