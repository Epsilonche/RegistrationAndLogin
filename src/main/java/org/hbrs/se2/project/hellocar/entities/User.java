package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.GeneratedValue;

@Entity
@Table( name ="User" , schema = "53Programming" )
public class User {
    private int     user_id;
    private int     user_type_id;
    private Date    date_of_birth;
    private String  street;
    private String  house_number;
    private String  postal_code;
    private String  city;
    private String  country;
    private String  security_answer;
    private String  last_name;
    private String  first_name;
    private String  password;
    private String  email;
    private int     security_question_id;
    private int     company_branch_id;

    //username für das Login und Registrierung von Othman erstellt
    private String username;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue
    @Column(name = "User_id")
    public int getId() {
        return user_id;
    }

    public void setId(int user_id) {
        this.user_id = user_id;
    }

    @Basic
    @Column(name = "user_type_id")
    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(int user_type_id) {
        this.user_type_id = user_type_id;
    }

    @Basic
    @Column(name = "company_branch_id")
    public int getCompany_branch_id() {
        return company_branch_id;
    }

    public void setCompany_branch_id(int company_branch_id) {
        this.company_branch_id = company_branch_id;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "house_number")
    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    @Basic
    @Column(name = "postal_code")
    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "security_answer")
    public String getSecurity_answer() {
        return security_answer;
    }

    public void setSecurity_answer(String security_answer) {
        this.security_answer = security_answer;
    }

    @Basic
    @Column(name = "e_mail")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Basic
    @Column(name = "date_of_birth")
    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


    @Basic
    @Column(name = "security_question_id")
    public int getSecurity_question_id() {
        return security_question_id;
    }

    public void setSecurity_question_id(int security_question_id) {
        this.security_question_id = security_question_id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Basic
    @Column(name = "last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id &&
                Objects.equals(user_type_id, user.user_type_id) &&
                Objects.equals(street, user.street) &&
                Objects.equals(house_number, user.house_number) &&
                Objects.equals(postal_code, user.postal_code) &&
                Objects.equals(city, user.city) &&
                Objects.equals(country, user.country) &&
                Objects.equals(security_answer, user.security_answer) &&
                Objects.equals(date_of_birth, user.date_of_birth) &&
                Objects.equals(security_question_id, user.security_question_id)&&
                Objects.equals(first_name, user.first_name) &&
                Objects.equals(last_name, user.last_name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, user_type_id, street, house_number, postal_code, city, country,security_question_id,security_answer,email,
                date_of_birth,password,first_name,last_name);
    }
}
