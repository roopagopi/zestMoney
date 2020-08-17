package com.zestMoney.Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Tests.BaseClass;

public class FlipkartHomePage extends BaseClass {
	
	@FindBy(xpath="//button[contains(text(),'✕')]")
	WebElement signinCloseButton;
	
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement flipkartLogo;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement flipkartSearchTextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement flipkartSearchButton;
	
	String flipkartIphoneName = "Apple iPhone XR (White, 64 GB)";
	
	public FlipkartHomePage() throws FileNotFoundException{
		PageFactory.initElements(driver, this);
	}
	
	public void closeSigninPopUpAndVerifyFlipkartLogo() {
		signinCloseButton.isDisplayed();
		System.out.println("Close Popup is displayed");
		signinCloseButton.click();
		System.out.println("Successfully clicked on close icon");
		String title = driver.getTitle();
		System.out.println("Page title is: "+title);
		flipkartLogo.isDisplayed();
		System.out.println("Flipkart logo is displayed");
	}
	
	public void clickOnFlipkartSearchTextBox() {
		flipkartSearchTextBox.isDisplayed();
		System.out.println("Flipkart search text box is displayed");
		flipkartSearchTextBox.click();
		System.out.println("Successfully clicked on search text box");
		flipkartSearchTextBox.sendKeys(flipkartIphoneName);
		System.out.println("Entered the phone name: "+flipkartIphoneName);
	}
	
	public void clickOnFlipkartSearchButton() {
		flipkartSearchButton.isDisplayed();
		System.out.println("Flipkart search button is displayed");
		flipkartSearchButton.click();
		System.out.println("Flipkart search button is clicked");
	}
}