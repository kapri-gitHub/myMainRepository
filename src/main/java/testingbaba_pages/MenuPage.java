package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class MenuPage extends BaseLibrary
{
	@FindBy(xpath = "//*[@data-target=\"#widget\"]")
	private WebElement widgetsElement;
	@FindBy(xpath = "//*[text()=\"menu\"]")
	private WebElement menuElement;
	@FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[3]")
	private WebElement servicesElement;
	@FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[4]")
	private WebElement blogElement;
	

	public MenuPage()
	{
	   PageFactory.initElements(driver, this);
	}
	public void clickWidgets()
	{
		widgetsElement.click();
	}

	public void clickMenu()
	{
		menuElement.click();
	}
	
	public void mouseHoverAndClick()
	{
        try {
        	mouseHover(blogElement);   
            Thread.sleep(3000);
            mouseHover_Click(servicesElement, "Website Design");
            Thread.sleep(3000);
            mouseHover_Click(servicesElement, "Mobile Development");
		} 
        catch (Exception e) 
        {
        	
		}
	}
}





