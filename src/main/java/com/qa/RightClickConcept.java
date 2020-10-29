package com.qa.selenium;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Program to do right click using Action class********
 * Program to do click on the option present on right click button*********
 * Program to list out all the option which similar to listing values from drop down without select class******
 * Program to check the value present in list( or drop down) or not using boolean 'flag'
 * @author Vinaya.KA
 *
 */
public class RightClickConcept {
	static WebDriver driver;
	static Alert alert;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		driver.manage().window().maximize();

		WebElement rightClickEle = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

		Actions action = new Actions(driver);
		action.contextClick(rightClickEle).perform();

		WebElement copyEle = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-copy')]"));
		System.out.println(copyEle.getText());
		copyEle.click();

		Thread.sleep(3000);

		alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		Thread.sleep(3000);

		alert.accept();

		
		action.contextClick(rightClickEle).perform();
		
		//System.out.println("----------Listing values after right clicking---------------");

//		List<WebElement> allOptionList = driver
//				.findElements(By.xpath("//ul[contains(@class,'context-menu-list')]/li[not(position()=6)]/span"));

		// 2 CORRECT XPATH are available
		//1. //ul[contains(@class,'context-menu-list')]/li[contains(@class,'context-menu-item context-menu-icon')]/span
		//2. //ul[contains(@class,'context-menu-list')]/li[not(position()=6)]/span
		
		String xpath="//ul[contains(@class,'context-menu-list')]/li[not(position()=6)]/span";
		
		if(clickOnRightClickOption(xpath,"Quit")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
	}
	
	/**
	 * This method is used to click on the option after right clicking on button
	 * @param xpathValue
	 * @param clickValue
	 * @return 
	 */
	public static boolean clickOnRightClickOption(String xpathValue,String clickValue) {
		boolean flag=false;
		List<WebElement> OptionList = driver.findElements(By.xpath(xpathValue));
		int size = OptionList.size();
		for (int i = 0; i < size; i++) {
			String optionValue = OptionList.get(i).getText();
			System.out.println(optionValue);
			if(optionValue.equals(clickValue)) {
				OptionList.get(i).click();
				//System.out.println(optionValue);
				System.out.println(alert.getText());
				alert.accept();
				flag=true;
				break;
			}
		}
		return flag;
	}

}
