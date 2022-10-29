package com.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.Home;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestvagrantTest extends TestBase {

	Home home;

	public TestvagrantTest() {
		super();

	}

	// opening the browser
	@BeforeMethod
	public void setup() {

		TestBase.initialization();
		home = new Home();

	}

	// fetching releasing date and country and validating:
	@Test(priority = 1)
	public void ReleasedateandcountrytTest() {

		// for release date
		String date = home.getinfoasdate();
		Assert.assertEquals(date, "Release date");

		// for country
		String country = home.getinfoascountry();
		Assert.assertEquals(country, "Country");

	}

   //closing the browser
	@AfterMethod
	public void teardown() {

		driver.quit();
	}
}
