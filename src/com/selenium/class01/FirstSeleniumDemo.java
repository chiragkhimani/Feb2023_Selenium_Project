package com.selenium.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumDemo {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.ebay.com/");

		Thread.sleep(3000);

		driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement searchBox = driver.findElement(By.id("gh-ac"));
		searchBox.sendKeys("iPhone");

		WebElement searchBtn = driver.findElement(By.id("gh-btn"));
		searchBtn.click();

		driver.close();
	}
}
