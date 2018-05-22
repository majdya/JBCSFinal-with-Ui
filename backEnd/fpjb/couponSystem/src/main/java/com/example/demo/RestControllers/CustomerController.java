package com.example.demo.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;
import com.example.demo.facades.CustomerFacade;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{

	@Autowired
	private CustomerFacade customerFacade;

	@PostMapping("/purchaseCoupon")
	public ResponseEntity<Coupon> purchaseCoupon(@RequestBody Coupon coupon)
	{
		customerFacade.purchaseCoupon(coupon);
		return new ResponseEntity<Coupon>(HttpStatus.OK);
	}
	//------------------------------------------------------------------------------------------------------
	@GetMapping("/getallpurchasedcoupons")
	public ResponseEntity<List<Coupon>> getAllPurchasedCoupons()
	{
		List<Coupon> allCustomerCoupons = (List<Coupon>) customerFacade.getAllPurchasedCoupons();

		if(allCustomerCoupons == null)
			return new ResponseEntity<List<Coupon>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Coupon>>(allCustomerCoupons , HttpStatus.OK);
	}
	//------------------------------------------------------------------------------------------------------
	@GetMapping(value="getallpurchasedcouponsbytype/{couponType}")
	public ResponseEntity<List<Coupon>> getAllCouponsByType(@PathVariable CouponType couponType)
	{

		List<Coupon> allCustomerCoupons = (List<Coupon>) customerFacade.getAllPurchasedCouponsByType(couponType);

		if(allCustomerCoupons == null)
			return new ResponseEntity<List<Coupon>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Coupon>>(allCustomerCoupons , HttpStatus.OK);	
	}
	//------------------------------------------------------------------------------------------------------
	@GetMapping(value="getallpurchasedcouponsbyprice/{price}")
	public ResponseEntity<List<Coupon>> getAllCouponsByPrice(@PathVariable int price)
	{

		List<Coupon> allCoupons = (List<Coupon>) customerFacade.getAllPurchasedCouponsByPrice(price);

		if(allCoupons == null)
			return new ResponseEntity<List<Coupon>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Coupon>>(allCoupons , HttpStatus.OK);	
	}
}
