package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class ProgressBarPage extends BaseLibrary
{
	@FindBy(xpath = "//*[@data-target=\"#widget\"]")
	private WebElement widgetsElement;
	@FindBy(xpath = "//*[@href=\"#tab_20\"]")
	private WebElement progressBarElement;
	@FindBy(xpath = "//*[@id=\"myBar\"]")
	private WebElement progressBarProgressElement;
	@FindBy(xpath = "//*[@onclick=\"move()\"]")
	private WebElement startElement;
	
	
	
	public ProgressBarPage()
	{
	   PageFactory.initElements(driver, this);
	}
	public void clickWidgets()
	{
		widgetsElement.click();
	}
	public void clickProgressBar()
	{
		progressBarElement.click();
	}
	public void getProgressBar()
	{
		try 
	 	{
			String value1 = progressBarProgressElement.getAttribute("style");
			System.out.println(value1);
	        startElement.click();
	        Thread.sleep(3000);
			String value2 = progressBarProgressElement.getAttribute("style");
			System.out.println(value2);		
		} 
		catch (Exception e) 
		{
			
		}
	}
}
