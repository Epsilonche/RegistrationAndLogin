package org.hbrs.se2.project.hellocar.dtos;

import java.util.Date;

public interface Job_adDTO {

    public int    getId();
    public int    getApplication_id();
    public int    getCompany_id();
    public int    getSalary();
    public String getTitle();
    public String getSkills();
    public String getHomeoffice();
    public String getDescription();
    public String getWorkplace();
    public String getStatus();
    public Date   getEnd_date();
    public Date   getStart_date();
}
