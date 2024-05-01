package testingbaba_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class NestedFramesPage extends BaseLibrary 
 {
	@FindBy(xpath = "//*[text() = \"&Windows\"]")
	private WebElement alertsFrameElement;
	@FindBy(xpath = "//*[@href=\"#tab_14\"]")
	private WebElement nestedFramesElement;
	@FindBy(xpath = "//*[@src=\"target1.html\"]")
	private WebElement iframe1;
	@FindBy(xpath = "//*[@src=\"text.html\"]")
	private WebElement iframe2;
	@FindBy(xpath = "//*[@src=\"example.html\"]")
	private WebElement iframe3;
	
	 public NestedFramesPage()
	   {
		 PageFactory.initElements(driver, this); 
	   }
	 public void clickAlertsFrame()
	   {
	     alertsFrameElement.click();         	   
	   }
	 public void clickNestedFrames()
	  {
		 nestedFramesElement.click();         	   
	  }
	 public void clickClickHere()
	 {
	   // Outer Parent Frame 
	   driver.switchTo().frame(iframe1);
	   // Inner Parent Frame
	   driver.switchTo().frame(iframe2);
	   // Outer Child Frame
	   driver.switchTo().frame(iframe3);
	   driver.findElement(By.xpath("//*[@href=\"text1.html\"]")).click();
	   String value = driver.findElement(By.xpath("//*[text()=\"Hello\"]")).getText();
	   System.out.println(value);
	   // Below Method is used for returning to Parent Frame.
	   driver.switchTo().parentFrame();
	   String value1 = driver.findElement(By.xpath("//*[text() = \"Parent\"]")).getText();
	   System.out.println(value1);
	   driver.switchTo().defaultContent();
	 }
 }
