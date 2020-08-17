package com.zestMoney.Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Tests.BaseClass;

public class AmazonSearchPage extends BaseClass {

	@FindBy(xpath = "//a//span[contains(text(),'Apple iPhone XR (64GB) - White')]")
	WebElement iPhoneXR;
	
	@FindBy(xpath="//span[contains(text(),'Apple iPhone XR (64GB) - White')]//ancestor::div[@class='s-include-content-margin s-border-bottom s-latency-cf-section']//span[@class='a-price-whole']")
	WebElement iPhonePrice;
	
	public String amazonPrice;
	
	public AmazonSearchPage() throws FileNotFoundException{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyIphoneIsDisplayedInAmazon() {
		iPhoneXR.isDisplayed();
		System.out.println("Iphone is displayed");
		
	}
	
	public void getIphonePriceOnAmazon() {
		iPhonePrice.isDisplayed();
		System.out.println("Iphone price is displayed");
		amazonPrice = iPhonePrice.getText();
		System.out.println("iPhone price in amazon is: "+amazonPrice);
		amazonPrice=amazonPrice.replace(",", "");
	}
}
