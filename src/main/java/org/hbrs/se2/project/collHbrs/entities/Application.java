package org.hbrs.se2.project.collHbrs.entities;

import javax.persistence.*;
import java.util.Objects;
import javax.persistence.GeneratedValue;

@Entity
@Table( name ="Application" , schema = "53Programming" )
public class Application {
    private int application_id;
    private int job_id;
    private int student_id;
    private String application_text;


    @Id
    @GeneratedValue
    @Column(name = "application_id")
    public int getId() {
        return application_id;
    }

    public void setId(int application_id) {
        this.application_id = application_id;
    }

    @Basic
    @Column(name = "job_id")
    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    @Basic
    @Column(name = "student_id")
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Basic
    @Column(name = "application_text")
    public String getApplication_text() {
        return application_text;
    }

    public void setApplication_text(String application_text) {
        this.application_text = application_text;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application application = (Application) o;
        return application_id == application.application_id &&
                Objects.equals(job_id, application.job_id) &&
                Objects.equals(student_id, application.student_id) &&
                Objects.equals(application_text, application.application_text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(application_id, job_id, student_id,application_text);
    }
}



