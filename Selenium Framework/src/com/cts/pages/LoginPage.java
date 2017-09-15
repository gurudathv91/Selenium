package com.cts.pages;


import org.openqa.selenium.By;

import com.cts.driverfactory.DriverUtils;
/**
 * Inheriting driver from the parent class (DriverUtils)
 * @author gurudath.v
 *
 */

public class LoginPage extends DriverUtils{
	
	private By firstName = By.id("name_3_firstname");
	private By lastName = By.id("name_3_lastname");
	private By submit = By.name("pie_submit");

  
  public void enterFirstName(String fName) {
	  driver.findElement(firstName).sendKeys(fName);
  }
  
  public void enterLastName(String lName) {
	  driver.findElement(lastName).sendKeys(lName);
  }
  
  public void clickSubmit() {
	  driver.findElement(submit).click();
	  
  }
}
