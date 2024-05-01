package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_library.BaseLibrary;

public class LinksPage extends BaseLibrary
{
	public LinksPage()
	{
		PageFactory.initElements(driver, this);
	}
	  @FindBy(xpath = "//*[@class=\"btn btn-block p-0 text-left\"]")
	  private WebElement elements;
	  @FindBy(xpath = "//*[text()=\"links\"]")
	  private WebElement links;
	  @FindBy(xpath = "//*[text()=\"Demo Page\"]")
	  private WebElement newtab;
	  @FindBy(xpath = "//*[text()=\"×\"]")  
	  private WebElement closebtn;
	  
	  public void click_elements()
	   {
		  elements.click();
		  getScreenshot("passed" , "click_elements");
	   }
	  public void click_links()
	   {
		  try 
		      {
			    elementtobeClickable(links, 2);
			    links.click();
		      } 
		  catch (Exception e) 
		      {
			    System.out.println("Error in click_links: " + e);
		      } 
	   }
	  public void click_demo()
	   {
		 newtab.click();  
	   }
	  public void click_closebtn()
	   {
		 changewindow(1);
		 clickme(closebtn);
		 driver.close();
		 changewindow(0);
	   }
}