package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constatns.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	
	
	
	
			@BeforeClass
			public void RegisterPageSetup() 
			{
				rp = loginpage.gotoRegestrition();
			}
	
			
			
			public String randomEmail() 
			{
				Random rand = new Random();
				String email = "user" + rand.nextInt(1000) + "@gmail.com";
				return email;
			}
			
			
			
			
			@DataProvider
			public Object[][] getExcelData() 
			{
				Object[][] regdata = ExcelUtil.getTestData(AppConstants.REGISTER);
				return regdata;
			}
			
	
	
			@Test(dataProvider = "getExcelData")
			public void createUserTest(String firstName,String lastName,String telephone,String password,String subscribe) 
			{
				boolean usercheck = rp.createUser(firstName, lastName, randomEmail(), telephone, password, subscribe);
				rp.navigateToRegisterPage();
				Assert.assertEquals(usercheck, true);
			}
	
	
	
	
	
	
	

}
