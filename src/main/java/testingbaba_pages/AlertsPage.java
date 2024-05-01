package testingbaba_pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base_library.BaseLibrary;

public class AlertsPage extends BaseLibrary 
{ 
  @FindBy(xpath = "//*[text() = \"&Windows\"]")
  private WebElement alertsFrameElement;
  @FindBy(xpath = "//*[@href=\"#tab_12\"]")
  private WebElement alertsElement; 
  @FindBy(xpath = "//*[text() = \"Click me\"][@onclick=\"myalert()\"]")
  private WebElement clickMe1Element;
  @FindBy(xpath = "//*[@onclick=\"aftersec5()\"]")
  private WebElement clickMe2Element;
  @FindBy(xpath = "//*[@onclick=\"myconfirm()\"]")
  private WebElement clickMe3Element;
  @FindBy(xpath = "//*[@onclick=\"myprompt()\"]")
  private WebElement clickMe4Element;
  
  
   public AlertsPage()
   {
	   PageFactory.initElements(driver, this);
   }
   public void clickAlertsFrame()
   {
	  alertsFrameElement.click();
   }
   public void clickAlerts()
   {
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  alertsElement.click();
   }
   public void clickAlerts1()
   {
	  clickMe1Element.click();
      String value = driver.switchTo().alert().getText();
      System.out.println(value);
      driver.switchTo().alert().accept();
   }
   public void clickAlerts2() 
   {
	  clickMe2Element.click();
	  alertIsVisible(5);
	  //we use .accept() method for accepting the alert as mentioned below:
	  driver.switchTo().alert().accept();
   }
   public void clickAlerts3()
   {
	 clickMe3Element.click();  
	 //we use .dismiss() method for rejecting the alert as mentioned below: 
	 driver.switchTo().alert().dismiss();
	 String value = driver.findElement(By.xpath("//*[text()=\"You pressed Cancel!\"]")).getText();
	 SoftAssert sf = new SoftAssert();
	 sf.assertEquals(value, getReaddata("ClickMe3"));
	 sf.assertAll();
   }
   public void clickAlerts4()
   {
	 clickMe4Element.click();
	 driver.switchTo().alert().sendKeys("ok");
	 driver.switchTo().alert().accept();
	 String value = driver.findElement(By.xpath("//*[@id=\"name-result\"]")).getText();
	 Assert.assertEquals(value , getReaddata("ClickMe4"));
   }
}
