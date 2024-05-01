package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_library.BaseLibrary;

public class ButtonsPage extends BaseLibrary
{
  public ButtonsPage()
  {
    PageFactory.initElements(driver, this);	
  }
  
  @FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
  private WebElement element; 
  @FindBy(xpath = "//*[@id=\"tab_5\"]/div[1]/button")
  private WebElement double_click;
  @FindBy(xpath = "//*[@id=\"noContextMenu\"]")
  private WebElement right_click;
  @FindBy(xpath = "//*[text() = 'buttons']")
  private WebElement button_click;
  
  public void click_elements()
  {
	 element.click(); 
  }
  public void click_buttons() throws InterruptedException
  {
	Thread.sleep(3000);
    button_click.click(); 
  }
  public void click_double() throws InterruptedException
  {
	  Thread.sleep(3000);
	  doubleclick(double_click);
  }
  public void click_right() throws InterruptedException
  {
	 Thread.sleep(3000);
	 rightclick(right_click);
  }
}
