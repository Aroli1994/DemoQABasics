package com.qa.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPrograms {

	public static void main(String... args) {
		Properties prop = null;
		File file=new File("./Configuration/config.properties");
		
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		//System.setProperty("webdriver.chrome.driver", "E:\\ECLIPSE_CODES\\DemoQA\\Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/");
		
		driver.manage().window().maximize();
		
		
		
		
		System.out.println("*************COOKIES concept to create,add,get,delete****START**********");
		
		//To GET ALL cookies------in general*/
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Cookies that we get: "+ cookies);
				
		//To DELETE ALL cookies---in general*/
		driver.manage().deleteAllCookies();
		System.out.println("Cookies after deleting all: "+ cookies);
		
		/* 1. CREATE,ADD,GET,DELETE user defined cookies***********/
		//1.To create new cookie object for name='login' and value='facebook'
		Cookie loginCk=new Cookie("login","facebook");
		//1.To add the cookie named 'login'
		driver.manage().addCookie(loginCk);
		//1.To get the value of cookie named 'login'*/
		Cookie cookie1 = driver.manage().getCookieNamed("login");
		System.out.println(cookie1);
		//1.To delete the cookie named 'login'
		driver.manage().deleteCookie(cookie1);
		
		/*2. CREATE,ADD,GET,DELETE user defined cookies***********/
		String name = "tokencookiename";			
        String value ="tokencookievalue";					
           //String domain = "tokencookie";					
           //String path = "tokencookie";					
           //Date expiry = null;
           //boolean isSecure=true;
        //2.To create new cookie object for name='tokencookiename' and value='tokencookievalue'
        Cookie ck = new Cookie(name,value);
        //2.To add the cookie named 'tokencookiename'
        driver.manage().addCookie(ck);
        //2.To get the value of cookie named 'tokencookiename'
        Cookie cookie2 = driver.manage().getCookieNamed("tokencookiename");
        System.out.println(cookie2);
        //2.To delete the cookie named 'tokencookiename'
        driver.manage().deleteCookie(cookie2);
        
        System.out.println("*************COOKIES concept to create,add,get,delete****END**********");
		
		List<WebElement> list=driver.findElements(By.className("card mt-4 top-card"));
		//System.out.println(list.size());
		//for(int i=0;i<list.size();i++)
		
		
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div")).click();
		
		
	}

}
