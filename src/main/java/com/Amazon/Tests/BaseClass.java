package com.Amazon.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void initialization() throws Exception{
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\Roopa\\Automation\\webdrivers\\chromedriver.exe");
			driver= new ChromeDriver();
			System.out.println("Successfully launched browser");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}catch(Exception e)
		{
			throw new Exception("Failed to launch the browser, please check driver locations and running chrome version");
		}
	}

}