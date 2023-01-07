package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constatns.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class RegisterPage {
	
	
			private WebDriver driver;
			private ElementUtils eu;
	
	
			// 1. By Locator :
			
			
			
			
		    private By firstName = By.xpath("//div/input[@name='firstname']");
			
		    private By lastName = By.xpath("//div/input[@name='lastname']");

		    private By email = By.xpath("//div/input[@name='email']");
		    
		    private By telephone = By.xpath("//div/input[@name='telephone']");

		    private By password = By.xpath("//div/input[@name='password']");
			
		    private By confirmPassword = By.xpath("//div/input[@name='confirm']");
		    
		    private By subscribeYes = By.xpath("(//label[@class='radio-inline']/input[@type='radio'])[1]");
		    private By subscribeNo = By.xpath("(//label[@class='radio-inline']/input[@type='radio'])[2]");
		    
		    private By checkbox = By.name("agree");
		    private By continubtn = By.xpath("//input[@type='submit' and @value='Continue']");
		    private By m = By.xpath("(//div/p)[1]");
		    // private By error = By.xpath("//*[@id=\"account-register\"]/div[1]/text()"); 
		    
		    private By logoutLink = By.linkText("Logout");
		    private By registerLink = By.linkText("Register");
			
			// 2. Constructor:
			
			public RegisterPage(WebDriver driver)
			{
				this.driver = driver;
				eu =  new ElementUtils(driver);
			}
			
			
			// 3. Class Actions :
			
			
			public boolean createUser(String firstName,String lastName,String email,String telephone,String password,String subscribe) 
			{
				eu.waitFor(this.firstName, AppConstants.MEDUIM_WAIT_TIME).sendKeys(firstName);
				eu.SendKeys(this.lastName, lastName);
				eu.SendKeys(this.email, email);
				eu.SendKeys(this.telephone, telephone);
				eu.SendKeys(this.password, password);
				eu.SendKeys(this.confirmPassword, password);
				
				if(subscribe.equalsIgnoreCase("yes")) 
				{
					eu.click(subscribeYes);
				}
				else
				{
					eu.click(subscribeNo);
				}
				
	
				eu.click(checkbox);
				
				eu.click(continubtn);
				
				System.out.println("Clicking Continue......");
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				
				
				
				String actualSuceessMessage = eu.WaitFor(m, AppConstants.SHORT_WAIT_TIME).getText();
				
				System.out.println(actualSuceessMessage);
				
				
				if(actualSuceessMessage.contains(AppConstants.REGISTER_SUCCESS_MEASSAGE)) 
				{
					
					return true;
				}
				
				return false;
			}
	
			
			
			public void navigateToRegisterPage()
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				eu.click(logoutLink);
				eu.click(registerLink);
				
			}
	
	
	
	
	

}
