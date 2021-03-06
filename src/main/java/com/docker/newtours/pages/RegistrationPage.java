package com.docker.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "firstName")
	private WebElement firstNameTextBox;
	@FindBy(name = "lastName")
	private WebElement lastNameTextBox;
	@FindBy(name = "email")
	private WebElement userNameTextBox;
	@FindBy(name = "password")
	private WebElement passwordTextBox;
	@FindBy(name = "confirmPassword")
	private WebElement confirmPasswordTextBox;
	@FindBy(name = "submit")
	private WebElement submitButton;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		this.driver.get("http://demo.guru99.com/test/newtours/register.php");
		this.wait.until(ExpectedConditions.visibilityOf(this.userNameTextBox));
	}

	public void enterUserDetails(String firstName, String lastName) {
		this.firstNameTextBox.sendKeys(firstName);
		this.lastNameTextBox.sendKeys(lastName);
	}

	public void enterUserCredentials(String userName, String password) {
		this.userNameTextBox.sendKeys(userName);
		this.passwordTextBox.sendKeys(password);
		this.confirmPasswordTextBox.sendKeys(password);
	}

	public void submit() {
		this.submitButton.click();
	}

}
