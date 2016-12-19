package com.gojek.Test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gojek.Base.BaseScript;
import com.gojek.Pages.Home;

public class BookRoundTrip extends BaseScript {

	@Test
	public void RoundTrip() throws Exception {
		try {

			Home home = new Home(driver);

			WebDriverWait wait = new WebDriverWait(driver, 60);

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
