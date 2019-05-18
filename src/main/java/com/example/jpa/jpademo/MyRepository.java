package com.example.jpa.jpademo;

import org.springframework.data.repository.CrudRepository;

public interface MyRepository extends CrudRepository<CompanyEntity, Integer> {
}
