package com.selenium.class01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.ebay.com");

		driver.manage().window().maximize();
		
		WebElement electronicsLink = driver.findElement(By.xpath("//div[@id='mainContent']//li/a[text()='Electronics']"));
		
		WebElement appleLink = driver.findElement(By.xpath("//nav[@class='hl-cat-nav__sub-cat-col']//a[text()='Apple']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(electronicsLink).pause(2000).click(appleLink).build().perform();
		
		for(int i=1; i<=15; i++) {
			action.scrollByAmount(200, 200).build().perform();
		}
	}
}
