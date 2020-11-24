package com.example.form;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customers, Long> {
}
