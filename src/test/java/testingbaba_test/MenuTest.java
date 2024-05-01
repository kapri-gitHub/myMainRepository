package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.MenuPage;

public class MenuTest  extends BaseLibrary
{
  MenuPage ob;
  @Parameters("env")
  @BeforeTest  
  public void launchURL(String env)
   {
	  launch_browser(getReaddata(env));
	  ob = new MenuPage();
   }
  @Test(priority = 0)
  public void hitWidgets()
  {
	  ob.clickWidgets();
  }

  @Test(priority = 1)
  public void clickMenu()
  {
	  ob.clickMenu();
  }

  @Test(priority = 2)
  public void mouseHoverAndClick()
  {
       ob.mouseHoverAndClick();
  }
}
