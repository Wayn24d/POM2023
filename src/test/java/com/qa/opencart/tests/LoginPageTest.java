package com.qa.opencart.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constatns.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(" Epic _ 100 :Design Login page features for open cart application ")
@Story(" US _ 100 : dwesign ligin page features with login, forgot pwd, title, url ")
public class LoginPageTest extends BaseTest {
	
	
	
			@Test
			@Description("TC_01 : loginpage Title Test")
			@Severity(SeverityLevel.NORMAL)
			public void loginpageTitleTest() 
			{
				String actualTitle = loginpage.getLoginPageTitle();
				Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
			}
	
	
			@Test(enabled = false)
			public void loginPageFooterTest() 
			{
				System.out.println("loginPage Footer Test");
			}
	
	
	
	
	
	
	
	
	
	

}
