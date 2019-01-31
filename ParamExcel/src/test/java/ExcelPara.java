import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@RunWith(Parameterized.class)
public class ExcelPara {
	
	
	@Before
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVERLOCATION);
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Parameters
	public static Collection<Object[]> data() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Documents\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows()-1][4];
		
		
		//Reading
		for(int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			for(int colNum = 0; colNum < sheet.getRow(rowNum).getPhysicalNumberOfCells()-1; colNum ++) {
				ob[rowNum-1][colNum] = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			}
			workbook.close();
			ob[rowNum-1][3] = rowNum;
		}
		return Arrays.asList(ob);
	}
	private String username;
	private String password;
	private String expected;
	private int rowNum;
	private WebDriver driver;
	
	public ExcelPara(String username, String password, String expected, int rowNum) {
		this.username = username;
		this.password = password;
		this.expected = expected;
		this.rowNum = rowNum;
	}
	
	@Test
	public void test() throws IOException {
		
		driver.get(Constants.ADDUSERPAGE);
		
		AddUserPage addUserPage = PageFactory.initElements(driver, AddUserPage.class);
		addUserPage.addUser(username, password);
		
		driver.get(Constants.LOGINPAGE);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginUser(username, password);
		
		FileInputStream file = new FileInputStream(Constants.FILELOCATION);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell;
		cell = row.getCell(3);
		if(cell == null) {
			cell = row.createCell(3);
		}
		cell.setCellValue(loginPage.loginAttemptText());
		
		try {
			assertEquals("ERROR: Login not successful", expected, loginPage.loginAttemptText());
			cell = row.getCell(4);
			if(cell == null) {
				cell = row.createCell(4);
			}
			cell.setCellValue("PASS");
		} catch (AssertionError e) {
			cell = row.getCell(4);
			if (cell == null) {
				cell = row.createCell(4);
			}
			cell.setCellValue("FAIL");
			Assert.fail();
		} finally {
		
		FileOutputStream fileOut = new FileOutputStream(Constants.FILELOCATION);
		
		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		
		workbook.close();
		file.close();
		}
	}
	
}