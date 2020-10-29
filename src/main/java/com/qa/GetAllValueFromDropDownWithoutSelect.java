package com.qa.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Program to select drop down values without using Select class
 * @author Vinaya.KA
 *
 */
public class GetAllValueFromDropDownWithoutSelect {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/r.php");

		driver.manage().window().maximize();

		// 1.get all values/options
		// 2.select a value

//		List<WebElement> dayOptions = driver.findElements(By.xpath("//select[@id='day']/option"));
//		int size = dayOptions.size();
//		System.out.println("Size=" + size);
//		for (int i = 0; i < size; i++) {
//			String value = dayOptions.get(i).getText();
//			System.out.println(value);
//			if (value.equals("15")) {
//				dayOptions.get(i).click();
//				break;
//			}
//		}
		
		getAllValuesWithoutSelect(driver,"day","20");
		getAllValuesWithoutSelect(driver,"month","Oct");
		getAllValuesWithoutSelect(driver,"year","1994");

	}
	
	
	/**
	 * This method is used to select drop down value by passing values and without using Select class
	 * @param driver
	 * @param idValue
	 * @param value
	 */
	public static void getAllValuesWithoutSelect(WebDriver driver,String idValue,String value) {

		List<WebElement> OptionsList = driver.findElements(By.xpath("//select[@id='"+ idValue +"']/option"));
		int size = OptionsList.size();
		//System.out.println("Size=" + size);
		for (int i = 0; i < size; i++) {
			String optionsValue = OptionsList.get(i).getText();
			//System.out.println(optionsValue);
			if (optionsValue.equals(value)) {
				OptionsList.get(i).click();
				System.out.println(optionsValue);
				break;
			}
		}

	}

}
