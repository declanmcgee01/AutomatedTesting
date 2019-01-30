import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShafeeqHatesUsLandingPage {
	
	@FindBy(id = "search-box-q")
	private WebElement searchBox;

	public void searchGods(String searchText) {
		searchBox.sendKeys(searchText);
	}

}

