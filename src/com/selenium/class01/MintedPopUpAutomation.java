package com.selenium.class01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MintedPopUpAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		
		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.minted.com/");

		driver.manage().window().maximize();

		WebElement emailInputBox = driver.findElement(By.xpath("//div[@class='bx-inputwrap']/input[@type='email']"));

		emailInputBox.sendKeys("HelloWorld@java.com");
	}

}
