package testingbaba_test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base_library.BaseLibrary;
import testingbaba_pages.FileUploadingPage;

public class FileUploadingTest extends BaseLibrary
{
  FileUploadingPage ob;
  @Parameters("env")
  @BeforeTest
  public void Launch_URL(String env)
  {
	  launch_browser(getReaddata(env));
	  ob = new FileUploadingPage();
  }
  @Test(priority = 0)
  public void hit_elements()
  {
	  ob.click_elements();
  }
  @Test(priority = 1)
  public void hit_upload()
  {
	  ob.click_upload();
  }
  @Test(priority = 2)
  public void hit_select()
  {
	  ob.click_select();
  }
  @Test(priority = 3)
  public void hit_fileupload()
  {
	  ob.click_uploadfile();
  }
}
