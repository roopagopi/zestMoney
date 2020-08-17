package com.Amazon.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zestMoney.Pages.AmazonHomePage;
import com.zestMoney.Pages.AmazonSearchPage;
import com.zestMoney.Pages.FlipkartHomePage;
import com.zestMoney.Pages.FlipkartSearchPage;

public class LoginTests extends BaseClass {
	//public String amazonPrice;

	LoginTests lt;

	@BeforeTest
	public void beginTest() throws Exception
	{
		initialization();
		lt = new LoginTests();
	}

	@Test
	public void testSteps() throws Exception
	{
		try {
			driver.navigate().to("https://www.amazon.in");
			System.out.println("Successfully navigated to Amazon page");

			AmazonHomePage ahp = new AmazonHomePage();
			ahp.verifyAmazonLogo();
			ahp.clickOnAmazonSearchTextBox();
			ahp.clickOnAmazonSearchButton();

			AmazonSearchPage asp = new AmazonSearchPage();
			asp.verifyIphoneIsDisplayedInAmazon();
			asp.getIphonePriceOnAmazon();

			driver.navigate().to("https://www.flipkart.com");
			System.out.println("Successfully navigated to Amazon page");

			FlipkartHomePage fhp = new FlipkartHomePage();
			fhp.closeSigninPopUpAndVerifyFlipkartLogo();
			fhp.clickOnFlipkartSearchTextBox();
			fhp.clickOnFlipkartSearchButton();

			FlipkartSearchPage fsp = new FlipkartSearchPage();
			fsp.verifyIphoneIsDisplayedInFlipkart();
			fsp.getIphonePriceOnFlipkart();

			if (Integer.parseInt(asp.amazonPrice)>Integer.parseInt(fsp.flipkartPrice)) {
				System.out.println("Amazon Price: "+Integer.parseInt(asp.amazonPrice)+" Flipkart price is: "+Integer.parseInt(fsp.flipkartPrice)
				+"\n"+"iPhone Xr price is more in Amazon compared to flipkart. It is wise to buy from flipkart");
			}else if (Integer.parseInt(asp.amazonPrice)<Integer.parseInt(fsp.flipkartPrice)) {
				System.out.println("Amazon Price: "+Integer.parseInt(asp.amazonPrice)+" Flipkart price is: "+Integer.parseInt(fsp.flipkartPrice)
				+"\n"+"iPhone Xr price is less in Amazon compared to flipkart. It is wise to buy from Amazon");
			}else {
				System.out.println("Amazon and Flipkart are having same prices for Iphone XR so you can buy from any website");
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@AfterTest
	public void closedriver()
	{
		driver.close();
	}
}