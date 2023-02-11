package com.selenium.class01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UsingMultipleKeys {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.ebay.com");

		driver.manage().window().maximize();

		WebElement signInLink = driver.findElement(By.xpath("//span[@id='gh-ug']/a"));

		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(signInLink).keyUp(Keys.CONTROL).build().perform();

	}
}
