package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.RegisterPage;

public class BaseTest {
	
	
	
	public	WebDriver driver;
	
    public DriverFactory drfactory;
    
    public LoginPage loginpage;
    
    public MyAccountPage MAP;
    
    public Properties prop;
    
    public RegisterPage rp;
    
    public SoftAssert softAssert;
    
    
    @BeforeTest
	public void setup() 
	{
    	drfactory = new DriverFactory();
		
//    	String browsername = prop.getProperty("browser");
		
    	prop = drfactory.initprop();
    	
	    driver = drfactory.initializeDriver(prop);
	    loginpage = new LoginPage(driver);
	    softAssert = new SoftAssert();
	    
	    
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}
	
	
	
	
			
	
	
	

}
