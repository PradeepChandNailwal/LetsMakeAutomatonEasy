package com.org.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LMAE_WindowHandling_Automation {

	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Create a variable to store expected title of Faq window
		String expTitle = "Frequently Asked Questions";

		// Open Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Chrome111\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Set Application URL
		driver.get("file:///C:/Users/thaku/Desktop/WebSite/LMAE_MainWindow.html");

		// Click on faq Link
		WebElement faqLink = driver.findElement(By.xpath("//a[text()='FAQ (Frquently Asked Qusetion)']"));
		faqLink.click();
		Thread.sleep(2000);

		// Get ids of allopened windows
		Set<String> allOpenedWindowIds = driver.getWindowHandles();

		// Now create a for each loop to access window ids one by one
		for (String currWindowId : allOpenedWindowIds) {
			// Switch to every window
			driver.switchTo().window(currWindowId);
			// get the title of current window
			String currentWindowTitle = driver.getTitle();
			// Compare cuurent window title with exp Faq window title
			if (currentWindowTitle.equals(expTitle)) {
				break;
			}
		}

		// Enter text in Faq Window Ques field 
		WebElement faqQuesField = driver.findElement(By.xpath("//input[@id='ques']"));
		faqQuesField.sendKeys("Can I learn Java Easily ?");
		Thread.sleep(2000);

	}

}
