package com.selenium.class01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample {

	static ChromeDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");

		// Create object of chrome driver
		driver = new ChromeDriver();

		driver.get("https://www.ebay.com/sch/ebayadvsearch");

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.manage().window().maximize();
		
		printAllDropdownOption("LH_SORT_BY");

	}

	public static void selectByAllOption(String id) {
		WebElement categoryDropdown = driver.findElement(By.id(id));
		Select catDropdownSelect = new Select(categoryDropdown);
		catDropdownSelect.selectByIndex(2);
		catDropdownSelect.selectByVisibleText("Collectibles");
		catDropdownSelect.selectByValue("267");
	}

	public static void printAllDropdownOption(String id) {
		
		WebElement categoryDropdown = driver.findElement(By.id(id));
		
		Select catDropdownSelect = new Select(categoryDropdown);

		List<WebElement> listOfOption = catDropdownSelect.getOptions();

		for (WebElement element : listOfOption) {
			System.out.println(element.getText());
		}
	}
}
