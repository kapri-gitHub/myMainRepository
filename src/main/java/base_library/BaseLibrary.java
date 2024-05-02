package base_library;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import application_utility.ApplicationUtility;
import excel_utility.Excelutility;
import property_utility.PropertyUtility;
import screenshot_utility.ScreenshotUtility;
import wait_utility.WaitUtility;

public class BaseLibrary implements Excelutility, PropertyUtility, WaitUtility, ApplicationUtility, ScreenshotUtility 
  {
	static public WebDriver driver = null;
	String path = "C:\\Users\\suraj kapri\\WorkSpace01\\MavenPractice02\\Test_Data\\test_data.xlsx";
	String configpath = "C:\\Users\\suraj kapri\\WorkSpace01\\MavenPractice02\\Test_Data\\config.properties";

	// For launching browser.
	public void launch_browser(String url) 
	 {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\suraj kapri\\WorkSpace01\\MavenPractice02\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myModal2\"]/div/div/div[1]/button")));
		driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[1]/button")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")).click();
	 }

	// For reading any Excel File.
	public String getReaddata(int sheetno, int colno, int rowno) 
	 {
		String value = "";
		try 
		 {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(sheetno);
			value = sheet.getRow(rowno).getCell(colno).getStringCellValue();
			wb.close();
		 }
		catch (Exception e) 
		{
			System.out.println("Error in getReaddata: " + e);
		}
		return value;
	 }

	//@AfterTest
	public void teardown() 
	{
		driver.close();
	}

	// For reading any property file.
	public String getReaddata(String key) 
	{
		String url = "";
		try 
		{
			FileInputStream fis = new FileInputStream(configpath);
			Properties prop = new Properties();
			prop.load(fis);
			url = prop.getProperty(key);
		} 
		catch (Exception e) {
			System.out.println("Issue in getread data in property file: " + e);
		}
		return url;
	}

	// For double click and right click.
	public void doubleclick(WebElement ele) 
	{
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}

	public void rightclick(WebElement ele) 
	{
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}

	// For changing the window.
	public void changewindow(int tabno) 
	{
		// 1. Get all window handles of currently opened tabs/windows by the WebDriver.
		//Def: A window handle is a unique identifier assigned to each window opened by the WebDriver.
		Set<String> set = driver.getWindowHandles();
		// 2. Convert the set of window handles to an ArrayList for easier indexing.
		ArrayList<String> tabs = new ArrayList<String>(set);
		// 3. Switch to the specified window/tab based on the index provided (tabno).
		driver.switchTo().window(tabs.get(tabno));
	}
	// For uploading the file.
	public void fileuploading(String path) 
	{
		try 
		{
			StringSelection sel = new StringSelection(path);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(sel, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} 
		catch (Exception e) 
		{
			System.out.println("Error in fileuploading: " + e);
		}
	}

    // For taking the screenshot.
	public void getScreenshot(String foldername, String filename) 
	{
		try 
		 {
			String loc = System.getProperty("user.dir");
			String path = loc + "\\Screenshot\\" + foldername + "\\" + filename + ".png";
			EventFiringWebDriver efw = new EventFiringWebDriver(driver);
			File src = efw.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			FileUtils.copyFile(src, new File(path));
		 } 
		catch (Exception e) 
		 {
			System.out.println("Issue in getScreenshot: " + e);
		 }
	}
	// kindly complete this method; it is incomplete at the moment
	@AfterMethod
	public void getAnalysis(ITestResult result)
	{
	   String name = result.getMethod().getMethodName();	
	   try 
	   {
		  if(result.getStatus()==ITestResult.SUCCESS)
		  {
			  
		  }
	   } 
	   catch (Exception e) 
	   {
	
	   }
	}

 // For using wait.
	public void elementtobeClickable(WebElement ele, int time) 
	 {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	 }

	public void clickme(WebElement ele) 
	 {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	 }
    
	// wait for alerts
	public void alertIsVisible(int time) 
	{
	  WebDriverWait wait = new WebDriverWait(driver, time);	
	  wait.until(ExpectedConditions.alertIsPresent());
	}

	public void selectByValue(String value, WebElement ele) 
	{
       Select sel = new Select(ele);		
       sel.selectByVisibleText(value);
	}

	public void selectByIndex(WebElement ele, int indexNum) 
	{
       Select sel = new Select(ele);   		
       sel.selectByIndex(indexNum);
	}
    /*Below method will only hover any element; will not click it*/
	public void mouseHover(WebElement ele) 
	{
       Actions act = new Actions(driver); 		
       act.moveToElement(ele).perform();
	}
    /*Below method will hover any element and click that element as well.*/
	public void mouseHover_Click(WebElement ele, String value) 
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.linkText(value)).click();
	}

	public String getDate() 
	{
	   String date = "";
       Date db = new Date();
       SimpleDateFormat sb = new SimpleDateFormat("dd-MM-yyyy");
       date = sb.format(db);
       return date;  
	}

	public String getDate_Time() 
	{
	   String date = "";
       Date db = new Date();
       SimpleDateFormat sb = new SimpleDateFormat("dd-MM-yyyy hh:mm");
       date = sb.format(db);
       return date;  
	}
}
