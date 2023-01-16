package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver=driver;
	}
	
	WebElement amount;


	public WebElement getamount() {
		return amount;
	}
	public void setamount() {
		amount = driver.findElement(By.xpath("//th[@id='amount']"));
	}
}
