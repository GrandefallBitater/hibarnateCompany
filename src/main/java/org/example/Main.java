package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //создание компании
        company Company = new company("new1", 40000000);
        //создание всех трёх видов работников
        List<employee> list = createStaff(100,1000,300);
        Company.hireAll(list);
        Company.getTopSalaryStaff(20);
        Company.getLowestSalaryStaff(10);
        Company.fire(1, 50);
        Company.fire(3, 500);
        Company.fire(2, 150);
        Company.getTopSalaryStaff(20);
        Company.getLowestSalaryStaff(10);
    }

    public static List<employee> createStaff(int countOperator, int countManager, int countTopManager){
        if(countOperator < 0){
            System.out.println("число операторов не может быть отрицательным");
            return null;
        } else if (countManager < 0) {
            System.out.println("число менеджеров не может быть отрицательным");
            return null;
        } else if (countTopManager < 0) {
            System.out.println("число топ-менеджеров не может быть отрицательным");
            return null;
        }else {
            List<employee> list = new ArrayList<>();
            for (int i = 0; i < countManager; i++) {
                employee e = new manager();
                list.add(e);
            }
            for (int i = 0; i < countOperator; i++) {
                employee e = new operator();
                list.add(e);
            }
            for (int i = 0; i < countTopManager; i++) {
                employee e = new topmanager();
                list.add(e);
            }
            return list;
        }
    }
}
