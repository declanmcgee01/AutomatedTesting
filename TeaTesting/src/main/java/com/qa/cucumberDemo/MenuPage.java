package com.qa.cucumberDemo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class MenuPage {
	
	@FindBys(@FindBy(className = "wsb-element-text"))
	List<WebElement> items;
	
	public boolean isListPresent() {
		if(items.size() > 1) {
			return true;
		}
		return false;
	}
}
