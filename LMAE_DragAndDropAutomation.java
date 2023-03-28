package com.org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LMAE_DragAndDropAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Chrome111\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("file:///C:/Users/thaku/Desktop/WebSite/LMAE_DragAndDrop.html");
		
		driver.manage().window().maximize();
		
		WebElement LMAE_Logo = driver.findElement(By.xpath("//*[@id='drag1']"));		
		WebElement dropBox = driver.findElement(By.xpath("//div[@id='div6']"));
		
		Thread.sleep(2000);
		dragAndDrop(driver, LMAE_Logo, dropBox);		

	}
	
	public static void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement tarElement) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
		                    + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
		                    + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
		                    + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
		                    + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
		                    + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
		                    + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
		                    + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
		                    + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
		                    + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
		                    + "var dropEvent = createEvent('drop');\n"
		                    + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
		                    + "var dragEndEvent = createEvent('dragend');\n"
		                    + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
		                    + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
		                    + "simulateHTML5DragAndDrop(source,destination);", srcElement, tarElement);
	}

}
