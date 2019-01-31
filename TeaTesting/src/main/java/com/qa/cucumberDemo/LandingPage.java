package com.qa.cucumberDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	@FindBy(xpath = Constants.MENUPAGE)
	private WebElement menuButton;
	
	public void goToMenuPage() {
		menuButton.click();
	}

}
