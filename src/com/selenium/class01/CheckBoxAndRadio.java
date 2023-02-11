package com.selenium.class01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxAndRadio {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.ebay.co.uk/sch/ebayadvsearch");

		driver.manage().window().maximize();

		// We will use explicit wait here

		WebElement cookieAccept = driver.findElement(By.id("gdpr-banner-accept"));

		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		wait.until(ExpectedConditions.visibilityOf(cookieAccept));

		wait.until(ExpectedConditions.elementToBeClickable(cookieAccept));

		cookieAccept.click();

		WebElement cherityChkBx = driver.findElement(By.id("LH_Charity"));
		cherityChkBx.click();

		WebElement locatedInRadio = driver.findElement(By.id("LH_LocatedInRadio"));
		locatedInRadio.click();
	}
}
