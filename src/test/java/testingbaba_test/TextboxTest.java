package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.TextboxPage;

public class TextboxTest extends BaseLibrary
{
  TextboxPage ob;
  @Parameters("env")
  @BeforeTest
  public void launchURL(String env)
  {
	 launch_browser(getReaddata(env));
	 ob = new TextboxPage();
  }
  @Test(priority = 0)
  public void verify_title()
  {
	 ob.verify_title();
  }
  @Test(priority =1)
  public void click_elements()
  {
	  ob.click_elements();
  }
  @Test(priority = 2)
  public void click_textbox()
  {
	  ob.click_textbox();
  }
  @Test(priority = 3)
  public void filldata()
  {
	  ob.fill_data();
  }
  @Test(priority = 4)
  public void submitclick()
  {
	  ob.submit_click();
  }
  @Test(priority = 5)
  public void getverifydetails()
  {
	  ob.getverifyDetails();
  }
}
