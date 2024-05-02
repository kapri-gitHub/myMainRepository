package testing_test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import pages.Assignment;
import propertyutility.PropertyUtility;

public class task2test extends BasePage{
	Assignment ob;

	@Test(priority = 0)
	public void getlaunch() {
		initializeBrowser(PropertyUtility.getreaddata("Browser"), PropertyUtility.getreaddata("URL1"));
		ExtentListeners.testReport.get().log(Status.INFO, "Browser and URL Launch SuccessFully");
	}
	@Test(priority = 2)
	public void task2() {

		ob = new Assignment();
		ob.task2();
	}
}
