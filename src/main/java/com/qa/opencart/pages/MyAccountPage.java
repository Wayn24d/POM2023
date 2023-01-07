package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constatns.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class MyAccountPage {
	
	
	private static WebDriver driver;
	private ElementUtils eu;
	
	
	
	 // 1. By locator:
	
		By title = By.xpath("//head//title");
		By btn = By.linkText("Logout");
		
		
		
		// 2. Method constructor:
		
		 public MyAccountPage(WebDriver driver)
		 {
			 this.driver = driver;
			 eu = new ElementUtils(driver);
		 }
		 
		 
		 
		 	// 3. Page Actions : 
		 		
		 
		 
		 
		 public String getMyAccountPageTitle() 
			{
				return eu.waitForTitleTobe(AppConstants.MYACCOUNT_PAGE_TITLE, AppConstants.SHORT_WAIT_TIME);
			}
		 
		 
		 
		 
		 
		 public void click() 
		 {
			 eu.waitAndClick(btn, 5);
		 }

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
