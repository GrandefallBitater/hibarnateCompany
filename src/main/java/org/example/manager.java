package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class manager implements employee {
    private final int fixedSalary = 40000;

    private int PersonalIncome;

    private int mounthSalary;

    private int type = 3;

    private company Company;

    public manager(company company) {
        prepare(company);
    }

    public manager(){

    }

    private int createSalary() {
        int mouthSalary = fixedSalary + (PersonalIncome*5/100);
        mounthSalary = mouthSalary;
        return mouthSalary;
    }

    private void createPersonalIncome(){
        PersonalIncome = (int) ((Math.random()*((140000 - 115000)+1))+115000);
    }

    @Override
    public void prepare(company company) {
        Company = company;
        createPersonalIncome();
        mounthSalary = createSalary();
        hire();
    }

    @Override
    public void prepareAll(company company) {
        Company = company;
        createPersonalIncome();
        mounthSalary = createSalary();
    }

    @Override
    public void hire() {
        List<employee> employeeList = new ArrayList<>();
        employeeList.add(this);
        hibernateCode.createEmployee(employeeList);
    }

    @Override
    public void fire() {
        hibernateCode.deleteEmployee(3, Company.getName(), 2);
    }
}
