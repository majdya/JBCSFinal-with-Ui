package com.example.demo.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope(value="singleton")
public class CouponSystem 
{	
	
	@Autowired
    AdminFacade adminfacade;

	@Autowired
    CompanyFacade companyfacade;
    
	@Autowired
	CustomerFacade customerfacade;	
	
	public CouponClientFacade login(String name,String password,ClientType clientType)
	{
		CouponClientFacade login = null;
		//ApplicationContext context = new AnnotationConfigApplicationContext();

		switch(clientType)
		{
		case customer :
			login = customerfacade.login(name, password, clientType);
			if (login!=null)
			{
				System.out.println("Signed AS  \nname : " + name + "\ntype : customer");
				System.out.println("-------------");
				return customerfacade;
			}
			break;

		case company : 
			login = companyfacade.login(name, password, clientType);
			if (login!=null)
			{
				System.out.println("Signed AS \nname : " + name + "\ntype : company");
				System.out.println("-------------");
				companyfacade.setUserId();
				return companyfacade;
			}
			break;

		case admin : 
			login = adminfacade.login(name, password, clientType);
			if (login!=null)
			{
				System.out.println("Signed AS admin");
				System.out.println("-------------");
				return adminfacade;
			}
		}

		return null;
	}
}