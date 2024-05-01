package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.CheckBoxPage;

public class CheckBoxTest extends BaseLibrary
{
  CheckBoxPage ob;
  @Parameters("env")
  @BeforeTest
  public void launchURL(String env)
  {
	  launch_browser(getReaddata(env));
	  ob = new CheckBoxPage();
  }
  @Test(priority = 0)
  public void hit_elements()
  {
	  ob.click_elements();
  }
  @Test(priority = 1)
  public void hit_checkbox()
  {
	  ob.click_checkbox();
  }
  @Test(priority = 2)
  public void hit_Mobile() 
  {
	  ob.click_mobile();
  }
  @Test(priority = 3)
  public void hit_Laptop() 
  {
	  ob.click_laptop();
  }
  @Test(priority = 4)
  public void hit_Desktop() 
  {
	  ob.click_desktop();
  }
}
