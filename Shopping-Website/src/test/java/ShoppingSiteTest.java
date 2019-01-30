import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingSiteTest {
	
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
	public void searchTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		ShoppingSiteLandingPage home = PageFactory.initElements(driver, ShoppingSiteLandingPage.class);
		home.searchEntry("Dress");
		WebElement searchButton = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button"));
		searchButton.click();
		Thread.sleep(3000);
		WebElement success = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/h1/span[1]"));
		assertEquals("Error: Search input not found", "\"DRESS\"", success.getText());
		
	}

}