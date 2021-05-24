package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.GeneratedValue;

@Entity
@Table( name ="Branch" , schema = "53Programming" )
public class Branch {
    private int branch_id;
    private String branch_name;


    @Id
    @GeneratedValue
    @Column(name = "branch_id")
    public int getId() {
        return branch_id;
    }

    public void setId(int branch_id) {
        this.branch_id = branch_id;
    }

    @Basic
    @Column(name = "branch_name")
    public String getbranch_name() {
        return branch_name;
    }

    public void setbranch_name(String branch_name) {
        this.branch_name = branch_name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return branch_id == branch.branch_id &&
                Objects.equals(branch_name, branch.branch_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branch_id, branch_name);
    }
}
