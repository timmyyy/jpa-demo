package com.example.jpa.jpademo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @ElementCollection(targetClass = Company.class)
    private List<Company> company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }
}