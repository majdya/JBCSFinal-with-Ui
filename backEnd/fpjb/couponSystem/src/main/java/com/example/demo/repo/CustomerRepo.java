package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
