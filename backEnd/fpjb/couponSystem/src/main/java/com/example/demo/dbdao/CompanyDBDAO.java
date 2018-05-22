package com.example.demo.dbdao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Company;
import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;
import com.example.demo.dao.CompanyDAO;
import com.example.demo.repo.CompanyRepo;

@Service
public class CompanyDBDAO implements CompanyDAO {
	@Autowired
	private CompanyRepo companyRepo;

	// @Autowired
	// private CouponRepo couponRepo;

	private int compId;

	@Override
	public Collection<Coupon> getCoupons() {
		return companyRepo.findOne(compId).getCoupons();
	}

	public void setCompanyId(int companyId) {
		this.compId = companyId;
	}

	@Override
	public boolean login(String compName, String password) {
		Company tempCompany = companyRepo.findBycompNameAndPassword(compName, password);
		if (tempCompany == null) {
			System.out.println("*****");
			return false;
		}
		setCompanyId(tempCompany.getId());
		return true;

	}

	@Override
	public Collection<Coupon> getCompanyCouponByDate(LocalTime date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCompany(Company company) {
		if (company != null) {
			companyRepo.save(company);
		}

	}

	@Override
	public void removeCompany(Company company) {
		if (company != null) {
			companyRepo.delete(company);
		}

	}

	public void removeCompanyById(int id) {
		try {
			companyRepo.delete(companyRepo.findOne(id));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void updateCompany(Company company) {
		if (company != null) {
			Company temp = companyRepo.findOne(company.getId());
			temp.setCompName(company.getCompName());
			temp.setCoupons(company.getCoupons());
			temp.setEmail(company.getEmail());
			temp.setPassword(company.getPassword());

			companyRepo.save(temp);
		}

	}

	@Override
	public Company getCompany(int id) {
		return companyRepo.findOne(id);
	}

	@Override
	public Collection<Company> getAllCompanies() {
		return (Collection<Company>) companyRepo.findAll();
	}

	@Override
	public Collection<Coupon> getCouponsByCompanyId(int id) {
		return companyRepo.findOne(id).getCoupons();
	}

	@Override
	public Collection<Coupon> getCompanyCouponByType(CouponType couponType) {
		Collection<Coupon> temp = new ArrayList<>();
		for (Coupon coupon : this.getCoupons()) {
			if (coupon.getType().equals(couponType))
				temp.add(coupon);
		}
		return temp;
	}

	@Override
	public Collection<Coupon> getCompanyCouponByPrice(double price) {
		Collection<Coupon> temp = new ArrayList<>();
		for (Coupon coupon : this.getCoupons()) {
			if (coupon.getPrice() == price)
				temp.add(coupon);
		}
		return temp;
	}


	// return all the coupons that ends after the given date
	public ArrayList<Coupon> getCompanyCouponByDate(LocalDate date) {
		ArrayList<Coupon> cl = new ArrayList<>();

		for (Coupon c : companyRepo.findOne(compId).getCoupons()) {
			if (c.getEndDate().isAfter(date)) {
				cl.add(c);
			}
		}
		return null;
	}

	public int getCompany() {
		return compId;

	}
	

	public int getCompanyId() {

		return compId;
	}

}