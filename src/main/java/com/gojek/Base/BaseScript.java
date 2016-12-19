package com.gojek.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseScript {

	public static WebDriver driver;
	public static String url = "https://www.cleartrip.com/";

	@BeforeClass
	public static void init() throws Exception {
		try {
			System.setProperty("webdriver.chrome.driver", "/home/cp/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
}