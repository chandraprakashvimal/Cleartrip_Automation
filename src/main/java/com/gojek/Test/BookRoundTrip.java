package com.gojek.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
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

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
