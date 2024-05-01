package testingbaba_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTestPage 
{
	@Test(dataProvider = "loginTestData")
	public void testLogin(String userName, String password) throws Exception 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@type=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"oxd-userdropdown-name\"]")).isDisplayed());
		driver.quit(); 
	}

	@DataProvider(name = "loginTestData")
	public Object[][] loginData()
	{
		Object[][] data= new Object[2][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "Admin";
		data[1][1] = "test123";

		return data;
	}
}