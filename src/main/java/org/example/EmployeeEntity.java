package org.example;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "public", catalog = "Hibernate")
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "mounthsalary")
    private int mounthsalary;
    @Basic
    @Column(name = "personal_income")
    private Integer personalIncome;
    @Basic
    @Column(name = "type")
    private int type;
    @Basic
    @Column(name = "company_name")
    private String companyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMounthsalary() {
        return mounthsalary;
    }

    public void setMounthsalary(int mounthsalary) {
        this.mounthsalary = mounthsalary;
    }

    public Integer getPersonalIncome() {
        return personalIncome;
    }

    public void setPersonalIncome(Integer personalIncome) {
        this.personalIncome = personalIncome;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return id == that.id && mounthsalary == that.mounthsalary && type == that.type && Objects.equals(personalIncome, that.personalIncome) && Objects.equals(companyName, that.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mounthsalary, personalIncome, type, companyName);
    }
}
