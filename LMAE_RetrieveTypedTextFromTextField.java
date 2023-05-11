package com.org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LMAE_RetrieveTypedTextFromTextField {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();		
		driver.get("file:///C:/Users/thaku/Desktop/WebSite/LMAE_RetrieveTypedTextFromTextField.html");
		
		driver.manage().window().maximize();
		
		WebElement channelNameTextField = driver.findElement(By.xpath("//input[@id='schoolName']"));
		
		String channelName = channelNameTextField.getAttribute("value");
		
		System.out.println(channelName);
		

	}

}
