package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.AutoComplete_AccordionPage;

public class AutoComplete_AccordionTest extends BaseLibrary {
	AutoComplete_AccordionPage ob;

	@Parameters("env")
	@BeforeTest(groups = { "regression" })
	public void launchURL(String env) {
	System.out.println("regression");
	launch_browser(getReaddata(env));
	ob = new AutoComplete_AccordionPage();
	}

	@Test(groups = { "sanity" }, priority = 0)
	public void hitWidgets() {
		System.out.println("sanity");
		ob.clickWidgets();
	}

	@Test(priority = 1, groups = { "dev", "regression" })
	public void clickAutoComplete() {
		System.out.println("dev, regression");
		ob.clickAutoComplete();
	}

	@Test(priority = 2, groups = { "sanity" })
	public void fillAutoComplete() {
		System.out.println("sanity");
		ob.fillAutoComplete();
	}

	@Test(priority = 3, groups = { "dev" })
	public void clickAccordion() {
		System.out.println("dev");
		ob.clickAccordion();
	}
}