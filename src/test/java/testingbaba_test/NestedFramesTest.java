package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_library.BaseLibrary;
import testingbaba_pages.NestedFramesPage;

public class NestedFramesTest extends BaseLibrary 
 {
   NestedFramesPage ob;
   @Parameters("env")
   @BeforeTest
   public void lunchURL(String env)
   {
	  launch_browser(getReaddata(env));
	  ob = new NestedFramesPage();
   }
   @Test(priority = 0)
   public void hitAlertsFrame()
   {
 	 ob.clickAlertsFrame();	  
   }
   @Test(priority = 1)
   public void hitNestedFrames()
   {
	   ob.clickNestedFrames();	  
   }
   @Test(priority = 2)
   public void hitClickhere()
   {
	   ob.clickClickHere();	  
   }
 }
