package com.example.demo.dao;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;

@Component
public interface CouponDAO {

	public void createCoupon(Coupon coupon);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// DuplicateEntryException, NullConnectionException;

	public void removeCoupon(Coupon coupon);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// DuplicateEntryException, NullConnectionException,
	// UnAvailableCouponException, NullPointerException;

	public void updateCoupon(Coupon coupon);
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// ParseException, NullConnectionException, UnAvailableCouponException;

	public Coupon getCoupon(int id);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// ParseException,
	// NullConnectionException, UnAvailableCouponException;

	public Collection<Coupon> getAllCoupons();
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// ParseException, NullConnectionException, UnAvailableCouponException;

	public Collection<Coupon> getCouponByType(CouponType couponType);
	// throws SQLException, ClassNotFoundException, InterruptedException,
	// ParseException, NullConnectionException;

	public Collection<Coupon> getCouponOutOfDate();
	// throws ClassNotFoundException, InterruptedException, SQLException,
	// ParseException, NullConnectionException;

}