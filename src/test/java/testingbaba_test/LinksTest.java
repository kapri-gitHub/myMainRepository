package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_library.BaseLibrary;
import testingbaba_pages.LinksPage;

public class LinksTest extends BaseLibrary
{
  LinksPage ob;
  @Parameters("env")
  @BeforeTest
  public void launch_Browser(String env)
  {
	 launch_browser(getReaddata(env));
	 ob = new LinksPage();
  }
  @Test(priority = 0)
  public void hit_elements()
  {
	 ob.click_elements();
  }
  @Test(priority = 1)
  public void hit_links()
  {
	 ob.click_links();
  }
  @Test(priority = 2)
  public void hit_demopage()
  {
	 ob.click_demo(); 
  }
  @Test(priority = 3)
  public void hit_closebtn()
  {
	 ob.click_closebtn();
  }
}
