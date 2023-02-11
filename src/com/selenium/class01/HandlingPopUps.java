package com.selenium.class01;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingPopUps {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.manage().window().maximize();

		WebElement button3 = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		button3.click();
		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());
		alert.sendKeys("Hello World"); // Type into alert
		alert.accept(); // click on ok button

		WebElement button2 = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		button2.click();
		alert = driver.switchTo().alert();
		alert.dismiss(); // click on dismiss button
	}
}
