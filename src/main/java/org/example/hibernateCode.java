package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class hibernateCode {
    public static void createCompany(String name, int income){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CompanyEntity.class)
                .addAnnotatedClass(EmployeeEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            CompanyEntity comm = new CompanyEntity();
            comm.setName(name);
            comm.setIncome(income);
            session.beginTransaction();
            session.save(comm);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    public static void createEmployee(List<employee> employees){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CompanyEntity.class)
                .addAnnotatedClass(EmployeeEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            for (employee e:
                 employees) {
                EmployeeEntity comm = new EmployeeEntity();
                comm.setMounthsalary(e.getMounthSalary());
                comm.setPersonalIncome(e.getPersonalIncome());
                comm.setType(e.getType());
                comm.setCompanyName(e.getCompany().getName());
                session.save(comm);
            }
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    public static void deleteEmployee(int type, String company_name, int count){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CompanyEntity.class)
                .addAnnotatedClass(EmployeeEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            int i = 0;
            List<EmployeeEntity> comm = session.createQuery("from EmployeeEntity e where e.type = :type and e.companyName = :company_name")
                    .setParameter("type", type).setParameter("company_name", company_name)
                    .list();
            for (Iterator<EmployeeEntity> it = comm.iterator(); it.hasNext();) {
                i++;
                if(i < count) {
                    EmployeeEntity user = it.next();
                    session.remove(user);
                }else{
                    break;
                }
            }
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    public static void getTopSalaryStaff(int count, String name){
        String HQL = "from EmployeeEntity e where e.companyName = :company_name order by e.mounthsalary desc";
        sortSelectEmployee(count, name, HQL);
    }

    public static void getLowestSalaryStaff(int count, String name){
        String HQL = "from EmployeeEntity e where e.companyName = :company_name order by e.mounthsalary asc";
        sortSelectEmployee(count, name, HQL);
    }

    public static void sortSelectEmployee(int count, String company_name, String HQL){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CompanyEntity.class)
                .addAnnotatedClass(EmployeeEntity.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            List<EmployeeEntity> comm = session.createQuery(HQL)
                    .setParameter("company_name", company_name)
                    .list();
            int i  = 0;
            for (Iterator<EmployeeEntity> it = comm.iterator(); it.hasNext();) {
                if(i < count) {
                    i++;
                    EmployeeEntity user = it.next();
                    System.out.println(user.getMounthsalary() + "rub\n");
                }else{
                    break;
                }
            }
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
