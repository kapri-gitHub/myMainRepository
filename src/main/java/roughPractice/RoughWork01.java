package roughPractice;
import org.openqa.selenium.edge.EdgeDriver;

public class RoughWork01 {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\suraj kapri\\WorkSpace01\\MavenPractice02\\Drivers\\msedgedriver.exe" );
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.amazon.com/"); // driver.get will open new window/tab each time.
		driver.navigate().to("https://www.amazon.com/");
		driver.navigate().to("https://www.flipkart.com/");// navigate().to("") will launch the website on the same window/tab.
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Title of the page: " + driver.getTitle());
		//System.out.println("Page Source: " + driver.getPageSource());
		driver.navigate().to("https://www.testingbaba.com/old");
		driver.navigate().back();
//		driver.quit();
	}
}
