package testingbaba_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base_library.BaseLibrary;

public class AutoComplete_AccordionPage extends BaseLibrary {
	@FindBy(xpath = "//*[@data-target=\"#widget\"]")
	private WebElement widgetsElement;
	@FindBy(xpath = "//*[@href=\"#tab_17\"]")
	private WebElement autoCompleteElement;
	@FindBy(xpath = "/html/body/form/div")
	private WebElement fillAutoCompleteElement;
	@FindBy(xpath = "//*[@id=\"tab_17\"]/div/iframe")
	private WebElement iFrameElement;
	@FindBy(xpath = "//*[text() = 'accordion']")
	private WebElement accordionElement;

	public AutoComplete_AccordionPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickWidgets() {
		widgetsElement.click();
	}

	public void clickAutoComplete() {
		autoCompleteElement.click();
	}

	public void fillAutoComplete() {
		try {
			driver.switchTo().frame(iFrameElement);
			fillAutoCompleteElement.click();
			Thread.sleep(2000);
			fillAutoCompleteElement.sendKeys("a");
			Thread.sleep(2000);
			/*
			 * If inside any textbox we have to press any button then we use "Keys" as done
			 * below!!!
			 */
			fillAutoCompleteElement.sendKeys(Keys.ARROW_DOWN);
			fillAutoCompleteElement.sendKeys(Keys.ARROW_DOWN);
			fillAutoCompleteElement.sendKeys(Keys.ENTER);
			driver.switchTo().defaultContent();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

	public void clickAccordion() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'accordion']")));
		accordionElement.click();
	}
}