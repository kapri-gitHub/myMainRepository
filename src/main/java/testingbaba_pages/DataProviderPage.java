.
package testingbaba_pages;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderPage {
	String path = "C:\\Users\\suraj kapri\\Eclipse_Workspace02\\MavenPractice02\\Test_Data\\dataProivderData.xlsx";
	@DataProvider(name = "loginTestData")
	public Object[][] loginData() {
 		/*
		 * This is Static way of using dataProviders; where data is hard coded.
                                                                                                                                              		 */
	Object[][] data = new Object[2][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "Admin";
		data[1][1] = "test123";

		return data;
	}

	@DataProvider(name = "loginDynamicData")
	public Object[][] loginExcelData(int rowno, int colno) {
		/*
		 * This is Dynamic way of using dataProviders; where data is fetched from excel
		 * sheet.
		 */
//		Object[][] excelData = new Object[2][2];
		try { 
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();            			
            int noOfCols = sheet.getRow(0).getPhysicalNumberOfCells();
            
            Object data[][] = new Object[noOfRows - 1][noOfCols]; 

		for(int i=1; i<noOfRows; i++)
		{
			for (int j=0; j<totalColumns; j++)
			{
				String cellData = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]= cellData;
			}
		}
	  return data;
	} 
		//   
}
	
	
	
	
	
	
	
	