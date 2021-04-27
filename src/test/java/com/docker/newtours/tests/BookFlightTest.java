package com.docker.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.docker.base.tests.HelperTest;
import com.docker.newtours.pages.FindFlightPage;
import com.docker.newtours.pages.FlightConfirmationPage;
import com.docker.newtours.pages.FlightDetailsPage;
import com.docker.newtours.pages.RegistrationConfirmationPage;
import com.docker.newtours.pages.RegistrationPage;

public class BookFlightTest extends HelperTest {

	private String numberOfPassengers;
	private String expectedPrice;

	@BeforeTest
	@Parameters({ "numberOfPassengers", "expectedPrice" })
	public void setupParameters(String numberOfPassengers, String expectedPrice) {
		this.numberOfPassengers = numberOfPassengers;
		this.expectedPrice = expectedPrice;
	}

	@Test
	public void registrationPage() {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTo();
		registrationPage.enterUserDetails("selenium", "docker");
		registrationPage.enterUserCredentials("selenium", "docker");
		registrationPage.submit();
	}

	@Test(dependsOnMethods = "registrationPage")
	public void registrationConfirmationPage() {
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.goToFlightReservationPage();
	}

	@Test(dependsOnMethods = "registrationConfirmationPage")
	public void flightDetailsPage() {
		FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
		flightDetailsPage.selectPassengers(numberOfPassengers);
		flightDetailsPage.submitFlightDetails();
	}

	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage() {
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.submitFindFlightPage();
		findFlightPage.submitFlightConfirmationPage();
		;
	}

	@Test(dependsOnMethods = "findFlightPage")
	public void flightConfirmationPage() {
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		String actualPrice = flightConfirmationPage.getPrice();
		Assert.assertEquals(actualPrice, expectedPrice);
	}

}
