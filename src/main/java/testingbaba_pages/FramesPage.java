package testingbaba_pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class FramesPage extends BaseLibrary 
{
  @FindBy(xpath = "//*[text() = \"&Windows\"]")
  private WebElement alertsFrameElement;
  @FindBy(xpath = "//*[@href=\"#tab_13\"]")
  private WebElement FramesElement;
  @FindBy(xpath = "//*[@style=\"height:200px;width:400px\"]")
  private WebElement iframeElement;
  @FindBy(xpath = "//*[@style=\"height:80px;width:120px\"]")
  private WebElement iframe2Element;
  @FindBy(xpath = "//*[@href=\"#tab_14\"]")
  private WebElement nestedFrameElement;
  
  public FramesPage()
  {
	 PageFactory.initElements(driver, this);
  }
  public void clickAlertsFrame()
   {
     alertsFrameElement.click();         	   
   }
  public void clickFrames()
   {
	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
	 FramesElement.click();
	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 driver.switchTo().frame(iframeElement);
	 String value = driver.findElement(By.xpath("//*[text() = \"This is a sample page\"]")).getText();
	 System.out.println(value);
	 driver.switchTo().defaultContent();
	 driver.switchTo().frame(iframe2Element);
	 String valueSecond = driver.findElement(By.xpath("//*[text() = \"This is a sample page\"]")).getText();
	 System.out.println(valueSecond);
	 driver.switchTo().defaultContent();
   }
}  
