package com.cts.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Implementing the Interface IBrowser
 * @author gurudath.v
 *
 */
public class DriverFactory implements IBrowser  {

	public  WebDriver driver = null;
	DesiredCapabilities caps = new DesiredCapabilities();

	public WebDriver getBrowser(String browser) {

		try {
			switch (browser){
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
				caps.setBrowserName("firefox");
				driver = new FirefoxDriver();
				break;

			case "chrome":
				System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
				caps.setBrowserName("chrome");
				driver = new ChromeDriver();
				break;

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
