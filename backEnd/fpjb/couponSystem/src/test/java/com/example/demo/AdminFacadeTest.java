package com.example.demo;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.beans.Company;
import com.example.demo.beans.Customer;
import com.example.demo.facades.AdminFacade;
import com.example.demo.facades.ClientType;
import com.example.demo.facades.CouponClientFacade;
import com.example.demo.facades.CouponSystem;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminFacadeTest {

	@Autowired
	private AdminFacade adminFacade;

	@Autowired
	private CouponSystem couponSystem;

	CouponClientFacade c = null;

//	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");



	//@Test
	public void _00_LoginTest() throws ClassNotFoundException, InterruptedException, SQLException, ParseException {
		String username = "admin";
		String password = "1234";
		System.out.println("!!!!");
		adminFacade = (AdminFacade) couponSystem.login(username, password, ClientType.admin);

		System.out.println("end of loginTest");
	}

	//@Test
	// get current company
	public void _01_getCompanyTest() throws ClassNotFoundException, InterruptedException, SQLException, ParseException {
		System.out.println(adminFacade);
		Company company = adminFacade.getCompany(8);
		System.out.println(company);
	}
	
	//@Test
	// get current company
	public void _02_getCompanyTest() throws ClassNotFoundException, InterruptedException, SQLException, ParseException {
		System.out.println(adminFacade);
		Company company = adminFacade.getCompany(8);
		System.out.println(company);
	}
	
	//Admin facade Login + crud company + getAllCompanies()
	//@Test
	public void _AdminFacadeCompany()
	{
		System.out.println("TEST LOG IN");
		String username = "admin";
		String password = "1234";
		System.out.println("!!!!");
		adminFacade = (AdminFacade) couponSystem.login(username, password, ClientType.admin);
		System.out.println("Log in Completed");
		
		System.out.println("Create Company:");
		Company comp1=new Company("testing","testpass","addedbytest@mail.com");
		adminFacade.createCompany(comp1);
		System.out.println("testing get company by id"+ comp1.getId());
		System.out.println(adminFacade.getCompany(comp1.getId()));
		
		System.out.println("testing update company To ZZZZ"+ comp1.getId());
		comp1.setEmail("zzzzzz@ZZ.zz");
		adminFacade.updateCompany(comp1);
		System.out.println(adminFacade.getCompany(comp1.getId()));
		
		System.out.println("testing get company by id"+7);
		System.out.println(adminFacade.getCompany(7));
		
		System.out.println("testing delete company"+8);
		adminFacade.removeCompanyById(8);
		System.out.println(adminFacade.getCompany(8));
		
		System.out.println("Testing get all companies");
		adminFacade.getAllCompanies().forEach(comp ->System.out.println(comp));
	}
	
	//Admin facade Login + crud customer + getAllCustomers()
	@Test
	public void s()
	{
		System.out.println("TEST LOG IN");
		String username = "admin";
		String password = "1234";
		System.out.println("!!!!");
		adminFacade = (AdminFacade) couponSystem.login(username, password, ClientType.admin);
		System.out.println("Log in Completed");
		
		System.out.println("Create Customer:");
		Customer cust1=new Customer("Majd","password");
		adminFacade.createCustomer(cust1);
		System.out.println("testing get company by id"+ cust1.getId());
		System.out.println(adminFacade.getCompany(cust1.getId()));

		
		System.out.println("testing update company To ZZZZ"+ cust1.getId());
		cust1.setCustName("ZZZZZ");
		adminFacade.updateCustomer(cust1);
		System.out.println(adminFacade.getCustomer(cust1.getId()));
		
		System.out.println("testing get company by id"+9);
		System.out.println(adminFacade.getCustomer(9));
		
		System.out.println("testing delete Customer "+3);
		adminFacade.removeCustomerById(3);
		System.out.println(adminFacade.getCustomer(3));
		
		System.out.println("Testing get all Customer");
		adminFacade.getAllCustomers().forEach(cust ->System.out.println(cust));
	}
}
