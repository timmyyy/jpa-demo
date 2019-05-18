package com.example.jpa.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {
    private final MyRepository repo;

    @Autowired
    public MyService(MyRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void doJob() {
        CompanyEntity company1 = createCompanyEntity();
        repo.save(company1);

        Iterable<CompanyEntity> allCompanies = repo.findAll();

        for (CompanyEntity ce : allCompanies) {

            List<EmployeeEntity> eeList = ce.getEmployees();
            String eeTotal = "";
                for (EmployeeEntity ee : eeList) {
                    eeTotal += String.format("\t%s: %s, %s\n",
                            ee.toString(),
                            ee.getId(),
                            ee.getName()
                    );
                }

                String total = String.format("%s: %s, %s, Employees: \n%s",
                        ce.toString(),
                        ce.getId(),
                        ce.getName(),
                        eeTotal
                );
                System.out.println(total);
        }
    }

    private CompanyEntity createCompanyEntity() {
        CompanyEntity company1 = new CompanyEntity();
        company1.setName("comp1");

        ArrayList<EmployeeEntity> emps = new ArrayList<>();

        EmployeeEntity e1 = new EmployeeEntity();
        e1.setName("emp1");
        EmployeeEntity e2 = new EmployeeEntity();
        e2.setName("emp2");

        emps.add(e1);
        emps.add(e2);

        company1.setEmployees(emps);
        return company1;
    }
}
