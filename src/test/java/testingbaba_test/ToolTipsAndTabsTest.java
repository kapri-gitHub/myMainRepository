package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.ToolTipsAndTabsPage;

public class ToolTipsAndTabsTest extends BaseLibrary
{
	ToolTipsAndTabsPage ob;
	  @Parameters("env")
	  @BeforeTest  
	  public void launchURL(String env)
	   {
		  launch_browser(getReaddata(env));
		  ob = new ToolTipsAndTabsPage();
	   }
	  @Test(priority = 0)
	  public void hitWidgets()
	  {
		  ob.clickWidgets();
	  }
	  @Test(priority = 1)
	  public void clickToolTips()
	  {
		  ob.clickToolTips();
	  }
	  @Test(priority = 2)
	  public void getToolTips()
	  {
		  ob.getToolTips();
	  }
	  @Test(priority = 3)
	  public void clickTabs()
	  {
		  ob.clickTabs();
	  }
}
