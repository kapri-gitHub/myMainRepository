package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class datePickerPage extends BaseLibrary 
{
	@FindBy(xpath = "//*[@data-target=\"#widget\"]")
	private WebElement widgetsElement;
	@FindBy(xpath = "//*[@href=\"#tab_18\"]")
	private WebElement datePickerElement;
	@FindBy(xpath = "//*[@id=\"datePickerContainer\"]/div[1]/div[2]/input")
	private WebElement selectDateElement;
	@FindBy(xpath = "//*[@id=\"datePickerContainer\"]/div[2]/div[2]/input")
	private WebElement dateAndTimeElement;
	
	public datePickerPage()
	{
	   PageFactory.initElements(driver, this);
	}
	public void clickWidgets()
	{
		widgetsElement.click();
	}
	public void clickDatePicker()
	{
		datePickerElement.click();
	}
	public void fillDates()
	{
		selectDateElement.sendKeys(getDate());
		dateAndTimeElement.sendKeys(getDate_Time());
		System.out.println(getDate_Time());
	}
}

