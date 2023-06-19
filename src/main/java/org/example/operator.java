package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class operator implements employee{
    private final int mounthSalary = 20000;

    private final int PersonalIncome = 0;

    private company Company;

    private int type = 1;

    public operator(company company){
        prepare(company);
    }

    public operator(){

    }

    @Override
    public void prepare(company company) {
        Company = company;
        hire();
    }

    @Override
    public void prepareAll(company company) {
        Company = company;
    }

    @Override
    public void hire() {
        List<employee> employeeList = new ArrayList<>();
        employeeList.add(this);
        hibernateCode.createEmployee(employeeList);
    }

    @Override
    public void fire() {
        hibernateCode.deleteEmployee(1, Company.getName(), 2);
    }
}
