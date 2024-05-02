package pages;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import propertyutility.PropertyUtility;

public class Assignment extends BasePage {
	
	public Assignment() {
		PageFactory.initElements(driver, this);
	}
	public static String path =System.getProperty("user.dir")+"/src/test/resources/DataRead.xlsx";
	@FindBy(xpath="//input[@id='txtStationFrom']")
	
	private WebElement from;
	@FindBy(xpath="//div[@class='autocomplete']/div")
	
	private List<WebElement> listOfStation;
	@FindBy(xpath="//*[@title='Select Departure date for availability']")
	private WebElement sortondate;
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	@FindBy(xpath="//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement user;
	@FindBy(xpath="//*[text()='Logout']")
	private WebElement logout;

	public WebElement selectdate(String date) {
		return driver.findElement(By.xpath("(//table[@class='Month']/tbody)[1]/tr/td[text()='"+date+"']"));	
				
	}
	public void gettitle() {
		String title = driver.getTitle();
		ExtentListeners.test.log(Status.INFO, title+" Title verified successfully");
		System.out.println("Title is " +title);
	}
	
	public void Assignmenttest() {
		waitForElementToBeVisible(from, driver,Duration.ofSeconds(20)).click();
		waitForElementToBeVisible(from, driver,Duration.ofSeconds(20)).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		waitForElementToBeVisible(from, driver,Duration.ofSeconds(20)).sendKeys("DEL");
		int size=listOfStation.size();
	    waitForElementToBeClickable(listOfStation.get(3), driver, Duration.ofSeconds(50)).click();
		for(int i=0;i<listOfStation.size();i++) {
			Assert.assertEquals(getReaddata(path,"Sheet1",0,i+1), listOfStation.get(i).getAttribute("title"));
		}

        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(30);
        String Date=futureDate.toString().split("-")[2];
        System.out.println("Date after 30 days: " + futureDate.toString().split("-")[2]);
	    waitForElementToBeClickable(sortondate, driver, Duration.ofSeconds(50)).click();
	    waitForElementToBeClickable(selectdate(Date), driver, Duration.ofSeconds(50)).click();

	}
	public void task2() {
		SoftAssert softassert=new SoftAssert();
		for(int i=0;i<4;i++) {
			username.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
			waitForElementToBeClickable(username, driver, Duration.ofSeconds(50)).sendKeys(getReaddata(path,"Sheet2",0,i+1));;
			password.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
			waitForElementToBeClickable(password, driver, Duration.ofSeconds(50)).sendKeys(getReaddata(path,"Sheet2",1,i+1));;
		    login.click();
		    if(driver.getCurrentUrl().contains("dashboard")) {
		    	softassert.assertTrue(true);
				waitForElementToBeClickable(user, driver, Duration.ofSeconds(50)).click();;
				waitForElementToBeClickable(logout, driver, Duration.ofSeconds(50)).click();;

		    }
		    else {
		    	softassert.assertTrue(false);

		    }
		}
	}

}
