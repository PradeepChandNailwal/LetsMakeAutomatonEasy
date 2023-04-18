package com.org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LMAE_FrameHandlingAutomation {

	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Open Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Chrome111\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);	
		driver.manage().window().maximize();

		// Set Application URL
		driver.get("file:///C:/Users/thaku/Desktop/WebSite/LMAE_FrameHandling.html");
		
		// Switch to First frame
		driver.switchTo().frame("pradeepYouTubeFirstFrame");
		
		// Click on first video Play button
		WebElement firstVideoPlayButton = driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[4]/button"));
		firstVideoPlayButton.click();
		Thread.sleep(2000);
		
		// Back to Parent Window or you can say come out of the first frame
		driver.switchTo().defaultContent();
		
		// Now Switch to Second frame
		driver.switchTo().frame("pradeepYouTubeSecondFrame");
		
		// Click on second video Play button
		WebElement secondVideoPlayButton = driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[4]/button"));
		secondVideoPlayButton.click();
		Thread.sleep(2000);
		
		

	}

}
