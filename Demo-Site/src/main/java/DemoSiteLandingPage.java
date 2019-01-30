import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteLandingPage {
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userBox;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passwordBox;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userLogin;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passwordLogin;
	
	public void userEntry(String userName) {
		userBox.sendKeys(userName);
	}
	
	public void passwordEntry(String password) {
		passwordBox.sendKeys(password);
	}
	
	public void userLogin(String userName) {
		userLogin.sendKeys(userName);
	}
	
	public void passwordLogin(String password) {
		passwordLogin.sendKeys(password);
	}
}
