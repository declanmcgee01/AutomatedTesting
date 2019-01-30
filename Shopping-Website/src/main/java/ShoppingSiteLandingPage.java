import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingSiteLandingPage {
	
	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	private WebElement searchBar;
	
	public void searchEntry(String searchText) {
		searchBar.sendKeys(searchText);
	}

}
