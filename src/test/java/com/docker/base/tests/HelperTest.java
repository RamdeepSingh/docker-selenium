package com.docker.base.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class HelperTest {

	protected WebDriver driver;

	@BeforeTest
	public void setupDriver() throws MalformedURLException {

		String host = "localhost";
		DesiredCapabilities dc;

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
		} else {
			dc = DesiredCapabilities.chrome();
		}

		if (System.getProperty("HUB_HOST") != null && System.getProperty("HUB_HOST") != "localhost") {
			host = System.getProperty("HUB_HOST");
		}

		String completeAddress = "http://" + host + ":4444/wd/hub";
		this.driver = new RemoteWebDriver(new URL(completeAddress), dc);
	}

	@AfterTest
	public void quitBrowser() {
		this.driver.quit();
	}

}
