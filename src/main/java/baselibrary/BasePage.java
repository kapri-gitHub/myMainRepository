package baselibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver = null;

	public void initializeBrowser(String browser, String url) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome is Launched ");

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firebox is Launched ");

		}

		else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge Browser is Launched ");

		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}
    
	public static WebElement waitForElementToBeClickable(WebElement webelement, WebDriver driver, Duration seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
		return element;

	}
	public static WebElement waitForElementToBeVisible(WebElement webelement, WebDriver driver, Duration seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(webelement));
		return element;
	}
	public static List<WebElement> waitForElementToBeVisible1(List<WebElement> ele, WebDriver driver2, Duration seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElements(ele));
		return element;
		
	}
	public static String getReaddata(String path, String sheetname, int colno, int rowno) {
	String value="";
		try {
			FileInputStream fis=new  FileInputStream(path);//Java FileInputStream class obtains input bytes from a file.
			XSSFWorkbook wb=new XSSFWorkbook(fis);// This class has methods to read and write Microsoft Excel and OpenOffice xml files in .xls or .xlsx format.
			XSSFSheet sheet=wb.getSheet(sheetname);
			value=sheet.getRow(rowno).getCell(colno).getStringCellValue();
		} catch (Exception e) {
		System.out.println("Issue in get data");
		}
		return  value; 
	}
    public static  int Lastgetrow(String path) {
    int noOfRows = 0;
	try {
		FileInputStream fis=new  FileInputStream(path);//Java FileInputStream class obtains input bytes from a file.
		XSSFWorkbook wb=new XSSFWorkbook(fis);// This class has methods to read and write Microsoft Excel and OpenOffice xml files in .xls or .xlsx format.
		XSSFSheet sheet=wb.getSheet("Marketplace Comapnies tagging");
		noOfRows = sheet.getLastRowNum();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return noOfRows;
}
}
