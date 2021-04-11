package com.selenium.test.actualText_automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testScript extends DriverSetup{
	
	public static String URl = "https://www.selenium.dev/";
	public static String actualText = "Selenium is a suite of tools for automating web browsers.";
	public static WebElement element;
	
	//open chrome driver
	@BeforeTest
	public static void openDriver() throws InterruptedException {
		
		
		driver.get(URl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
	}
	
	//verifying the text
	@Test
	public static void test() throws InterruptedException{
		driver.findElement(By.xpath("//span[normalize-space()='About']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		Thread.sleep(1000);
		
		element = driver.findElement(By.xpath("//p[@class='body-large']"));
		String testingText = element.getText();
		System.out.println("Testing Text = " + testingText);
		
		if((testingText.equals(actualText))) {
			AssertJUnit.assertTrue(true);
			System.out.println("Matches with the requirement");
		}else {
			AssertJUnit.fail();
			System.out.println("Doesn't Match with the requirement");
		}
		
		driver.findElement(By.xpath("//img[@class='logo logo-large']")).click();
		
	}
	
	
}
