package testingbaba_pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class BrowserWindowsPage extends BaseLibrary
{
  @FindBy(xpath = "//*[@href=\"https://www.google.co.in/\"]") 
  private WebElement newTabElement;
  @FindBy(xpath = "//*[@data-target=\"#alerts\"]")
  private WebElement clickAlertsFrameElement;
  @FindBy(xpath = "//*[text()='browser windows']")
  private WebElement browserWindowsElement;
  @FindBy(xpath = "//*[text()=\"New Window\"]")
  private WebElement newWindowElement;
  @FindBy(xpath = "//*[text()=\"New Window Message\"]")
  private WebElement newWindowMessageElement;
  
  public BrowserWindowsPage()
  {
	 PageFactory.initElements(driver, this);
  }
  public void clickAlertsFrame()
  {
	clickAlertsFrameElement.click();  
  }
  public void clickBrowserWindows()
  {
	 browserWindowsElement.click();
  }
  public void newTab()
   {
	 newTabElement.click();
	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 changewindow(1);
	 driver.close();
	 changewindow(0);
   }
  public void newWindow() 
   {
	 newWindowElement.click();
	 changewindow(1);
	 driver.close();
	 changewindow(0);
   }
  public void newWindowMessage()
   {
	 newWindowMessageElement.click(); 
	 changewindow(1);
	 driver.close();
	 changewindow(0);
   }
}

