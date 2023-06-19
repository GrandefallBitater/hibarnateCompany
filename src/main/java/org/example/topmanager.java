package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class topmanager implements employee{
    private final int fixedSalary = 40000;

    private company Company;

    private int mounthSalary;

    private final int PersonalIncome = 0;

    private int type = 2;

    public topmanager(company company){
        prepare(company);
    }

    public topmanager(){

    }

    private int createSalary(company company){
        int mouthSalary;
        if(company.getIncome() >= 10000000){
            mouthSalary = fixedSalary + (fixedSalary/100*150);
            mounthSalary = mouthSalary;
            return mouthSalary;
        }else{
            return fixedSalary;
        }
    }

    @Override
    public void prepare(company company) {
        Company = company;
        mounthSalary = createSalary(company);
        hire();
    }

    @Override
    public void prepareAll(company company) {
        Company = company;
        mounthSalary = createSalary(company);
    }

    @Override
    public void hire() {
        List<employee> employeeList = new ArrayList<>();
        employeeList.add(this);
        hibernateCode.createEmployee(employeeList);
    }

    @Override
    public void fire() {
        hibernateCode.deleteEmployee(2, Company.getName(), 2);
    }
}
