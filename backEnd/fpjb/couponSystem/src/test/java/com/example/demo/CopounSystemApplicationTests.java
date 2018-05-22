package com.example.demo;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;
import com.example.demo.beans.Customer;
import com.example.demo.dbdao.CompanyDBDAO;
import com.example.demo.dbdao.CouponDBDAO;
import com.example.demo.dbdao.CustomerDBDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CopounSystemApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	CompanyDBDAO comps;

	@Autowired
	CustomerDBDAO custs;

	@Autowired
	CouponDBDAO coupons;

	@Test // fill customer db
	public void _00_fillCustomersDB() {
		for (int i = 0; i < 10; i++) {

			Customer c = new Customer("customer " + i, "Pass " + i);
			custs.createCustomer(c);
		}
	}

	@Test // fill customer db
	public void _01_fillCompanyDB() {
		for (int i = 0; i < 10; i++) {

			Company c = new Company("Company " + i, "Pass" + i, "Email." + i + "@gmail.com");
			comps.createCompany(c);
		}
	}

	@Test
	public void _02_fillCouponDB() {
		for (int i = 0; i < 5; i++) {
			Coupon c = new Coupon("test" + i, LocalDate.of(2010, 10, 10), LocalDate.of(2020, 10, 10), i * 10,
					CouponType.values()[i], "Just For Testing" + i, i * 6.2, "Supose to an url" + i);
			coupons.createCoupon(c);
		}
		System.out.println(coupons.getCoupon(1).getStartDate() + "!!!!!!");
	}

	@Test
	public void _03_Test_Comp_Facade() {
		
		//System.out.println(comps.login("Company 2","Pass2"));
	}

}
