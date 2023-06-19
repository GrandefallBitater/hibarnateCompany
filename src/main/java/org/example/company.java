package org.example;

import lombok.Data;

import java.util.List;

@Data
public class company {
    private final String name;
    private final Integer income;

    public company(String name, Integer income){
        this.name = name;
        this.income = income;
        hibernateCode.createCompany(name, income);
    }

    public void hire(employee employee){
        employee.prepare(this);
    }

    public void hireAll(List<employee> employeeList){
        for (employee e:
             employeeList) {
            e.prepareAll(this);
        }
        hibernateCode.createEmployee(employeeList);
    }

    public void fire(int type, int count){
        if (count < 0){
            System.out.println("число сотрудников не может быть меньше нуля");
            return;
        }
        hibernateCode.deleteEmployee(type, name, count);
    }

    public void fire(employee employee){
        employee.fire();
    }

    public void getTopSalaryStaff(int count){
        if (count < 0){
            System.out.println("число сотрудников не может быть меньше нуля");
            return;
        }
        hibernateCode.getTopSalaryStaff(count, name);
    }

    public void getLowestSalaryStaff(int count){
        if (count < 0){
            System.out.println("число сотрудников не может быть меньше нуля");
            return;
        }
        hibernateCode.getLowestSalaryStaff(count, name);
    }
}
