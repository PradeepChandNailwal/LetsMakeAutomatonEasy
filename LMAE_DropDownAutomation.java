package com.org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LMAE_DropDownAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Chrome111\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("file:///C:/Users/thaku/Desktop/WebSite/LMAE_Dropdown.html");
		
		driver.manage().window().maximize();
		
		Thread.sleep(1000);	
		
		WebElement testingTypeField = driver.findElement(By.id("TestingType"));		
		Select testingTypeDropdown = new Select(testingTypeField);
		testingTypeDropdown.selectByVisibleText("Automation");
		
		System.out.println("Selected Testing Type is:");
		System.out.println(testingTypeDropdown.getFirstSelectedOption().getText());
		System.out.println();
		
		WebElement testingCoursesField = driver.findElement(By.id("TestingCourses"));	
		Select testingCourseseDropdown = new Select(testingCoursesField);
		testingCourseseDropdown.selectByVisibleText("Selenium");
		testingCourseseDropdown.selectByVisibleText("Rest Assured");
		
		System.out.println("Selected Testing Courses are below:");
		for(WebElement option : testingCourseseDropdown.getAllSelectedOptions()) {
			System.out.println(option.getText());
		}		

	}
	
}
