package com.example.demo.dao;

import java.time.LocalTime;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;

@Component
public interface CompanyDAO {

	public void createCompany(Company company);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// DuplicateEntryException, NullConnectionException, ParseException;

	public void removeCompany(Company company);

	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException, ParseException;
	public void updateCompany(Company company);

	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException, ParseException;
	public Company getCompany(int id);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException, ParseException;

	public Collection<Company> getAllCompanies();
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException, ParseException;

	public Collection<Coupon> getCoupons();
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// ParseException, NullConnectionException;

	public boolean login(String compName, String password);
	// throws ClassNotFoundException, InterruptedException,
	// SQLException, WrongDataInputException, NullConnectionException;

	public Collection<Coupon> getCouponsByCompanyId(int id);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException, ParseException;

	public Collection<Coupon> getCompanyCouponByType(CouponType couponType);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException, ParseException;

	public Collection<Coupon> getCompanyCouponByPrice(double price);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException, ParseException;

	public Collection<Coupon> getCompanyCouponByDate(LocalTime date);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException, ParseException;

}
