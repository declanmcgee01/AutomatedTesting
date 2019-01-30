import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteLandingPage {
	
	@FindBy(name = "username")
	private WebElement userBox;
	@FindBy(name = "password")
	private WebElement passwordBox;
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUserButton;
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement logInButton;
	
	public void userEntry(String userName) {
		userBox.sendKeys(userName);
	}
	
	public void passwordEntry(String password) {
		passwordBox.sendKeys(password);
	}
	
	public void goToAddUser() {
		addUserButton.click();
	}
	
	public void goToLogin() {
		logInButton.click();
	}
	
}
