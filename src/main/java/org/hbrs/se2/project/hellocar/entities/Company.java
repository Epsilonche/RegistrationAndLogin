package org.hbrs.se2.project.hellocar.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name ="Company" , schema = "53Programming" )

public class Company {
    private int Company_id;
    private int Company_branch_id;
    private int Postal_Code;
    private int VAT_identification_number;
    private String House_Number;
    private LocalDate Establishment_date;
    private String Company_Name;
    private String Street;
    private String City;
    private String Country;
    private String Security_answer;
    private String Homepage;
    private String Headquarters;
    private int Amount_of_employees;
    private int security_answer_id;
    private String Company_description;
    private int Turnover;

    private List<Rolle> roles;

    @Id
    @GeneratedValue

    @Column(name = "Company_id")
    public int getCompany_id() {
        return Company_id;
    }
    public void setCompany_id(int id) {
        this.Company_id = id;
    }

    @Basic
    @Column(name = "Company_branch_id")
    public LocalDate getEstablishment_date() {
        return Establishment_date;
    }

    public void setEstablishment_date(LocalDate Establishment_date) {
        this.Establishment_date = Establishment_date;
    }

    @Column(name = "Company_id")
    public void setCompany_branch_id(int company_branch_id) {
        Company_branch_id = company_branch_id;
    }

    public int getPostal_Code() {
        return Postal_Code;
    }

    public int getVAT_identification_number() {
        return VAT_identification_number;
    }

    public String getHouse_Number() {
        return House_Number;
    }

    public String getCompany_Name() {
        return Company_Name;
    }

    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }

    public String getSecurity_answer() {
        return Security_answer;
    }

    public String getHomepage() {
        return Homepage;
    }

    public String getHeadquarters() {
        return Headquarters;
    }

    public int getAmount_of_employees() {
        return Amount_of_employees;
    }

    public int getSecurity_answer_id() {
        return security_answer_id;
    }

    public String getCompany_description() {
        return Company_description;
    }

    public int getTurnover() {
        return Turnover;
    }

    public void setPostal_Code(int postal_Code) {
        Postal_Code = postal_Code;
    }

    public void setVAT_identification_number(int VAT_identification_number) {
        this.VAT_identification_number = VAT_identification_number;
    }

    public void setHouse_Number(String house_Number) {
        House_Number = house_Number;
    }

    public void setCompany_Name(String company_Name) {
        Company_Name = company_Name;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setSecurity_answer(String security_answer) {
        Security_answer = security_answer;
    }

    public void setHomepage(String homepage) {
        Homepage = homepage;
    }

    public void setHeadquarters(String headquarters) {
        Headquarters = headquarters;
    }

    public void setAmount_of_employees(int amount_of_employees) {
        Amount_of_employees = amount_of_employees;
    }

    public void setSecurity_answer_id(int security_answer_id) {
        this.security_answer_id = security_answer_id;
    }

    public void setCompany_description(String company_description) {
        Company_description = company_description;
    }

    public void setTurnover(int turnover) {
        Turnover = turnover;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCompany_branch_id() {
        return Company_branch_id;
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
    @Column(name = "occupation")
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company user = (Company) o;
        return id == user.id &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(email, user.email) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(occupation, user.occupation) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(userid, user.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfBirth, email, firstName, lastName, occupation, password, phone, userid);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_to_rolle", catalog = "demouser",
            schema = "carlook",
            joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "bezeichnung", referencedColumnName = "bezeichhnung", nullable = false))
    public List<Rolle> getRoles() {
        return roles;
    }

    public void setRoles(List<Rolle> roles) {
        this.roles = roles;
    }
}
