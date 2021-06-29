package org.hbrs.se2.project.collhbrs.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Table( name ="user" , schema = "collhbrs" )
public class User {
    private String securityAnswer;
    private String country;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String username;
    private String userTyp;
    private int userId;

    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "collhbrs.user_id_sequence"
    )
    @Column(name = "user_id")

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "security_answer")
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "e_mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (securityAnswer != null ? !securityAnswer.equals(user.securityAnswer) : user.securityAnswer != null)
            return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (eMail != null ? !eMail.equals(user.eMail) : user.eMail != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (userTyp != null ? !userTyp.equals(user.userTyp) : user.userTyp != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = securityAnswer != null ? securityAnswer.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userTyp != null ? userTyp.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }

    @Basic
    @Column(name = "user_typ")
    public String getUserTyp() {
        return userTyp;
    }

    public void setUserTyp(String userTyp) {
        this.userTyp = userTyp;
    }
}
