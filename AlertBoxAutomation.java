package com.org.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertBoxAutomation {

	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Open Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Chrome111\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);	
		driver.manage().window().maximize();

		// Set Application URL
		driver.get("file:///C:/Users/thaku/Desktop/WebSite/AlertBoxes.html");
		
		// Simple Alert Automation
		WebElement simpleAlertButton = driver.findElement(By.xpath("//button[text()='Simple Alert']"));
		simpleAlertButton.click();
		Thread.sleep(2000);
		Alert simpleAlertBox = driver.switchTo().alert();
		simpleAlertBox.accept();
		
		// Prompt Alert Automation
		WebElement promptAlertButton = driver.findElement(By.xpath("//button[text()='Prompt Alert']"));
		promptAlertButton.click();	
		Thread.sleep(2000);
		Alert promptAlertBox = driver.switchTo().alert();
		promptAlertBox.sendKeys("Lets Make Automation Easy");
		promptAlertBox.accept();
		
		// Confirmation Alert Automation
		WebElement confirmAlertButton = driver.findElement(By.xpath("//button[text()='Confirmation Alert']"));
		confirmAlertButton.click();
		Thread.sleep(2000);
		Alert confirmAlertBox = driver.switchTo().alert();
		confirmAlertBox.dismiss();
		

	}

}
