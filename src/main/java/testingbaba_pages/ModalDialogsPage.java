package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base_library.BaseLibrary;

public class ModalDialogsPage extends BaseLibrary 
{
	@FindBy(xpath = "//*[text() = \"&Windows\"]")
	private WebElement alertsFrameElement;
	@FindBy(xpath = "//*[@href=\"#tab_15\"]")
	private WebElement modalDialogsElement;
	@FindBy(xpath = "//*[@data-target=\"#exampleModal1\"]")
	private WebElement smallModalElement;
	@FindBy(xpath = "//*[@id=\"exampleModal1\"]/div/div/div[2]")
	private WebElement smallModalTextElement;
	@FindBy(xpath = "//*[@id=\"exampleModal1\"]/div/div/div[3]/button")
	private WebElement closeButtonElement;
	@FindBy(xpath = "//*[@data-target=\"#exampleModal2\"]")
	private WebElement largeModalElement;
	@FindBy(xpath = "//*[@id=\"exampleModal2\"]/div/div/div[2]/p/b")
	private WebElement largeModalTextElement;
	@FindBy(xpath = "//*[@id=\"exampleModal2\"]/div/div/div[3]/button")
	private WebElement largeModalCloseBtnElement;
	
	 public ModalDialogsPage()
	   {
		 PageFactory.initElements(driver, this); 
	   }
	 public void clickAlertsFrame()
	   {
	     alertsFrameElement.click();         	   
	   }
	 public void clickModalDialogs()
	   {
		 modalDialogsElement.click();
	   }
	 public void clickSmallModal()
	   {
		 smallModalElement.click();
	   }
	 public void clickSmallModalText() 
	   {
		 WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
		 wait.until(ExpectedConditions.visibilityOf(smallModalTextElement));
	/*   Below Hard Assert is used for applying assertion with true-false boolean values; 
	   	.isDisplayed() is a method that will return true or false value accoring to the 
	   	visibility of the web element if the web element is visible it will return true and assertion 
	   	will be passed and if element is not visible it will return false value and assertion will be 
	   	failed. 
	*/ 
		 Assert.assertEquals(smallModalTextElement.isDisplayed(), true); /* this line is not necessary
		 here but it is added here to tell you the use of this sort of assertion. {Expected value
		 is "true"} */
		 
		 String value1 = smallModalTextElement.getText();
		 String value2 = getReaddata("SmallModal");
		 System.out.println("Actual Value:   "+value1);
		 System.out.println("Expected Value: "+value2);

		 SoftAssert sf = new SoftAssert();
		 sf.assertEquals(value1 , value2);
		 sf.assertAll();
	 	 closeButtonElement.click();
	   }
	 public void clickLargeModal() 
	   {
		 largeModalElement.click();
	   }
	 public void clickLargeModalText() 
	   {
		 WebDriverWait wait= new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOf(largeModalTextElement));
		 
		 System.out.println("Actual Value:   "+largeModalTextElement.getText());
		 System.out.println("Expected Value: "+getReaddata("LargeModal"));
		 
		 SoftAssert sf = new SoftAssert();
		 sf.assertEquals(largeModalTextElement.getText(), getReaddata("LargeModal"));
		 sf.assertAll();
		 largeModalCloseBtnElement.click();
	   }
}
