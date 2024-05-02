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
  @BeforeTest (groups = {"regression"})
  public void launchURL(String env)
  {
	 launch_browser(getReaddata(env));
	 ob = new TextboxPage();
  }
  @Test(priority = 0 , groups = {"regression"})
  public void verify_title()
  {
	 ob.verify_title();
  }
  @Test(priority =1 , groups = {"regression"})
  public void click_elements()
  {
	  ob.click_elements();
  }
  @Test(priority = 2, groups = {"regression"})
  public void click_textbox()
  {
	  ob.click_textbox();
  }
  @Test(priority = 3, groups = {"regression"})
  public void filldata()
  {
	  ob.fill_data();
  }
  @Test(priority = 4, groups = {"regression"})
  public void submitclick()
  {
	  ob.submit_click();
  }
  @Test(priority = 5, groups = {"regression"})
  public void getverifydetails()
  {
	  ob.getverifyDetails();
  }
}
