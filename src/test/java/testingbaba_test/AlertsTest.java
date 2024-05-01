package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.AlertsPage;

public class AlertsTest extends BaseLibrary
{
   public AlertsPage ob;
   @Parameters("env")
   @BeforeTest
	public void launchURL(String env)
	   {
	 	  launch_browser(getReaddata(env));
	      ob = new AlertsPage();	  
	   }
   @Test(priority = 0)
   public void hitAlertsFrame() 
    {
	   ob.clickAlertsFrame();
    } 
   @Test(priority =1)
   public void hitClickAlerts()
   {
	  ob.clickAlerts();
   }
   @Test(priority = 2)
   public void hitAlerts1()
   {
	  ob.clickAlerts1();
   }
   @Test(priority = 3, enabled = true)
   public void hitAlerts2() 
   {
	   ob.clickAlerts2();
   }
   @Test(priority = 4, enabled = true)
   public void hitAlerts3()
   {
	   ob.clickAlerts3();
   }
   @Test(priority = 5, enabled = true)
   public void hitAlerts4()
   {
	  ob.clickAlerts4(); 
   }
}
