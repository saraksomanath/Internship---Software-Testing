package com.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utility.UtilityMethods;

public class LoginPageTest {
	static WebDriver driver;

	LoginPage loginPage;

	@BeforeMethod
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumLibrary\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(UtilityMethods.getProperty("url"));

	}

	@Test
	public void loginTest() {

		loginPage = new LoginPage(driver);

		loginPage.loginTest(UtilityMethods.getProperty("user"), UtilityMethods.getProperty("password"));
		
		String homePageURL=driver.getCurrentUrl();
		
		
		Assert.assertEquals(homePageURL, "https://sakshingp.github.io/assignment/home.html");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
