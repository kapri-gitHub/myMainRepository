package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_library.BaseLibrary;
import testingbaba_pages.ModalDialogsPage;

public class ModalDialogsTest extends BaseLibrary
 {
	   ModalDialogsPage ob;
	   @Parameters("env")
	   @BeforeTest
	   public void lunchURL(String env)
	   {
		  launch_browser(getReaddata(env));
		  ob = new ModalDialogsPage();
	   }
	   @Test(priority = 0)
	   public void hitAlertsFrame()
	   {
	 	 ob.clickAlertsFrame();	 
	   }
	   @Test(priority = 1)
	   public void hitModalDialogs()
	   {
		   ob.clickModalDialogs();
	   }
	   @Test(priority = 2)
	   public void hitSmallModal()
	   {
		   ob.clickSmallModal();
	   }
	   @Test(priority = 3)
	   public void hitSmallModalText() 
	   {
		   ob.clickSmallModalText();
	   }
	   @Test(priority = 4 , enabled = true)
	   public void hitLargeModalText() 
	   {
		   ob.clickLargeModal();
		   ob.clickLargeModalText();
	   }
 }
