package application_utility;
import org.openqa.selenium.WebElement;

public interface ApplicationUtility 
 {
   public void doubleclick(WebElement ele);
   public void rightclick(WebElement ele);
   public void changewindow(int index);
   public void fileuploading(String path);
   public void clickme(WebElement ele);
   public void selectByValue(String value, WebElement ele);
   public void selectByIndex(WebElement ele, int indexNum);
   public void mouseHover(WebElement ele);
   public void mouseHover_Click(WebElement ele, String value);
   public String getDate();
   public String getDate_Time();
 }
