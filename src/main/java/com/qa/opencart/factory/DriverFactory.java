package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager oman;
	
							public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	
	
			public WebDriver initializeDriver(Properties prop) 
			{
				
				oman = new OptionsManager(prop);
				
				String browserName = prop.getProperty("browser");
				System.out.println(browserName);
				
				if(browserName.equalsIgnoreCase("chrome")) 
				{
					WebDriverManager.chromedriver().setup();
					//this.driver = new ChromeDriver(oman.getChromeOptions());
					tldriver.set( new ChromeDriver(oman.getChromeOptions()));
				}
				else if(browserName.equalsIgnoreCase("edge")) 
				{
					WebDriverManager.edgedriver().setup();
					//this.driver = new EdgeDriver(oman.getEdgeOptions());
					tldriver.set( new EdgeDriver(oman.getEdgeOptions()));
				}
				else if(browserName.equalsIgnoreCase("firefox")) 
				{
					WebDriverManager.firefoxdriver().setup();
					//this.driver = new FirefoxDriver(oman.getFirefoxOptions());
					tldriver.set( new FirefoxDriver(oman.getFirefoxOptions()));
				}
				else if(browserName.equalsIgnoreCase("safari")) 
				{
					this.driver = new SafariDriver();
				}
				else
				{
					System.out.println("Pass the right browser name.....");
				}
				
				getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				getDriver().manage().deleteAllCookies();
				getDriver().manage().window().fullscreen();
				getDriver().get(prop.getProperty("url"));
				
				
				return getDriver();
				
			}
			
			
			
			
			
			
			
			public static synchronized WebDriver getDriver() 
			{
				return tldriver.get();
			}
			
			
			
			
			public Properties initprop() 
			{
				
				 prop = new Properties();
				 
				 FileInputStream ip = null;
				 
				 String envName = System.getProperty("env");
				 System.out.println("running test cases on enviroment : " + envName);
				 
				 if(envName==null) 
				 {
					 System.out.println("No enviroment is given running on production enviroment....");
					 
					 try 
					 {
						ip = new FileInputStream("./src/test/resources/config/config.resources");
					 } 
					 catch (FileNotFoundException e) 
					 {						
						e.printStackTrace();
					 }
				 }
				 else 
				 {
					try {
					switch (envName.toLowerCase()) {
					case "qa":
						ip = new FileInputStream("/POMsessions2022/src/test/resources/config/qa.config.properties");
						break;
						
					case "stage":
						ip = new FileInputStream("/POMsessions2022/src/test/resources/config/stage.config.properties");
						break;
						
					case "production":
						ip = new FileInputStream("./src/test/resources/config.resources");
						break;

					default:System.out.println("Please pass the right enviroment....");
						break;
					  }
					
					 }
					catch(FileNotFoundException e) 
					{
						e.printStackTrace();
					}
				 }
				
				
				 try 
				 {
					prop.load(ip);
				 } 
				 catch (IOException e) 
				 {
					
					e.printStackTrace();
				 }
				
				return prop;
				
			}
			
			
			/**
			 * Take Screenshot
			 */
			public static String getScreenshot(String methodName) 
			{
				File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
				
				String path = System.getProperty("user.dir") + "/screenshot/" + methodName +".png";
				File destination = new File(path);
				
				try
				{
					FileUtils.copyFile(srcFile, destination);
				} 
				catch (IOException e) 
				{		
					e.printStackTrace();
				}
				
				return path;
			}
	
	
	

}
