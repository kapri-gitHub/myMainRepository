package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.datePickerPage;

public class datePickerTest extends BaseLibrary
{
	  datePickerPage ob;
	  @Parameters("env")
	  @BeforeTest(groups = {"sanity"}) 
	  public void launchURL(String env)
	   {
		  System.out.println("datePickerTest: sanity");
		  launch_browser(getReaddata(env));
		  ob = new datePickerPage();
	   }
	  @Test(priority = 0)
	  public void hitWidgets()
	  {
		  ob.clickWidgets(); 
	  }
	  @Test(priority = 1)
	  public void clickDatePicker()
	  {
		  ob.clickDatePicker();
	  }
	  @Test(priority = 2)
	  public void fillDates()
	  {
		  ob.fillDates();
	  }
}
