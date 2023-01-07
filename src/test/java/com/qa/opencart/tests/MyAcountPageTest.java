package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constatns.AppConstants;

public class MyAcountPageTest extends BaseTest {
	
	
	
	
	@BeforeClass
	public void MyAcountPageSetup() 
	{
		
		 MAP = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 
	}
	
	
	
	@Test
	public void MyAcountPageChechTitle() 
	{
		Assert.assertEquals(MAP.getMyAccountPageTitle(), AppConstants.MYACCOUNT_PAGE_TITLE);
	}
	
	
	
	

}
