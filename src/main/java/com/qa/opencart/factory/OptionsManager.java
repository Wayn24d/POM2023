package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager  {
	
	
					private Properties 		prop;
					private ChromeOptions 	cop;
					private FirefoxOptions 	fop;
					private EdgeOptions 	eop;
					
					// 1. Constructor : 
					
					public OptionsManager(Properties prop) 
					{
						this.prop = prop;
					}
	
	
	
					public ChromeOptions getChromeOptions() 
					{
						cop = new ChromeOptions();
						if(Boolean.parseBoolean(prop.getProperty("headless"))) 
						{
							cop.setHeadless(true);
						}
						if(Boolean.parseBoolean(prop.getProperty("incognito"))) 
						{
							cop.addArguments("--incognito");
						}
						return cop;
					}
	
	
					
					
					public FirefoxOptions getFirefoxOptions() 
					{
						fop = new FirefoxOptions();
						if(Boolean.parseBoolean(prop.getProperty("headless"))) fop.setHeadless(true);
						
						if(Boolean.parseBoolean(prop.getProperty("incognito"))) fop.addArguments("--incognito");
						
						return fop;
					}
	
	
	
	
					public EdgeOptions getEdgeOptions() 
					{
						eop = new EdgeOptions();
						if(Boolean.parseBoolean(prop.getProperty("headless"))) 
						{
							eop.setHeadless(true);
						}
						if(Boolean.parseBoolean(prop.getProperty("incognito"))) 
						{
							eop.addArguments("--incognito");
						}
						return eop;
					}
	
	

}
