package com.example.demo.facades;

import java.sql.SQLException;

public interface CouponClientFacade {
	public CouponClientFacade login(String name, String password, ClientType clientType)
			throws ClassNotFoundException, InterruptedException, SQLException, NullPointerException;
}
