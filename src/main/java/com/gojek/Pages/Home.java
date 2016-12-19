package com.gojek.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;

	public Home(WebDriver wd) {
		// TODO Auto-generated constructor stub
		this.driver = wd;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='SearchBtn']")
	public WebElement searchFlightBtn;

	@FindBy(xpath = "//*[@id='Home']/div/aside[1]/nav/ul[1]/li[1]")
	public WebElement flightsTab;

	@FindBy(xpath = "//*[@id='RoundTrip']")
	public WebElement roundTripBtn;

	@FindBy(xpath = "//*[@id='FromTag']")
	public WebElement sourceTextBox;

	@FindBy(xpath = "//*[@id='ToTag']")
	public WebElement destTextBox;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']")
	public WebElement datepicker;

	@FindBy(xpath = "//*[@id='ResultContainer_1_1']//*[@class='booking fRight']")
	public WebElement bookFlightBtn;
	
	public Boolean selectSource(String source) {
		sourceTextBox.clear();
		sourceTextBox.sendKeys(source);
		sourceTextBox.sendKeys(Keys.TAB);

		if (sourceTextBox.getText().equals(source))
			return true;
		else
			return false;
	}

	public Boolean selectDetination(String destination) {
		destTextBox.clear();
		destTextBox.sendKeys(destination);
		destTextBox.sendKeys(Keys.TAB);
		if (destTextBox.getText().equals(destination))
			return true;
		else
			return false;
	}

}
