package com.selenium.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/upload");

		Thread.sleep(3000);

		driver.manage().window().maximize();

		WebElement fileUploadPopUp = driver.findElement(By.id("file-upload"));
		fileUploadPopUp
				.sendKeys("C:\\Users\\khima\\eclipse-workspace\\SeleniumExample\\src\\com\\selenium\\files\\123.png");

		WebElement fileSubmit = driver.findElement(By.id("file-submit"));
		fileSubmit.click();
	}
}
