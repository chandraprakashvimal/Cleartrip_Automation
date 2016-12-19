package com.gojek.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;

	public Home(WebDriver wd) {
		// TODO Auto-generated constructor stub
		this.driver = wd;
		PageFactory.initElements(driver, this);
	}

}
