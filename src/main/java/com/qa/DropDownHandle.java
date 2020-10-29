package com.qa.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Program to handle drop down using Select Class
 * 
 * @author Vinaya.KA
 *
 */
public class DropDownHandle {
	static Select select;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/r.php");

		driver.manage().window().maximize();

		WebElement dayEle = driver.findElement(By.id("day"));
		WebElement monthEle = driver.findElement(By.id("month"));
		WebElement yearEle = driver.findElement(By.id("year"));

//		Select select1 = new Select(dayEle);
//		select1.selectByVisibleText("10");
//		selectValueFromDropdown(dayEle,"10");
//		selectValueFromDropdown(dayEle,19);

//		Select select2 = new Select(monthEle);
//		select2.selectByVisibleText("Nov");
//		selectValueFromDropdown(monthEle,"Nov");
//		selectValueFromDropdown(monthEle,7);

//		Select select3 = new Select(yearEle);
//		select3.selectByVisibleText("1990");
//		selectValueFromDropdown(yearEle,"1990");
//		selectValueFromDropdown(yearEle,10);

//		getAllDropdownValues(dayEle);
//		getAllDropdownValues(monthEle);
//		getAllDropdownValues(yearEle);
//		
		selectDropdownValueByPassingValue(dayEle, "20");
		selectDropdownValueByPassingValue(monthEle, "Oct");
		selectDropdownValueByPassingValue(yearEle, "1994");

	}

	/**
	 * This generic method is used to select the value from drop down on the basis
	 * of text
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectValueFromDropdown(WebElement element, String value) {
		select = new Select(element);
		select.selectByVisibleText(value);
	}

	/**
	 * This generic method is used to select the value from drop down on the basis
	 * of index - METHOD OVERLOADING
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectValueFromDropdown(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to list all the values of drop down
	 * 
	 * @param element
	 */
	public static void getAllDropdownValues(WebElement element) {
		System.out.println("---------getting value from dropdown---------");
		select = new Select(element);
		List<WebElement> dropList = select.getOptions();
		int size = dropList.size();
		System.out.println("Size=" + size);
		for (int i = 0; i < size; i++) {
			String dropValue = dropList.get(i).getText();
			System.out.println(dropValue);
		}
	}

	/**
	 * This method is used to select value from drop down by passing value
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectDropdownValueByPassingValue(WebElement element, String value) {
		select = new Select(element);
		List<WebElement> list = select.getOptions();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String listValue = list.get(i).getText();
			// System.out.println(listValue);
			if (listValue.equals(value)) {
				list.get(i).click();
				WebElement firstoptionEle = select.getFirstSelectedOption();
				// System.out.println(firstoptionEle.getText());

				System.out.println(list.get(i).getText());
//				if(select.isMultiple()) {
//					select.deselectByValue(value);
//				}
				break;
			}
		}
	}
}
