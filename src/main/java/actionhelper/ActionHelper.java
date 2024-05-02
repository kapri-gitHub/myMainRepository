package actionhelper;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import waitutility.WaitUtility;

public class ActionHelper extends BasePage {

	public static void click(WebElement ele) {
		WaitUtility.waitForVisibility(ele);
		ele.click();

	}

	public static void sendkeys(WebElement ele, String text) {
		WaitUtility.waitForVisibility(ele);
		ele.sendKeys(text);
	}

	public static void clear(WebElement ele) {
		WaitUtility.waitForVisibility(ele);
		ele.clear();
	}

	public static void doubleclick(WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}

	public static void rightclick(WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}

	public static void getwindownchange(int tabno) {
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(set);
		driver.switchTo().window(tabs.get(tabno));
	}

	public static void selectByVisibleText(WebElement ele, String value) {

		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}

	public static void selectByValue(WebElement ele, String value) {

		Select select = new Select(ele);
		select.selectByValue(value);
	}

	public static void mousehover(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

	}

	public static void mousehover_click(WebElement ele, String target) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.linkText(target)).click();

	}

	public static void fileupload(String fileloc) {
		try {

			StringSelection sel = new StringSelection(fileloc);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(sel, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			System.out.println("Exception in fileuploda data" + e);
		}
	}
}
