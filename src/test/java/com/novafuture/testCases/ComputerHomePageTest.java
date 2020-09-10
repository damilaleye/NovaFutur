package com.novafuture.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.novafuture.pageObjects.AddaComputerPage;
import com.novafuture.pageObjects.ComputerHomePage;
import com.novafuture.pageObjects.EditaComputerPage;

public class ComputerHomePageTest extends BaseClass {


	@BeforeMethod
	public void testsetup() {
		driver.get(baseURL);

	}

	@Test(priority = 1)
	public void addANewComputerTest() throws InterruptedException {

		ComputerHomePage hp = new ComputerHomePage(driver);
		hp.clickOnAddNewComputer();
		AddaComputerPage ac = new AddaComputerPage(driver);
		ac.entercomputername("Ace Extensarr");
		ac.enterintroducedName("2000-01-01");
		ac.enterdiscontinuedName("2010-01-01");

		Select a = new Select(driver.findElement(By.xpath("//select[@id='company']")));
		a.selectByVisibleText("Apple Inc.");

		ac.clickoncreatethiscomputer();
		Thread.sleep(5000);

		String a1 = driver.findElement(By.xpath("//div[@class='alert-message warning']")).getText();

		Assert.assertEquals(a1, "Done ! Computer Ace Extensarr has been created");
	}

	@Test(priority = 2, dependsOnMethods = { "addANewComputerTest" })
	public void checkNewComputerisPresentTest() {
		ComputerHomePage hp = new ComputerHomePage(driver);
		hp.enterSearchText("Ace Extensarr");
		hp.clickSearch();

		if (hp.checkComputerNameIsPresent("Ace Extensarr") == true) {
			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
			System.out.println("Comp Entry not present");
		}



	}

	@Test(priority = 3, dependsOnMethods = { "checkNewComputerisPresentTest" })
	public void editNewComputerEntry() {
		ComputerHomePage hp = new ComputerHomePage(driver);
		hp.enterSearchText("Ace Extensarr");
		hp.clickSearch();
		List<WebElement> x = driver.findElements(By.xpath("//tr//td[1]"));
		for (int i = 0; i <= x.size(); i++) {

			String text = driver.findElements(By.xpath("//tr//td[1]")).get(i).getText();
			if (text.equalsIgnoreCase("Ace Extensarr")) {
				driver.findElements(By.xpath("//tr//td[1]")).get(i).click();
			}
		}

		EditaComputerPage ep = new EditaComputerPage(driver);

		Select s = new Select(driver.findElement(By.xpath("//select[@id='company']")));
		s.selectByVisibleText("Samsung Electronics");
		ep.clickOnSaveThisComputerButton();
		ComputerHomePage hp1 = new ComputerHomePage(driver);
		hp1.enterSearchText("Ace Extensarr");
		hp1.clickSearch();
		List<WebElement> y = driver.findElements(By.xpath("//tr//td[1]"));
		String companyname = driver.findElement(By.xpath("//tr//td[1]//following-sibling::td[3]")).getText();
		for (int i = 0; i <= x.size(); i++) {

			String text = y.get(i).getText();

			if ((text.equalsIgnoreCase("Ace Extensarr")) && companyname.equalsIgnoreCase("Samsung Electronics")) {
				Assert.assertTrue(true);
			}
		}

	}

	@Test(priority = 4, dependsOnMethods = { "editNewComputerEntry" })
	public void deleteNewComputerEntry() {
		ComputerHomePage hp = new ComputerHomePage(driver);
		hp.enterSearchText("Ace Extensarr");
		hp.clickSearch();
		List<WebElement> x = driver.findElements(By.xpath("//tr//td[1]"));
		for (int i = 0; i <= x.size(); i++) {

			String text = driver.findElements(By.xpath("//tr//td[1]")).get(i).getText();
			if (text.equalsIgnoreCase("Ace Extensarr")) {
				driver.findElements(By.xpath("//tr//td[1]")).get(i).click();
			}
		}
		EditaComputerPage ep = new EditaComputerPage(driver);
		ep.clickonThedeletebutton();
		String a1 = driver.findElement(By.xpath("//div[@class='alert-message warning']")).getText();

		Assert.assertEquals(a1, "Done ! Computer Ace Extensarr has been deleted");

	}

}
