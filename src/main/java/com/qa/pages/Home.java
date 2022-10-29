package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class Home extends TestBase {
	
	//this class has been used to store all the webelements of the home page.

	//Release date:
	@FindBy(xpath = "//table[@class='infobox vevent']//tr//th//div[text()='Release date']")
	WebElement MovieReleaseDate;
	
	
    //country:
	@FindBy(xpath = "//table[@class='infobox vevent']//tr//th[text()='Country']")
	WebElement MovieCountry;

	
	public Home() {
		PageFactory.initElements(driver, this);

	}

	//for release date
	public String getinfoasdate() {
		String releasedate = MovieReleaseDate.getText();
		System.out.println(releasedate);
		return releasedate;

	}

	//for country
	public String getinfoascountry() {
		String countryname = MovieCountry.getText();
		System.out.println(countryname);
		return countryname;

	}

}
