import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoSiteTest {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();	
	}
	
	@Test
	public void addUserTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		DemoSiteLandingPage demo = PageFactory.initElements(driver, DemoSiteLandingPage.class);
		demo.userEntry("declan");
		demo.passwordEntry("password");
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
		Thread.sleep(3000);
		WebElement loginButton =  driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		loginButton.click();
		demo.userLogin("declan");
		demo.passwordLogin("password");
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
		Thread.sleep(5000);
		WebElement success = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("Error: Unsuccessful Login", "**Successful Login**", success.getText());
	}

}
