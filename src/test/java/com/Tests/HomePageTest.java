package com.Tests;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.utility.UtilityMethods;

public class HomePageTest {
	static WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumLibrary\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(UtilityMethods.getProperty("url"));
	}

	@Test
	public void amount() throws InterruptedException {
		loginPage = new LoginPage(driver);

		loginPage.loginTest(UtilityMethods.getProperty("user"), UtilityMethods.getProperty("password"));

		homePage = new HomePage(driver);

		homePage.setamount();
		homePage.getamount().click();

		UtilityMethods.scroll(driver);

		List<WebElement> list = driver.findElements(By.xpath("//span[@class='text-danger' or @class='text-success']"));

	Assert.assertEquals(list.get(0).getText(),"- 320.00 USD");
	Assert.assertEquals(list.get(1).getText(),"- 244.00 USD");		
	Assert.assertEquals(list.get(2).getText(),"+ 17.99 USD");
	Assert.assertEquals(list.get(3).getText(),"+ 340.00 USD");
	Assert.assertEquals(list.get(4).getText(),"+ 952.23 USD");
	Assert.assertEquals(list.get(5).getText(),"+ 1,250.00 USD");
	}

	@AfterMethod
	public void tearDown() {

		 driver.close();

	}

}
