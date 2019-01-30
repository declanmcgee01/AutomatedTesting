import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingLandingPage {

	@FindBy(id = "sb_form_q")
		private WebElement searchBox;
	
	public void searchBing(String searchText) {
		searchBox.sendKeys(searchText);
	}
}
