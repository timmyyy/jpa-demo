package com.example.jpa.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaDemoApplication {

    @Autowired
    MyRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        return args -> {
            Company company1 = new Company();
            company1.setName("comp1");

            ArrayList<Employee> emps = new ArrayList<>();

            Employee e1 = new Employee();
            e1.setName("emp1");
            Employee e2 = new Employee();
            e2.setName("emp2");
            emps.add(e1);
            emps.add(e2);

            company1.setEmployee(emps);

            repo.save(company1);

            Iterable<Company> all = repo.findAll();

            System.out.println(((List) all).size());
            all.forEach(company -> System.out.println(company));
        };
    }


}
