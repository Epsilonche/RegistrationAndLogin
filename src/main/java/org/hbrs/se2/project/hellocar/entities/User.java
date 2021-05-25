package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
// import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name ="user" , schema = "TestSchema" )
public class User {

    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
