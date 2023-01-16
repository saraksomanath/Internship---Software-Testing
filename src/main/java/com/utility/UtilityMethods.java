package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityMethods {

	
	public static String getProperty(String key) {

		Properties p = new Properties();
		try {

			File file = new File(
					"C:\\Users\\Somnath\\eclipse-workspace\\com.qawingify\\src\\test\\resources\\Testdata.properties");

			FileInputStream fis = new FileInputStream(file);

			p.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
	
	public static void getScreenShot(WebDriver driver) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

		File imageFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(imageFile,
					new File("C:\\Users\\Somnath\\eclipse-workspace\\com.demoqa.books.project\\ScreenShot"
							+ System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void scroll(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	
}
