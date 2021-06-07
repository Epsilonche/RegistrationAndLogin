package org.hbrs.se2.project.collhbrs.entities;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "vacancy", schema = "collhbrs")
public class Vacancy {
    private Integer status;
    private String workplace;
    private String homeoffice;
    private Date startDate;
    private Date endDate;
    private Integer salary;
    private String title;
    private String description;
    private int vacId;

    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "collhbrs.vacancy_id_sequence"
    )
    @Column(name = "vac_id")
    public int getVacId() {
        return vacId;
    }

    public void setVacId(int vacId) {
        this.vacId = vacId;
    }


    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "workplace")
    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Basic
    @Column(name = "homeoffice")
    public String getHomeoffice() {
        return homeoffice;
    }

    public void setHomeoffice(String homeoffice) {
        this.homeoffice = homeoffice;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy that = (Vacancy) o;

        if (vacId != that.vacId) return false;
        if (workplace != null ? !workplace.equals(that.workplace) : that.workplace != null) return false;
        if (homeoffice != null ? !homeoffice.equals(that.homeoffice) : that.homeoffice != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (workplace != null ? workplace.hashCode() : 0);
        result = 31 * result + (homeoffice != null ? homeoffice.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + vacId;
        return result;
    }
}
