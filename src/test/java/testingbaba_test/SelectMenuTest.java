package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_library.BaseLibrary;
import testingbaba_pages.SelectMenuPage;

public class SelectMenuTest extends BaseLibrary
{
  SelectMenuPage ob;
  @Parameters("env")
  @BeforeTest  
  public void launchURL(String env)
  {
	  launch_browser(getReaddata(env));
	  ob = new SelectMenuPage();
  }
  @Test(priority = 0)
  public void hitWidgets()
  {
	  ob.clickWidgets();
  }
  @Test(priority = 1)
  public void hitSelectMenu()
  {
	 ob.clickSelectMenu();
  }
  @Test(priority = 2)
  public void selectByValueDropdown() throws InterruptedException
  {
	  ob.selectByValueDropdown();
  }
  @Test(priority = 3)
  public void selectOneDropdown()
  {
	  ob.selectOneDropdown();
  }
  @Test(priority = 4)
  public void oldSelectMenu()
  {
	  ob.oldSelectMenu();
  }
  @Test(priority = 5)
  public void multiSelectMenu()
  {
	  ob.multiSelectMenu();
  }
}
