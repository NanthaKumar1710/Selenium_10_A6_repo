package genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
/**
 * @author S.Nantha
 */
public class WebDriverUtility {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximixe(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * this method will mousehover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * this method will scroll to element
	 * @param driver
	 * @param element
	 */
	public void scrollToEelement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
		
	}
	
	public void scroll(WebDriver driver,int x,int y) {
		Actions act=new Actions(driver);
		act.scrollByAmount(x, y).perform();
		
		
	}
	
	public void  selectDropdown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectDropdown(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectDropdown(String text,WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	
	public void swithToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
	}
	
	public void swithToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
		
	}
	
	public void swithToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	
	}
	/**
	 * this this used to switch to alert
	 * @param driver
	 * @return 
	 */
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
		
	}
	
	public void getPhoto(WebDriver driver) throws IOException {
		JavaUtility jutil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+jutil.getSystemTime()+".png");
		FileHandler.copy(temp, dest);
		
	}
	
	public void switchToWindow(WebDriver driver,String expUrl) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(expUrl)) {
				break;
			}
		}
		
	}
	
	public void switchToWindow(String expTitle,WebDriver driver) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String actTitle = driver.getTitle();
			if(actTitle.contains(expTitle)) {
				break;
			}
		}
		
	}
	
	
	 
			
}
