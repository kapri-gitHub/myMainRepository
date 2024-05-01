package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class ToolTipsAndTabsPage extends BaseLibrary
{
	@FindBy(xpath = "//*[@data-target=\"#widget\"]")
	private WebElement widgetsElement;
	@FindBy(xpath = "//*[text() = \"tool tips\"]")
	private WebElement toolTipsElement;
	@FindBy(xpath = "//*[@id=\"tab_22\"]/button")
	private WebElement mouseHoverElement;
	@FindBy(xpath = "//*[@class=\"my-3 form-control\"]")
	private WebElement mouseHoverElement2;
	@FindBy(xpath = "//*[text() = \"tabs\"]")
	private WebElement tabsElement;
	@FindBy(xpath = "//*[text() = \"Tab 2\"]")
	private WebElement tabs2Element;
	@FindBy(xpath = "//*[@id=\"profile\"]/p[1]")
	private WebElement tabs2TextElement;
	
	public ToolTipsAndTabsPage()
	{
	   PageFactory.initElements(driver, this);
	}
	public void clickWidgets()
	{
		widgetsElement.click();
	}
	public void clickToolTips()
	{
		toolTipsElement.click();
	}
	public void getToolTips()
	{
		// First mouseHoverElement
		mouseHover(mouseHoverElement);
		String tip = mouseHoverElement.getAttribute("title");
		System.out.println(tip);
		
		//Seond mouseHoverElement
		mouseHover(mouseHoverElement2);
		String tip2 = mouseHoverElement2.getAttribute("title");
		System.out.println(tip2);
	}
	public void clickTabs()
	{
		try 
		{
			tabsElement.click();
			Thread.sleep(3000);
			tabs2Element.click();
			String text = tabs2TextElement.getText();
			Thread.sleep(3000);
			System.out.println(text);
		} 
		catch (Exception e) 
		{
			
		}
}
}