package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.FramesPage;

public class FramesTest extends BaseLibrary 
{
  public FramesPage ob;
  @Parameters("env")
  @BeforeTest
  public void LaunchURL(String env)
  {
	  launch_browser(getReaddata(env));
	  ob = new FramesPage();
  }
  @Test(priority = 0)
  public void hitAlertsFrame()
  {
	 ob.clickAlertsFrame();	  
  }
  @Test(priority = 1)
  public void hitFrames()
  {
	ob.clickFrames();
  }
}
