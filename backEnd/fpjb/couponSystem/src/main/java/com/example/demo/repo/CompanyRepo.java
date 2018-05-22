package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Company;

@Repository
public interface CompanyRepo extends CrudRepository<Company, Integer> {

	public Company findBycompNameAndPassword(String compName , String password);

}
