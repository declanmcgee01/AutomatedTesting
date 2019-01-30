import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public void addUserTest() throws Exception{
		
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Documents\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		driver.get("http://thedemosite.co.uk/addauser.php");
		DemoSiteLandingPage demo = PageFactory.initElements(driver, DemoSiteLandingPage.class);
		//Reading
		for(int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			List<String> dataList = new ArrayList<String>();
			for(int colNum = 0; colNum < sheet.getRow(rowNum).getPhysicalNumberOfCells(); colNum++) {
				XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
				String userCell = cell.getStringCellValue();
				dataList.add(userCell);
			}
			demo.userEntry(dataList.get(0));
			demo.passwordEntry(dataList.get(1));
			driver.findElement(By.name("FormsButton2")).click();
			Thread.sleep(1000);
			System.out.println(dataList);
			demo.goToLogin();
			demo.userEntry(dataList.get(0));
			demo.passwordEntry(dataList.get(1));
			driver.findElement(By.name("FormsButton2")).click();
			Thread.sleep(1000);
			demo.goToAddUser();
		}
		
	}

}
