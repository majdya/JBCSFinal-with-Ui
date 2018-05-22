package com.example.demo.dbdao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;
import com.example.demo.dao.CouponDAO;
import com.example.demo.repo.CouponRepo;

@Service
public class CouponDBDAO implements CouponDAO {

	@Autowired
	private CouponRepo couponRepo;

	@Override
	public void createCoupon(Coupon coupon) {
		if (coupon != null) {
			couponRepo.save(coupon);
		}

	}

	@Override
	public void removeCoupon(Coupon coupon) {
		if (coupon != null) {
			couponRepo.delete(coupon.getId());
		}

	}

	@Override
	public void updateCoupon(Coupon coupon) {
		if (coupon != null) {
			Coupon temp = couponRepo.findOne(coupon.getId());
			temp.setEndDate(coupon.getEndDate());
			temp.setPrice(coupon.getPrice());

			couponRepo.save(temp);
		}
	}

	@Override
	public Coupon getCoupon(int id) {
		return couponRepo.findOne(id);
	}

	@Override
	public Collection<Coupon> getAllCoupons() {
		return (Collection<Coupon>) couponRepo.findAll();
	}

	@Override
	public Collection<Coupon> getCouponByType(CouponType couponType) {
		Collection<Coupon> temp = new ArrayList<>();
		for (Coupon coupon : couponRepo.findAll()) {
			if (coupon.getType().equals(couponType))
				temp.add(coupon);
		}
		return temp;
	}

	@Override
	public Collection<Coupon> getCouponOutOfDate() {
		Collection<Coupon> temp = new ArrayList<>();
		for (Coupon coupon : couponRepo.findAll()) {
			if (coupon.getEndDate().isAfter(LocalDate.now()))
				temp.add(coupon);
		}
		return temp;
	}

}
