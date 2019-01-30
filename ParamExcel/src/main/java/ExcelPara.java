import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ExcelPara {
	
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
			ob[rowNum-1][3] = rowNum;
		}
		return Arrays.asList(ob);
	}
	private String username;
	private String password;
	private String expected;
	private int row;
	
	public ExcelPara(String username, String password, String expected, int row) {
		this.username = username;
		this.password = password;
		this.expected = expected;
		this.row = row;
	}
	
	@Test
	public void test() throws IOException {
		System.out.println(username + " " + password + " " + expected + " " + row);
	
	}
	
}
