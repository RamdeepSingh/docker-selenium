package com.docker.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "passCount")
	private WebElement passengersCount;
	@FindBy(name = "findFlights")
	private WebElement submitFlightDetails;

	public FlightDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}

	public void selectPassengers(String numberOfPassengers) {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.passengersCount));
		Select select = new Select(this.passengersCount);
		select.selectByValue(numberOfPassengers);
	}

	public void submitFlightDetails() {
		this.submitFlightDetails.click();
	}
}
