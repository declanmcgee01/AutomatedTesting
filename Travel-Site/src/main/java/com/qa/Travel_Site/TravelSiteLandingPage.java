package com.qa.Travel_Site;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelSiteLandingPage {
	
	@FindBy(xpath = "/html/body/div[17]/div/input")
	WebElement locationSearch;
	@FindBy(xpath = "/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[2]/div/input")
	WebElement checkInDate;
	@FindBy(xpath = "/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[3]/div/input")
	WebElement checkOutDate;
	@FindBy(xpath = "//*[@id=\"travellersInput\"]")
	WebElement amountOfTravellers;
	

}
