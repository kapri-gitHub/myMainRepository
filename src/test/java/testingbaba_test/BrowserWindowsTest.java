package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.BrowserWindowsPage;
public class BrowserWindowsTest extends BaseLibrary
{
  BrowserWindowsPage ob;
  @Parameters("env")
  @BeforeTest
  public void launch_URL(String env)
   {
	 launch_browser(getReaddata(env));
	 ob = new BrowserWindowsPage();
   }
  @Test(priority = 0)
  public void hitAlertsFrame()
   {
	 ob.clickAlertsFrame();  
   }
  @Test (priority = 1)
  public void hitBrowserWindows()
  {
	ob.clickBrowserWindows();  
  }
  @Test(priority = 2)
  public void hitNewTab() throws InterruptedException 
   {
	  Thread.sleep(3000);
	  ob.newTab(); 
   }
  @Test(priority = 3)
  public void hitNewWindow() throws InterruptedException  
  {
	  Thread.sleep(3000);
	  ob.newWindow();
	  
  }
  @Test(priority = 4)
  public void hitNewWindowMessage()
  {
	 ob.newWindowMessage();
  }
}

















