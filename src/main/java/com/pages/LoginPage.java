package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver=driver;
	}


	WebElement userName;
	WebElement password;
	WebElement checkBox;
	WebElement submitButton;


	public WebElement getUserName() {
		return userName;
	}
	public void setUserName() {
		userName = driver.findElement(By.xpath("//input[@id='username']"));
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword() {
		password =driver.findElement(By.xpath("//input[@id='password']"));
	}
	public WebElement getCheckBox() {
		return checkBox;
	}
	public void setCheckBox() {
		checkBox = driver.findElement(By.xpath("//input[@class='form-check-input']"));
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	public void setSubmitButton() {
		submitButton =driver.findElement(By.xpath("//button[@id='log-in']"));
	}

	
	public void loginTest(String user ,String pass) {
		
		setUserName();
		getUserName().sendKeys(user);

		setPassword();
		getPassword().sendKeys(pass);
		
		setSubmitButton();
		getSubmitButton().click();
	}
	
	
	
	

}
