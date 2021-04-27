package com.docker.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[@href='login.php']")
	private WebElement signInLink;
	@FindBy(xpath = "//a[@href='reservation.php']")
	private WebElement flightsReservationLink;

	public RegistrationConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}

	public void goToFlightReservationPage() {
		this.wait.until(ExpectedConditions.visibilityOf(this.signInLink));
		this.flightsReservationLink.click();
	}

}
