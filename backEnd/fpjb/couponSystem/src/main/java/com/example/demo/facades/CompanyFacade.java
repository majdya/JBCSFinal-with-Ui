package com.example.demo.facades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;
import com.example.demo.dbdao.CompanyDBDAO;
import com.example.demo.dbdao.CouponDBDAO;

@Service
public class CompanyFacade implements CouponClientFacade {
	@Autowired
	private CompanyDBDAO companydbdao;

	@Autowired
	private CouponDBDAO coupondbdao;

	public void createCoupon(Coupon coupon) {
		System.out.println("logged in to try");
		coupondbdao.createCoupon(coupon);
		System.out.println("after creating coupon");
		companydbdao.getCompany(companydbdao.getCompanyId()).addCoupon(coupon);
		System.out.println("after ading coupon to company");

	}

	public void removeCoupon(Coupon coupon) {
		coupondbdao.removeCoupon(coupon);

	}

	public void updateCoupon(Coupon coupon) {
		coupondbdao.updateCoupon(coupon);

	}

	public Coupon getCoupon(int id) {
		Coupon tempCoupon = new Coupon();
		tempCoupon = coupondbdao.getCoupon(id);

		return tempCoupon;
	}

	public Collection<Coupon> getAllCoupons() {
		List<Coupon> ArrayOfCompanyCoupons = new ArrayList<>();
		ArrayOfCompanyCoupons = (List<Coupon>) companydbdao.getCoupons();

		return ArrayOfCompanyCoupons;
	}

	public Collection<Coupon> getCouponByType(CouponType couponType) {
		ArrayList<Coupon> ArrayOfCompanyCouponsByType = new ArrayList<>();

		ArrayOfCompanyCouponsByType = (ArrayList<Coupon>) companydbdao.getCompanyCouponByType(couponType);

		return ArrayOfCompanyCouponsByType;
	}

	public Collection<Coupon> getCouponByPrice(double price) {
		ArrayList<Coupon> ArrayOfCompanyCouponsByPrice = new ArrayList<>();
		ArrayOfCompanyCouponsByPrice = (ArrayList<Coupon>) companydbdao.getCompanyCouponByPrice(price);

		return ArrayOfCompanyCouponsByPrice;
	}

	public Collection<Coupon> getCouponByDate(LocalDate date) {
		ArrayList<Coupon> ArrayOfCompanyCouponsByDate = new ArrayList<>();
		ArrayOfCompanyCouponsByDate = (ArrayList<Coupon>) companydbdao.getCompanyCouponByDate(date);

		return ArrayOfCompanyCouponsByDate;
	}

//	@Override
//	public CouponClientFacade login(String name, String password, ClientType clientType) {
//		if (companydbdao.login("Company 0", "Pass0")) {
//			return this;
//		}
//
//		return null;
//	}
	
	
	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {
		if (name.equals("Company 8") && password.equals("Pass8")&&clientType.equals("Company")) {
			return this;
		}

		return null;
	}

	public void setUserId() {
		this.companydbdao.setCompanyId(companydbdao.getCompanyId());
	}
}
