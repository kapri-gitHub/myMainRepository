package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.LoginPage;

public class LoginTest extends BaseLibrary
{
  LoginPage ob;
  @Parameters("env")
  @BeforeTest
  public void launchURL(String env)
  {
	  launch_browser(getReaddata(env));
	  ob = new LoginPage();
  }
  
  @Test (priority =0)
  public void title_verify()
  {
	  ob.verifyTitle();
  }
  
  @Test (priority =1)
  public void click_elements()
  {
	  ob.click_elements();
  }
}






