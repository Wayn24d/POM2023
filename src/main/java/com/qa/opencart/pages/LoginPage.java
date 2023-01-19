package com.qa.opencart.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constatns.AppConstants;
import com.qa.opencart.utils.ElementUtils;

import io.qameta.allure.Step;

public class LoginPage {
	
			
			private ElementUtils eu;
			private WebDriver driver;
			private Properties prop;
			
			
			// 1. By locator - Object Repository should be maintained.

						private By email = By.id("input-email");
				
						private By password = By.id("input-password");
				
						private By btn = By.xpath("//input[@value='Login']");
						
						private By forgotpasslink = By.linkText("Forgotten Password");
						
						private By registerlink = By.linkText("Register");
						
			
			
			
			
			
			
			
			// 2. Create Constructor Method : 
			
			public LoginPage(WebDriver driver) 
			{
				this.driver = driver;
				eu = new ElementUtils(driver);
			}
			
			
			
			
			
			// 3. Method Actions
			
			
			public String getLoginPageTitle() 
			{
				return eu.waitForTitleTobe(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_WAIT_TIME);
			}
	
			
			
			public boolean check() 
			{
				return eu.getElement(btn).isDisplayed();
			}
	
	
	
			public MyAccountPage login(String username , String Password) 
			{
				eu.SendKeysWith_Wait(email, 5, username);
				eu.SendKeysWith_Wait(password, 5, Password);
				eu.click(btn);
				return new MyAccountPage(driver);
				
			}
			
			@Step("waiting and clicikng on Webelment")
			public void click() 
			{
				eu.waitAndClick(btn, 3);
			}
	
			
			@Step("navegating to registeration page")
			public RegisterPage gotoRegestrition() 
			{
				eu.click(registerlink);
				System.out.println("Entering into Registeration Page .....");
				return new RegisterPage(driver);
			}
	
	
	
	
					

}
