package com.zestMoney.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Tests.BaseClass;

public class AmazonHomePage extends BaseClass {

	@FindBy(xpath="//span[@class='nav-sprite nav-logo-base']")
	WebElement amazonLogo;
		
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextBox;
	
	@FindBy(xpath = "//input[@value='Go']")
	WebElement searchButton;
	
	String amazonIphoneName = "Apple iPhone XR (64GB) - White";

	public AmazonHomePage() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAmazonLogo() {
		String title = driver.getTitle();
		System.out.println("Page title is: "+title);
		amazonLogo.isDisplayed();
		System.out.println("Amazon Logo is displayed");
	}
	
	public void clickOnAmazonSearchTextBox() {
		searchTextBox.isDisplayed();
		System.out.println("Search text box is displayed");		
		searchTextBox.click();
		System.out.println("Clicked on search textbox");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		searchTextBox.sendKeys(amazonIphoneName);
		System.out.println("Entered the phone name: "+amazonIphoneName);
	}
	
	public void clickOnAmazonSearchButton() {
		searchButton.isDisplayed();
		System.out.println("Search button is displayed");
		searchButton.click();
		System.out.println("Clicked on search button");
	}
}