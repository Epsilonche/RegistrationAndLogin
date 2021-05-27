package org.hbrs.se2.project.hellocar.dtos;

import java.util.Date;
import java.util.List;

public interface UserDTO {
    public int    getId();
    public String getUsername();
    public int    getUser_type_id();
    public Date   getDate_of_birth();
    public String getStreet();
    public String getHouse_number();
    public String getPostal_code();
    public String getCity();
    public String getCountry();
    public String getSecurity_answer();
    public String getLast_name();
    public String getFirst_name();
    public String getPassword();
    public String getEmail();
    public int   getSecurity_question_id();
}
