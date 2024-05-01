package testingbaba_pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base_library.BaseLibrary;

public class CheckBoxPage extends BaseLibrary
{
  public CheckBoxPage()
  {
	  PageFactory.initElements(driver, this);
  }
  @FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
  private WebElement element;
  @FindBy(xpath = "//*[text() = 'check box']")
  private WebElement checkbox;
  @FindBy(xpath = "/html/body/label")
  private WebElement mobile;
  @FindBy (xpath = "/html/body/div[1]/label")
  private WebElement laptop;
  @FindBy (xpath = "//*[@onclick=\"myFunction2()\"]")
  private WebElement desktop;
  @FindBy (xpath = "//*[@id=\"tab_2\"]/div/iframe")
  private WebElement frame;
  public void click_elements()
  {
	  element.click();
  }
  public void click_checkbox()
  {
	  checkbox.click();
  }
  public void click_mobile()
  {
	  driver.switchTo().frame(frame);
	  mobile.click();
	  String mobiletext = driver.findElement(By.xpath("//*[@id=\"text\"]")).getText();
	  System.out.println("Mobile Text is: "+mobiletext);
	  SoftAssert sf = new SoftAssert();
	  sf.assertEquals(mobiletext , getReaddata("Mobile"));
	  sf.assertAll();
  }
  public void click_laptop() 
  {
	 laptop.click();
	 String laptopText = driver.findElement(By.xpath("//*[@id=\"text1\"]")).getText();
	 // Soft Assert is used below - 
	 SoftAssert sf = new SoftAssert();
	 // below step performs individual soft assertions during the course of the test.
	 sf.assertEquals(laptopText , getReaddata("Laptop"));
	 // assertAll() method "aggregates and reports" all the soft assertion failures "at the end of the test".
	 sf.assertAll();
  }
  public void click_desktop() 
  {
	//Implicit Wait Below
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	desktop.click();  
	String desktopText = driver.findElement(By.xpath("//*[@id=\"text2\"]")).getText();
	// Hard Assert is used below -
	Assert.assertEquals(desktopText , getReaddata("Desktop"));
	driver.switchTo().defaultContent();
  }
}
