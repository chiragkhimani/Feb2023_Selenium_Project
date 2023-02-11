package com.selenium.class01;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingMultipleWindow {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.ebay.com/");

		driver.manage().window().maximize();

		WebElement registerLink = driver.findElement(By.xpath("//span[@id='gh-ug-flex']/a"));

		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(registerLink).keyUp(Keys.CONTROL).build().perform();

		String originalWindow = driver.getWindowHandle(); // Retrieve current window ID

		Set<String> listOfWindows = driver.getWindowHandles(); // Retrieve list of all windows

		for (String window : listOfWindows) {
			if (!window.equals(originalWindow)) {
				driver.switchTo().window(window);
			}
		}

		System.out.println(driver.getTitle());

		driver.close();

		driver.switchTo().window(originalWindow);

	}
}
