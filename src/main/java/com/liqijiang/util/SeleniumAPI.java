package com.liqijiang.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.liqijiang.htmllog.HTMLLogEntry;



public class SeleniumAPI {
	
	public SeleniumAPI() {}
	public static WebDriver getDriver(String driverName,String driverPath) {
		if(driverName == null || driverPath == null || driverName.length() == 0 || driverPath.length() == 0) {
			return null;
		}
		WebDriver driver = null;
		if(driverName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);      
			driver = new ChromeDriver();
		}else if(driverName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", driverPath);      
			driver = new InternetExplorerDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", driverPath);      
			driver = new FirefoxDriver();
		}
		return driver;
	}
	public static By getElementLocation(String elementName) {
		if(elementName == null || !elementName.contains("=") || elementName.indexOf("=") == (elementName.length() - 1)) {
			return null;
		}
		String s = elementName.substring(elementName.indexOf("=") + 1, elementName.length());
		By b = null;
		if(elementName.toLowerCase().startsWith("xpath")) {
			b = By.xpath(s);
		}else if(elementName.toLowerCase().startsWith("css")) {
			b = By.cssSelector(s);
		}else if(elementName.toLowerCase().startsWith("id")) {
			b = By.id(s);
		}else if(elementName.toLowerCase().startsWith("name")) {
			b = By.name(s);
		}else if(elementName.toLowerCase().startsWith("classname")) {
			b = By.className(s);
		}else if(elementName.toLowerCase().startsWith("tag")) {
			b = By.tagName(s);
		}else if(elementName.toLowerCase().startsWith("linktext")) {
			b = By.linkText(s);
		}else if(elementName.toLowerCase().startsWith("partiallink")) {
			b = By.partialLinkText(s);
		}else {
			return null;
		}
		return b;
	}
	public static WebElement findElement(WebDriver driver,String elementName) {
		WebElement we = null;
		try {
			we = driver.findElement(getElementLocation(elementName));
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			HTMLLogEntry.write("元素未找到", 1, 2);
			e.printStackTrace();
		}
		return we;
	}
	public static void sendkeys(WebDriver driver,String elementName,String value) {
//		try {
//			driver.findElement(getElementLocation(elementName)).sendKeys(value);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		findElement(driver, elementName).sendKeys(value);
	}
	public static void click(WebDriver driver,String elementName) {
//		try {
//			driver.findElement(getElementLocation(elementName)).click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		findElement(driver, elementName).click();
	}
	public static void windowMax(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void get(WebDriver driver,String url) {
		driver.get(url);
	}
	public static void quit(WebDriver driver) {
		driver.quit();
	}
	public static String getText(WebDriver driver,String elementName) {
		return findElement(driver, elementName).getText();
	}
	
	
}
