package testingbaba_pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_library.BaseLibrary;

public class FileUploadingPage extends BaseLibrary
{
	String file = "C:\\Users\\suraj kapri\\Eclipse_Workspace02\\Maven_Practice02\\Test_Data\\test_data.xlsx";
	public FileUploadingPage()
	 {
	   PageFactory.initElements(driver, this);
	 }
	@FindBy(xpath = "//*[@class=\"btn btn-block p-0 text-left\"]")
	private WebElement elements;
	@FindBy(xpath = "//*[text()=\"upload and download\"]")
	private WebElement upload;
	@FindBy(xpath = "//*[text()=\"Select a file\"]")
	private WebElement selectFile;
    
	public void click_elements()
	 {
		elements.click();
	 }
	public void click_upload()
	{
		try
		{
		  Thread.sleep(3000);
		  upload.click();
		}
		catch(Exception e)
		{
		  System.out.println("exception in click_upload: "+ e);	
		}
	}
	public void click_select()
	{
      selectFile.click();		
	}
	public void click_uploadfile()
	{
		fileuploading(file);
	}
}
