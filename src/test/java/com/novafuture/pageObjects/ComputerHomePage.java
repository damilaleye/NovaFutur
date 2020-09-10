package com.novafuture.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ComputerHomePage {

	WebDriver driver;

	public ComputerHomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='searchbox']")
	WebElement filtersearchBox;

	@FindBy(xpath = "//input[@id='searchsubmit']")
	WebElement filterByNameButton;

	@FindBy(xpath = "//a[@id='add']")
	WebElement addComputerButton;

	@FindBys(@FindBy(xpath = "//tr//td[1]"))
	List<WebElement> checkComputerName;

	public void enterSearchText(String searchText) {
		filtersearchBox.sendKeys(searchText);

	}

	public void clickSearch() {
		filterByNameButton.click();
	}

	public String getSearchBoxText() {
		return filtersearchBox.getText();
	}

	public void clickOnAddNewComputer() {

		addComputerButton.click();
	}

	public boolean checkComputerNameIsPresent(String ComputerName) {

		for (int i = 0; i <= checkComputerName.size(); i++) {

			String a = checkComputerName.get(i).getText();

			if (a.equals(ComputerName)) {

				return true;
			}

		}

				return false;
	
}



}
