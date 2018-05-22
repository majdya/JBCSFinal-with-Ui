package com.example.demo.facades;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Company;
import com.example.demo.beans.Customer;
import com.example.demo.dbdao.CompanyDBDAO;
import com.example.demo.dbdao.CustomerDBDAO;

//import ExceptionHandler.CompanyExceptionHandler;
//import ExceptionHandler.CustomerExceptionHandler;
//import exceptions.DuplicateEntryException;
//import exceptions.NullConnectionException;

@Service
public class AdminFacade implements CouponClientFacade {
	@Autowired
	private CompanyDBDAO companydbdao;

	@Autowired
	private CustomerDBDAO customerdbdao;

	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {
		if (name.equals("admin") && password.equals("1234")&&clientType.equals("Admin")) {
			return this;
		}

		return null;
	}
	
	public void createCompany(Company company) {
		companydbdao.createCompany(company);

		// try
		// {
		//
		// }
		// catch (ClassNotFoundException | InterruptedException | SQLException |
		// DuplicateEntryException
		// | NullConnectionException | ParseException e)
		// {
		// CompanyExceptionHandler.handle(e);
		// }
	}

	public void removeCompany(Company company) {
		companydbdao.removeCompany(company);
		// try
		// {
		//
		// }
		// catch (ClassNotFoundException | InterruptedException | SQLException |
		// NullConnectionException
		// | ParseException e)
		// {
		// CompanyExceptionHandler.handle(e);
		// }

	}
	
	public void removeCompanyById(int id) {
		companydbdao.removeCompanyById(id);
		// try
		// {
		//
		// }
		// catch (ClassNotFoundException | InterruptedException | SQLException |
		// NullConnectionException
		// | ParseException e)
		// {
		// CompanyExceptionHandler.handle(e);
		// }

	}

	public void updateCompany(Company company) {
		companydbdao.updateCompany(company);
		// try {
		//
		// } catch (ClassNotFoundException | InterruptedException | SQLException
		// | NullConnectionException
		// | ParseException e) {
		// CompanyExceptionHandler.handle(e);
		// }

	}

	public Company getCompany(int id) {
		Company tempCompany = new Company();

		tempCompany = companydbdao.getCompany(id);
		// try {
		//
		// } catch (ClassNotFoundException | InterruptedException | SQLException
		// | NullConnectionException
		// | ParseException e) {
		// CompanyExceptionHandler.handle(e);
		// }

		return tempCompany;
	}

	public Collection<Company> getAllCompanies() {
		ArrayList<Company> tempArrayOfCompanies = new ArrayList<>();
		tempArrayOfCompanies = (ArrayList<Company>) companydbdao.getAllCompanies();

		// try {
		//
		// } catch (ClassNotFoundException | InterruptedException | SQLException
		// | NullConnectionException
		// | ParseException e) {
		// CompanyExceptionHandler.handle(e);
		//
		// }
		return tempArrayOfCompanies;
	}

	public void createCustomer(Customer customer) {
		customerdbdao.createCustomer(customer);
		// try {
		//
		// } catch (ClassNotFoundException | InterruptedException | SQLException
		// | DuplicateEntryException
		// | NullConnectionException e) {
		// CustomerExceptionHandler.handle(e);
		// }
	}

	public void removeCustomer(Customer customer) {
		customerdbdao.removeCustomer(customer);
		// try {
		//
		// } catch (ClassNotFoundException | InterruptedException | SQLException
		// | NullConnectionException e) {
		// CustomerExceptionHandler.handle(e);
		// }
	}
	
	public void removeCustomerById(int id) {
		customerdbdao.removeCustomerById(id);
		// try {
		//
		// } catch (ClassNotFoundException | InterruptedException | SQLException
		// | NullConnectionException e) {
		// CustomerExceptionHandler.handle(e);
		// }
	}

	public void updateCustomer(Customer customer) {

		customerdbdao.updateCustomer(customer);
		// try {
		//
		// } catch (ClassNotFoundException | InterruptedException | SQLException
		// | NullConnectionException e) {
		// CustomerExceptionHandler.handle(e);
		// }

	}

	public Customer getCustomer(int id) {
		Customer tempCustomer = new Customer();
		tempCustomer = customerdbdao.getCustomer(id);

		// try {
		//
		// } catch (ClassNotFoundException | InterruptedException | SQLException
		// | NullConnectionException e) {
		// CustomerExceptionHandler.handle(e);
		// }

		return tempCustomer;
	}

	public Collection<Customer> getAllCustomers() {
		ArrayList<Customer> tempArrayOfCustomers = new ArrayList<>();

		tempArrayOfCustomers = (ArrayList<Customer>) customerdbdao.getAllCustomer();

		// try {
		// } catch (ClassNotFoundException | InterruptedException | SQLException
		// | NullConnectionException e) {
		// CustomerExceptionHandler.handle(e);
		// }

		return tempArrayOfCustomers;
	}


}
