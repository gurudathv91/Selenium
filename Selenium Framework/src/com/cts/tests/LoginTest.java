package com.cts.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.cts.driverfactory.DriverUtils;
import com.cts.pages.LoginPage;
import com.cts.utils.Utils;

public class LoginTest extends DriverUtils {
	LoginPage loginPage;


	public LoginTest () {

		loginPage = new LoginPage();

	}

	final Logger log= Logger.getLogger(LoginTest.class);


	@Test
	/*
	 * Fill the user registration form
	 */
	public void userRegistration() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
		loginPage.enterFirstName(Utils.getExcelData("Sheet1", "username"));
		loginPage.enterLastName(Utils.getExcelData("Sheet1", "password"));
		log.info("Entered user name and password");
	}

	@Test
	/**
	 * Do a blank submission
	 */
	public void submitBlankForm () {
		// this.loginPage = new Login();
		loginPage.clickSubmit();
		log.info("Blank submission");
	}

}
