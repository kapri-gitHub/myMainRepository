package testingbaba_test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_library.BaseDriver;

public class CrossBrowserTestingTest extends BaseDriver {
	@Test(priority = 1)
	@Parameters({ "Browser" })
	public void demo(String Browser) throws Exception {
		launchBrowser(Browser);
		System.out.println(Browser + " is launched.");
	}
}
