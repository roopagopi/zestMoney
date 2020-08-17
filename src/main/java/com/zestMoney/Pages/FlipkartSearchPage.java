package com.zestMoney.Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Tests.BaseClass;

public class FlipkartSearchPage extends BaseClass {
	@FindBy(xpath="//div[contains(text(),'Apple iPhone XR (White, 64 GB)')]")
	WebElement iPhoneXRFlipkart;

	@FindBy(xpath="//div[contains(text(),'Apple iPhone XR (White, 64 GB)')]//ancestor::div[@class='col col-7-12']//following-sibling::div[@class='col col-5-12 _2o7WAb']//div[@class='_1vC4OE _2rQ-NK']")
	WebElement flipkartIphonePrice;

	public String flipkartPrice;

	public FlipkartSearchPage() throws FileNotFoundException{
		PageFactory.initElements(driver, this);
	}

	public void verifyIphoneIsDisplayedInFlipkart() {
		iPhoneXRFlipkart.isDisplayed();
		System.out.println("Iphone is displayed");
	}

	public void getIphonePriceOnFlipkart() {
		flipkartIphonePrice.isDisplayed();
		System.out.println("Iphone price is displayed");
		flipkartPrice = flipkartIphonePrice.getText();
		System.out.println("iPhone price in flipkart is: "+flipkartPrice);
		if (flipkartPrice.contains("₹")) {
			flipkartPrice=flipkartPrice.replace("₹", "");
		}
		if(flipkartPrice.contains(",")) {
			flipkartPrice=flipkartPrice.replace(",", "");
		}
	}
}