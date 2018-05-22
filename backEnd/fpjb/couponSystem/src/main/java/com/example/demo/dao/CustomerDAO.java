package com.example.demo.dao;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;
import com.example.demo.beans.Customer;

@Component
public interface CustomerDAO {

	public void createCustomer(Customer customer);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// DuplicateEntryException, NullConnectionException ;

	public void removeCustomer(Customer customer);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// NullConnectionException;

	public void updateCustomer(Customer customer);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// NullConnectionException;

	public Customer getCustomer(int id);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// NullConnectionException;

	public Collection<Customer> getAllCustomer();
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// NullConnectionException;

	public Collection<Coupon> getCoupons();
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// NullConnectionException, NullPointerException;

	public boolean login(String custName, String password);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// WrongDataInputException, NullConnectionException;

	public Collection<Coupon> getCouponsByCustomerId(int id);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// NullConnectionException, NullPointerException;

	public Collection<Coupon> getCouponsByType(CouponType couponType);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// NullConnectionException;

	public Collection<Coupon> getCouponsByPrice(double price);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// NullConnectionException;

	public void purchaseCoupon(Coupon coupon);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException,UnAvailableCouponException;

	public boolean isValidAmount(Coupon coupon);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException,UnAvailableCouponException;

	public boolean isValidDate(Coupon coupon);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException,UnAvailableCouponException;

	public boolean isFirstBuy(Coupon coupon);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// NullConnectionException,UnAvailableCouponException;

}
