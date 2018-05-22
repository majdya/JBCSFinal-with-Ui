package com.example.demo.RestControllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Company;
import com.example.demo.beans.Customer;
import com.example.demo.facades.AdminFacade;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminFacade adminFacade;

	// -------------------------------------------------------------------------------------------------------------

	// @RequestMapping(value="createCompany" , method = RequestMethod.POST)
	@PostMapping(value = "createCompany")//Pass
	public ResponseEntity<Company> createCompany(@RequestBody Company company) {
		// calling the facade to create the company
		adminFacade.createCompany(company);

		// returning responseEntity with Created HttpStatus
		return new ResponseEntity<Company>(HttpStatus.CREATED);
	}

	// -------------------------------------------------------------------------------------------------------------
	//Delete by sending the company
	@DeleteMapping(value = "deleteCompany")//Pass
	public ResponseEntity<Company> deleteCompany(@RequestBody Company company) {
		// calling the facade to delete the company
		adminFacade.removeCompany(company);

		// returning responseEntity with Created HttpStatus
		return new ResponseEntity<Company>(HttpStatus.OK);

	}
	
	// -------------------------------------------------------------------------------------------------------------
		//Delete by sending the id
		@DeleteMapping(value = "deleteCompany/{id}")//Pass
		public ResponseEntity<Company> deleteCompany(@PathVariable int id) {
			// calling the facade to delete the company
			adminFacade.removeCompanyById(id);

			// returning responseEntity with Created HttpStatus
			return new ResponseEntity<Company>(HttpStatus.OK);

		}

	// -------------------------------------------------------------------------------------------------------------
	@PutMapping(value = "updateCompany")//Pass **must send the id !! bad idea**
	public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
		// calling the facade to delete the company
		adminFacade.updateCompany(company);

		// returning responseEntity with Created HttpStatus
		return new ResponseEntity<Company>(HttpStatus.OK);

	}

	// -------------------------------------------------------------------------------------------------------------
	@GetMapping(value = "getCompany/{id}")//Pass
	public ResponseEntity<Company> getCompany(@PathVariable int id) {

		Company tempCompany = adminFacade.getCompany(id);

		if (tempCompany == null)
			return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);

		// deleting the null coupons from the list to prevent json having them
		tempCompany.getCoupons().remove(null);
		return new ResponseEntity<Company>(tempCompany, HttpStatus.OK);

	}

	// -------------------------------------------------------------------------------------------------------------
	@GetMapping(value = "getAllCompanies")//Pass
	public ResponseEntity<ArrayList<Company>> getAllCompanies() {

		// return adminFacade.getCompany(id);
		ArrayList<Company> allCompanies = (ArrayList<Company>) adminFacade.getAllCompanies();

		if (allCompanies == null)
			return new ResponseEntity<ArrayList<Company>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<ArrayList<Company>>(allCompanies, HttpStatus.OK);
	}

	// **************************************************************************************************************
	@PostMapping(value = "createCustomer")//Pass
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		// calling the facade to create the customer
		adminFacade.createCustomer(customer);

		// returning responseEntity with Created HttpStatus
		return new ResponseEntity<Customer>(HttpStatus.CREATED);
	}

	// -------------------------------------------------------------------------------------------------------------
	@DeleteMapping(value = "deleteCustomer")//Pass
	public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) {
		// calling the facade to delete the company
		adminFacade.removeCustomer(customer);

		// returning responseEntity with Created HttpStatus
		return new ResponseEntity<Customer>(HttpStatus.OK);

	}
	
	@DeleteMapping(value = "deleteCustomer/{id}")//Pass
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
		// calling the facade to delete the company
		adminFacade.removeCustomerById(id);

		// returning responseEntity with Created HttpStatus
		return new ResponseEntity<Customer>(HttpStatus.OK);

	}

	// -------------------------------------------------------------------------------------------------------------
	@PutMapping(value = "updateCustomer")//Pass **Need to pass ID - bad idea**
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		// calling the facade to delete the company
		adminFacade.updateCustomer(customer);

		// returning responseEntity with Created HttpStatus
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	// -------------------------------------------------------------------------------------------------------------
	@GetMapping(value = "getCustomer/{id}")//Pass
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {

		// return adminFacade.getCompany(id);

		Customer tempCustomer = adminFacade.getCustomer(id);

		if (tempCustomer == null)
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Customer>(tempCustomer, HttpStatus.OK);

	}

	// -------------------------------------------------------------------------------------------------------------
	@GetMapping(value = "getAllCustomers")//Pass
	public ResponseEntity<ArrayList<Customer>> getAllCustomer() {

		// return adminFacade.getCompany(id);
		ArrayList<Customer> allCustomer = (ArrayList<Customer>) adminFacade.getAllCustomers();

		if (allCustomer == null)
			return new ResponseEntity<ArrayList<Customer>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<ArrayList<Customer>>(allCustomer, HttpStatus.OK);
	}

}
