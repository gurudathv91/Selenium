package com.cts.driverfactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.cts.driverfactory.DriverFactory;

public class DriverUtils {

	public static WebDriver driver = null;
	String browser = null;
	String url = null;

	@BeforeTest
	@Parameters({"browser" , "url"})
	public void setUp(String browser, String url) {
		this.browser = browser;
		this.url = url;
		
		DriverFactory factory = new DriverFactory();

		if(browser.trim().equalsIgnoreCase("firefox"))
			driver=factory.getBrowser("firefox");
		

		else {
			driver=factory.getBrowser("chrome");
			driver.manage().window().maximize();
		}
		
		
		driver.get(url);

	}


	@AfterMethod 
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		//if (testResult.getStatus() == ITestResult.FAILURE) { 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File("Screenshots\\" + testResult.getName() + "-" +timeStamp +  ".jpg"));
	//	} 
	}

	
	@AfterTest
	public void afterTest() {
		driver.quit();
		driver = null;
	}
	
	@AfterSuite
	public void tearDown() {
		
		
	}

}
