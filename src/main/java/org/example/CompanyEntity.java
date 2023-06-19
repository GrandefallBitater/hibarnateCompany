package org.example;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "public", catalog = "Hibernate")
public class CompanyEntity {
    @Id
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "income")
    private int income;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return income == that.income && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, income);
    }
}
