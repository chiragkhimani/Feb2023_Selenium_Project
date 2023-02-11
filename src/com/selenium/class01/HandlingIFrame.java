package com.selenium.class01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingIFrame {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("https://the-internet.herokuapp.com/iframe");

		driver.manage().window().maximize();

		// Going inside the frame
		WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(iframe);

		WebElement textArea = driver.findElement(By.id("tinymce"));
		textArea.clear();
		textArea.sendKeys("Hello World");

		// Going out of the iframe
		driver.switchTo().defaultContent();

		WebElement heading = driver.findElement(By.xpath("//div[@class='example']/h3"));
		System.out.println(heading.getText());

	}
}
