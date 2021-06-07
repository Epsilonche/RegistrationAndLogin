package org.hbrs.se2.project.collhbrs.dtos;

import java.util.Date;

public interface VacDTO {
    public int getStatus();
    public Date getStartDate();
    public Date getEndDate();
    public String getTitle();
    public String getDescription();
    public String getWorkplace();
    public Integer getSalary();
    public String getHomeoffice();

    public void setStatus(int status);
    public void setStartDate(Date startDate);
    public void setEndDate(Date endDate);
    public void setTitle(String title);
    public void setDescription(String description);
    public void setWorkplace(String workplace);
    public void setSalary(Integer salary);
    public void setHomeoffice(String homeoffice);


}
