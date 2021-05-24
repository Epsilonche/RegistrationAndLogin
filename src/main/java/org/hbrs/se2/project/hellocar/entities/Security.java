
package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.GeneratedValue;

@Entity
@Table( name ="Security" , schema = "53Programming" )
public class Security {
    private int security_question_id;
    private String security_question;


    @Id
    @GeneratedValue
    @Column(name = "security_question_id")
    public int getSecurity_question_id() {
        return security_question_id;
    }

    public void setSecurity_question_id(int security_question_id) {
        this.security_question_id = security_question_id;
    }

    @Basic
    @Column(name = "security_question")
    public String getsecurity_question() {
        return security_question;
    }

    public void setsecurity_question(String security_question) {
        this.security_question = security_question;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return security_question_id == security.security_question_id &&
                Objects.equals(security_question, security.security_question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(security_question_id, security_question);
    }
}
