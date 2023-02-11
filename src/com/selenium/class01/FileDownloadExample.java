package com.selenium.class01;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownloadExample {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "C:\\Users\\khima\\eclipse-workspace\\SeleniumExample\\src\\com\\selenium\\files");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		
		// Create object of chrome driver
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://the-internet.herokuapp.com/download");

		WebElement element = driver.findElement(By.xpath("//a[text()='git.PNG']"));
		element.click();
	}
}
