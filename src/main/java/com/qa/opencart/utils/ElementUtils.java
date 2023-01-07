package com.qa.opencart.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	
	 private WebDriver driver;
	
	
	
	 		public ElementUtils(WebDriver driver) 
	 		{
	 			this.driver = driver;
	 		}
	 		
	
			public WebElement getElement(By locator) 
			{
				return driver.findElement(locator);
			}
			
			
			public List<WebElement> wait_forElements(By locator , int Timeout) 
			{

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
				List<WebElement> element =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)); 
				return element;
			}
			
			
			
			/**
			 * An expectation for checking that an element is present on the DOM of a page and visible.
			 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0
			 * @param locator
			 * @param Timeout
			 * @return
			 */
			public WebElement waitForVisibleElement(By locator , int Timeout) 
			{
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
				WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 
				return element;
			}
	
			
			
			
			public String waitForUrlTobe( String URLValue , int timeout) 
			{
				
				WebDriverWait w = new WebDriverWait(driver , Duration.ofSeconds(timeout));
				if(w.until(ExpectedConditions.urlToBe(URLValue))) 
					
					// When until() method is used with urlToBe() ,
				    // it  well return a boolean & CAN BE USED WITH IF STATEMENT.
					
				{
					
					return driver.getCurrentUrl();
					
					
				}
				else 
				{
					System.out.println("  URL not found !");
					return null;
				}
				
			}
			
			
			
			
			public String waitForTitleTobe( String TitleValue , int timeout) 
			{
				
				WebDriverWait w = new WebDriverWait(driver , Duration.ofSeconds(timeout));
				if(w.until(ExpectedConditions.titleIs(TitleValue))) 
					
					// When until() method is used with titleContains() ,
				    // it  well return a boolean & CAN BE USED WITH IF STATEMENT.
					
				{
					
					return driver.getTitle();
					
					
				}
				else 
				{
					System.out.println("  Title not found !");
					return null;
				}
				
			}
			
			
			
			
			
			
			

			public void waitAndClick( By btn , int timeout) 
			{
				
				WebDriverWait w = new WebDriverWait(driver , Duration.ofSeconds(timeout));
				w.until(ExpectedConditions.elementToBeClickable(btn));
					
				
				
			}
	
	
	
	
			
			
			public void SendKeysWith_Wait(By locator , int Timeout , String value) 
			{
				 waitFor(locator , Timeout).sendKeys(value);
			}
	
	
	
			
			
			/**
			 * An expectation for checking that an element is present on the DOM of a page.
			 * This does not necessarily mean that the element is visible.
			 * @param locator
			 * @param Timeout
			 * @return
			 */
			public WebElement waitFor(By locator , int Timeout) 
			{
				getElement(locator).clear();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
				WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
				return element;
			}
	
			
			
			public WebElement WaitFor(By locator , int Timeout) 
			{
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
				WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
				return element;
			}
			
			
			
			public void click(By locator) 
			{
				driver.findElement(locator).click();
			}
	
			
			
			public void SendKeys(By locater, String value) {
				
				getElement(locater).clear();
				getElement(locater).sendKeys(value);
				
				
			}
	
	

}
