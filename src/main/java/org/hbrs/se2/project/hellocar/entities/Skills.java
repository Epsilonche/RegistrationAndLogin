package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.GeneratedValue;

@Entity
@Table( name ="Skills" , schema = "53Programming" )
public class Skills {
    private int skill_id;
    private String skill_name;
    private String skill_description;


    @Id
    @GeneratedValue
    @Column(name = "skill_id")
    public int getId() {
        return skill_id;
    }

    public void setId(int skill_id) {
        this.skill_id = skill_id;
    }

    @Basic
    @Column(name = "skill_name")
    public String getskill_name() {
        return skill_name;
    }

    public void setskill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    @Basic
    @Column(name = "skill_description")
    public String getskill_description() {
        return skill_name;
    }

    public void setskill_description(String skill_description) {
        this.skill_description = skill_description;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skills skills = (Skills) o;
        return skill_id == skills.skill_id &&
                Objects.equals(skill_name, skills.skill_name)&&
                Objects.equals(skill_description, skills.skill_description)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill_id, skill_name,skill_description);
    }
}
