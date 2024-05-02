package testing_test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import pages.Assignment;

import propertyutility.PropertyUtility;

public class Login_Test extends BasePage

{
	Assignment ob;

	@Test(priority = 0)
	public void getlaunch() {
		initializeBrowser(PropertyUtility.getreaddata("Browser"), PropertyUtility.getreaddata("URL"));
		ExtentListeners.testReport.get().log(Status.INFO, "Browser and URL Launch SuccessFully");
	}

	@Test(priority = 1)
	public void gettitle() {
		ob = new Assignment();
		ob.gettitle();
		ob.Assignmenttest();
	}
	@Test(priority = 2)
	public void task2() {

		ob = new Assignment();
		ob.gettitle();
		ob.task2();
	}

}
