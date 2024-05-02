package pages;

import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;

public class Login_page extends BasePage {
	public void gettitle() {
		String title = driver.getTitle();
		ExtentListeners.test.log(Status.INFO, title+" Title verified successfully");
		System.out.println("Title is " +title);
	}

}
