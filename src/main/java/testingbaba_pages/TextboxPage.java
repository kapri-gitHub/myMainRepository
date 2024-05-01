package testingbaba_pages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base_library.BaseLibrary;

public class TextboxPage extends BaseLibrary 
{
	@FindBy(xpath = "//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")
	private WebElement elements;
	@FindBy(xpath = "//*[text() = 'text box']")
	private WebElement textbox;
	@FindBy(xpath = "//*[@id=\"fullname1\"]")
	private WebElement fullname;
	@FindBy(xpath = "//*[@id=\"fullemail1\"]")
	private WebElement Email;
	@FindBy(xpath = "//*[@id=\"fulladdresh1\"]")
	private WebElement current_add;
	@FindBy(xpath = "//*[@id=\"paddresh1\"]")
	private WebElement permanent_add;
	@FindBy(xpath = "//*[@id=\"tab_1\"]/div/div[1]/form/input[3]")
	private WebElement submit;
	
  public TextboxPage()
	{
	  PageFactory.initElements(driver ,this);
	}
  
  public void verify_title()
   {
	 String title = driver.getTitle();
	 System.out.println("Title of this page is: " + title);
   }
  public void click_elements()
    {
	  elements.click();
    }
  public void click_textbox()
  {
	textbox.click();
  }
  public void fill_data()
  {
	  fullname.sendKeys(getReaddata(0,0,1));
	  Email.sendKeys(getReaddata(0,1,1));
	  current_add.sendKeys(getReaddata(0,2,1));
	  permanent_add.sendKeys(getReaddata(0,3,1));
  }
  public void submit_click()
  {
	submit.click();
  }
  public void getverifyDetails()
  {
	 ArrayList<String> actual = new ArrayList<String>(); 
	 ArrayList<String> expected = new ArrayList<String>();
	 List<WebElement> list = driver.findElements(By.xpath("//*[@class=\"col-md-6 mt-5\"]/label"));
	 for(int i=1; i<=list.size()-1; i=i+2)
	 {
		 actual.add(list.get(i).getText());
	 }
	 
//	 for(WebElement dd:list)
//	 {
//		 actual.add(dd.getText());
//	 }
	 
	  expected.add(getReaddata(0,0,1));
	  expected.add(getReaddata(0,1,1));
	  expected.add(getReaddata(0,2,1));
	  expected.add(getReaddata(0,3,1));
   	  SoftAssert sf = new SoftAssert();
	  
//	for(String dd:actual)
//	{	
//	  for(String dd1:expected)
//	  {
//		  Assert.assertEquals(dd,dd1);
//		  expected.remove(dd1);
//		  break;
//	  }
//	}
	 for(String dd:actual)
		{	
		  for(String dd1:expected)
		  {
			  sf.assertEquals(dd,dd1);
			  expected.remove(dd1);
			  break;
		  }
		}
	 sf.assertAll();
  }
}









