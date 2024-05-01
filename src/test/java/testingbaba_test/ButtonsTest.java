package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.ButtonsPage;

public class ButtonsTest extends BaseLibrary
{
	ButtonsPage ob;
	@Parameters("env")
    @BeforeTest
	public void launch_URL(String env)
	{
		launch_browser(getReaddata(env));
		ob = new ButtonsPage();
	}
	
	@Test(priority = 0)
	public void hit_elements()
	{
		ob.click_elements();
	}
	
	@Test(priority = 1)
	public void hit_buttons() throws InterruptedException
	{
       ob.click_buttons();		
	}
	
	@Test(priority = 2)
	public void hit_double_right() throws InterruptedException
	{
		ob.click_double();
		ob.click_right();
	}
}
