package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class LoginPage extends BaseLibrary
{
  public LoginPage()
  {
	 PageFactory.initElements(driver, this);
  }
 
  @FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
  private WebElement click_element;
  
  public void verifyTitle()	
  {
	  String title = driver.getTitle();
	  System.out.println("Title for of this WebApp is: "+ title);
  }
  public void click_elements()
  {
	click_element.click();  
  }
}
