package com.gojek.Pages;

import java.util.List;

import org.openqa.selenium.By;
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
	
	public Boolean setDate(String date, String month, String year) throws Exception {
		try {
			WebElement monthText1 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]"));
			WebElement monthText2 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[1]"));
			WebElement yearText1 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[2]"));
			WebElement yearText2 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]"));
			WebElement dateTable;
			while (true) {
				if (monthText1.getText().toLowerCase().equals(month.toLowerCase())) {
					dateTable = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table"));
					break;
				} else if (monthText2.getText().toLowerCase().equals(month.toLowerCase())) {
					dateTable = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table"));
					break;
				} else
					driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
				monthText1 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]"));
				monthText2 = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[1]"));
			}

			// *[@id="ui-datepicker-div"]/div[2]/div/div/span[1]

			// WebElement dateTable =
			// driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table"));
			// *[@id="ui-datepicker-div"]/div[1]
			// //*[@id="ui-datepicker-div"]/div[2]
			List<WebElement> rows = dateTable.findElements(By.tagName("tr"));
			List<WebElement> columns = dateTable.findElements(By.tagName("td"));
			for (WebElement cell : columns) {
				System.out.println(cell.getText());
				if (cell.getText().equals(date)) {
					cell.findElement(By.linkText(date)).click();
					break;
				}

			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
