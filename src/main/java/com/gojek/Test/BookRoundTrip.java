package com.gojek.Test;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gojek.Base.BaseScript;
import com.gojek.Pages.Home;

public class BookRoundTrip extends BaseScript {

	@Test
	public void RoundTrip() throws Exception {
		try {

			Home home = new Home(driver);

			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(home.searchFlightBtn));

			Assert.assertEquals(driver.getTitle(), "Cleartrip - Flights, Hotels, Local, Trains, Packages");

			// click on flights tab is not selected
			if (!home.flightsTab.isSelected())
				home.flightsTab.click();

			// click on round trip button if not selected
			if (!home.roundTripBtn.isSelected()) {
				home.roundTripBtn.click();
			}

			// Enter source and destination
			home.selectSource("New Delhi, IN - Indira Gandhi Airport (DEL)");
			home.selectDetination("Lucknow, IN - Amausi (LKO)");
			Thread.sleep(1000);

			// Select departure date
			home.setDate("18", "February", "2016");
			Thread.sleep(1000);
			// Select return date
			home.setDate("18", "March", "2016");
			Thread.sleep(1000);

			home.searchFlightBtn.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(home.bookFlightBtn));
			Assert.assertEquals(driver.getTitle(), "Cleartrip | New Delhi ⇄ Lucknow");
			
			home.bookFlightBtn.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(home.continueBookingBtn));
			Assert.assertEquals(driver.getTitle(), "Cleartrip | Book your flight securely in simple steps");

			if (!home.acceptTnC.isSelected()) {
				home.acceptTnC.click();
			}
			
			home.continueBookingBtn.click();

			wait.until(ExpectedConditions.elementToBeClickable(home.email));
			home.email.clear();
			home.email.sendKeys("cp@yahoo.com");
			Thread.sleep(1000);
			home.continueBtn1.click();

			wait.until(ExpectedConditions.elementToBeClickable(home.title));
			home.title.click();
			Select drop = new Select(home.title);
			drop.selectByVisibleText("Mr");
			home.fname.click();
			home.fname.sendKeys("cp");
			home.lname.click();
			home.lname.sendKeys("vimal");
			home.mobileN.click();
			home.mobileN.sendKeys("7795556899");
			home.continueBtn2.click();

			wait.until(ExpectedConditions.elementToBeClickable(home.makePayment));
			Actions act = new Actions(driver);
			act.moveToElement(home.debitCardTab);
			home.debitCardTab.click();
			home.debitCardNo.clear();
			home.debitCardNo.sendKeys("55201881001635781");
			Thread.sleep(500);
			home.expMonth.sendKeys("01");
			Thread.sleep(500);
			home.expYear.sendKeys("2019");
			home.cardHolderName.clear();
			home.cardHolderName.sendKeys("chandra prakash vimal");
			home.cvv.clear();
			home.cvv.sendKeys("123");
			home.currency.get(0).click();			
			home.makePayment.click();

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
