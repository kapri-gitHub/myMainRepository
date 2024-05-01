package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.ProgressBarPage;

public class ProgressBarTest extends BaseLibrary
{
	  ProgressBarPage ob;
	  @Parameters("env")
	  @BeforeTest  
	  public void launchURL(String env)
	   {
		  launch_browser(getReaddata(env));
		  ob = new ProgressBarPage();
	   }
	  @Test(priority = 0)
	  public void hitWidgets()
	  {
		  ob.clickWidgets();
	  }
	  @Test(priority = 1)
	  public void clickProgressBar()
	  {
		  ob.clickProgressBar();
	  }
	  @Test(priority = 2)
	  public void getProgressBar()
	  {
		  ob.getProgressBar();
	  }
}
