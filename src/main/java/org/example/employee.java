package org.example;

public interface employee {
    int getMounthSalary();

    int getPersonalIncome();

    int getType();

    company getCompany();

    void prepare(company company);

    void hire();

    void fire();

    void prepareAll(company company);
}
