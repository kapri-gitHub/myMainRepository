package testingbaba_pages;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base_library.BaseLibrary;

public class SelectMenuPage extends BaseLibrary 
 {
	@FindBy(xpath = "//*[@data-target=\"#widget\"]")
	private WebElement widgetsElement;
	@FindBy(xpath = "//*[text() = \"select menu\"]")
	private WebElement selectMenuElement;
	@FindBy(xpath = "//*[@id=\"tab_24\"]/form/div/div[1]/select")
	private WebElement selectValueElement;
	@FindBy(xpath = "//*[@id=\"tab_24\"]/form/div/div[2]/select")
	private WebElement selectOneElement;
	@FindBy(xpath = "//*[@id=\"tab_24\"]/form/div/div[3]/div/select")
	private WebElement oldSelectElement;
	@FindBy(xpath = "//*[@id=\"tab_24\"]/form/div/div[5]/div/select")
	private WebElement multiSelectElement;
	
	
	public SelectMenuPage()
	{
	   PageFactory.initElements(driver, this);
	}
	public void clickWidgets()
	{
		widgetsElement.click();
	}
	public void clickSelectMenu()
	{
		selectMenuElement.click();
	}
	public void selectByValueDropdown() throws InterruptedException
	{
		selectByValue("Group 1, Option 1", selectValueElement);
//		Thread.sleep(2000);
//		selectByIndex(selectMenuElement, 0);
		
	/* Below method is used to print all the values from the drop-down. It may be asked
	 * in the interview "How to get the data from the drop down?" we have a "getOptions()" method 
	 * in the Select class for getting the data from the dropdown. */
		
		Select sel = new Select(selectValueElement);
		List<WebElement> dd= sel.getOptions();
		for(WebElement dd1:dd)
		{
			System.out.println(dd1.getText());
		}
	}
	public void selectOneDropdown()
	{
		selectByIndex(selectOneElement, 2);
	}
	public void oldSelectMenu()
	{
		selectByValue("CSS",oldSelectElement);
	}
	public void multiSelectMenu()
	{
		try 
		{
			Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_CONTROL);				
		    selectByValue("PHP",multiSelectElement);
		    selectByValue("HTML",multiSelectElement);
		    selectByValue("CSS",multiSelectElement);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		} 
		catch (Exception e) 
		{
          System.out.println(e);			
		}
	}
 }

















