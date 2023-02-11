package com.selenium.class01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

		driver.manage().window().maximize();

		// Switching to iFrame, because our images was inside iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(iframe);

		List<WebElement> images = driver.findElements(By.xpath("//ul[@id='gallery']//img"));

		WebElement trashArea = driver.findElement(By.id("trash"));

		Actions action = new Actions(driver);

		for (WebElement img : images) {
			action.dragAndDrop(img, trashArea).pause(1000).build().perform();
		}
		
		driver.switchTo().defaultContent();

	}
}
