package com.selenium.class01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecutorExample {
	static ChromeDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		driver = new ChromeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.ebay.com/");

		driver.manage().window().maximize();

		WebElement searchBox = driver.findElement(By.id("gh-ac"));
		highlightElement(searchBox);
		searchBox.sendKeys("iPhone");

		WebElement searchBtn = driver.findElement(By.id("gh-btn"));
		highlightElement(searchBtn);
//		searchBtn.click();

	}

	public static void highlightElement(WebElement element) {
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].style.border = '4px solid red';", element);
	}
}
