package com.example.demo.facades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Coupon;
import com.example.demo.beans.CouponType;
import com.example.demo.dbdao.CustomerDBDAO;

/**
 * 
 * The CustomerFacade class is used by the customer users of the CouponSystem.
 * It grants them access to all of the relevant methods for their uses.
 *
 */
@Service
public class CustomerFacade implements CouponClientFacade
{
	@Autowired
	private CustomerDBDAO customerdbdao;


	public void purchaseCoupon(Coupon coupon)
	{
		
		customerdbdao.purchaseCoupon(coupon);
//		try 
//		{
//			
//		}
//		catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException| UnAvailableCouponException | NullPointerException e) 
//		{
//			CouponExceptionHandler.handle(e);
//		}
	}

	public Collection<Coupon> getAllPurchasedCoupons() 
	{

			List<Coupon> allCustomerCoupons = null;
			
			allCustomerCoupons =  (List<Coupon>) customerdbdao.getCoupons();
//			
//			try 
//			{
//				
//			} 
//			catch (NullPointerException| ClassNotFoundException | InterruptedException | NullConnectionException | SQLException e)
//			{
//				CustomerExceptionHandler.handle(e);
//			}

			return allCustomerCoupons;

	}

	public Collection<Coupon> getAllPurchasedCouponsByType(CouponType coupontype) 
	{
		ArrayList<Coupon> allCustomerCoupons = new ArrayList<>();

		allCustomerCoupons = (ArrayList<Coupon>) customerdbdao.getCouponsByType(coupontype);
//		try 
//		{
//			
//		} 
//		catch (ClassNotFoundException | InterruptedException | NullConnectionException | SQLException e)
//		{
//			CustomerExceptionHandler.handle(e);
//		}

		return allCustomerCoupons;
	}

	public Collection<Coupon> getAllPurchasedCouponsByPrice(double price) 
	{
		ArrayList<Coupon> allCustomerCoupons = new ArrayList<>();
		allCustomerCoupons = (ArrayList<Coupon>) customerdbdao.getCouponsByPrice(price);
		
//		try 
//		{
//			
//		}
//		catch (ClassNotFoundException | InterruptedException | NullConnectionException | SQLException e) 
//		{
//			CustomerExceptionHandler.handle(e);
//		}

		return allCustomerCoupons;
	}


	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType)
	{

		if(customerdbdao.login(name, password))
		{
			return this;
		}
//		try
//		{
//			
//		}
//		catch (ClassNotFoundException | InterruptedException | SQLException | WrongDataInputException
//				| NullConnectionException | NullPointerException e) 
//		{
//			GeneralExceptionHandler.handle(e);
//		}

		return null;
	}
}
