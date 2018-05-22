package com.example.demo.dbdao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;
import com.example.demo.beans.Customer;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.repo.CouponRepo;
import com.example.demo.repo.CustomerRepo;

@Service
public class CustomerDBDAO implements CustomerDAO {
	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CouponRepo couponRepo;

	@Override
	public void purchaseCoupon(Coupon coupon) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean login(String custName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFirstBuy(Coupon coupon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createCustomer(Customer customer) {
		if (customer != null) {
			customerRepo.save(customer);
		}
	}

	@Override
	public void removeCustomer(Customer customer) {
		if (customer != null) {
			customerRepo.delete(customer);
		}
	}
	
	public void removeCustomerById(int id) {
		if (customerRepo.findOne(id) != null) {
			customerRepo.delete(customerRepo.findOne(id));
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		if (customer != null) {
			Customer c = customerRepo.findOne(customer.getId());
			c.setCoupons(customer.getCoupons());
			c.setCustName(customer.getCustName());
			c.setPassword(customer.getPassword());

			customerRepo.save(c);
		}
	}

	@Override
	public Customer getCustomer(int id) {
		return customerRepo.findOne(id);
	}

	@Override
	public Collection<Customer> getAllCustomer() {
		return (Collection<Customer>) customerRepo.findAll();
	}

	@Override
	public Collection<Coupon> getCoupons() {
		return this.getCoupons();
	}

	@Override
	public Collection<Coupon> getCouponsByCustomerId(int id) {
		return customerRepo.findOne(id).getCoupons();
	}

	@Override
	public Collection<Coupon> getCouponsByType(CouponType couponType) {
		Collection<Coupon> temp = new ArrayList<>();
		for (Coupon coupon : couponRepo.findAll()) {
			if (coupon.getType().equals(couponType))
				temp.add(coupon);
		}
		return temp;

	}

	@Override
	public Collection<Coupon> getCouponsByPrice(double price) {
		Collection<Coupon> temp = new ArrayList<>();
		for (Coupon coupon : couponRepo.findAll()) {
			if (coupon.getPrice() == (price))
				temp.add(coupon);
		}
		return temp;
	}

	@Override
	public boolean isValidAmount(Coupon coupon) {
		return coupon.getAmount() > 0;
	}

	@Override
	public boolean isValidDate(Coupon coupon) {
		return coupon.getEndDate().isAfter(LocalDate.now());
	}

}