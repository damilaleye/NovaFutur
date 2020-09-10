package com.novafuture.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditaComputerPage {

	WebDriver driver;

	public EditaComputerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='name']")
	WebElement computernametextBox;

	@FindBy(xpath = "//input[@id='introduced']")
	WebElement introducedtextBox;

	@FindBy(xpath = "//input[@id='discontinued']")
	WebElement discontinuedtextBox;

	@FindBy(xpath = "//input[@class='btn primary']")
	WebElement clickOnSaveThisComputerButton;

	@FindBy(xpath = "//input[@class='btn danger']")
	WebElement clickOnTheDeleteButton;

	public void entercomputername(String compName) {

		computernametextBox.sendKeys(compName);

	}

	public void enterintroducedName(String introducedName) {

		introducedtextBox.sendKeys(introducedName);

	}

	public void enterdiscontinuedName(String discontinuedName) {

		discontinuedtextBox.sendKeys(discontinuedName);

	}

	public void clickOnSaveThisComputerButton() {

		clickOnSaveThisComputerButton.click();
	}

	public void clickonThedeletebutton() {

		clickOnTheDeleteButton.click();
	}
}
