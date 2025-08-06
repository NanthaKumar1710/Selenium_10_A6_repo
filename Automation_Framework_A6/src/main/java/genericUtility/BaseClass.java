package genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WelcomePage;
/**
 * @author S.Nantha
 */
public class BaseClass {
	
	public static ExtentReports ereports;
	public static ExtentTest test;
	
	public JavaUtility jutil=new JavaUtility();
	public static WebDriver driver;
	public FileUtility futil=new FileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public ExcelUtility eutil=new ExcelUtility();
	
	@BeforeSuite
	public void reportcnfig() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports"+jutil.getSystemTime()+".html");
		ereports=new ExtentReports();
		ereports.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() throws IOException {
		 driver=new ChromeDriver();
		 wutil.maximixe(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 driver.get(futil.getDataFromProperty("url"));
		
	}
	
	@BeforeMethod
	public void  login() throws IOException {
		WelcomePage wp=new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getEmailTF().sendKeys(futil.getDataFromProperty("email"));
		lp.getPasswordTF().sendKeys(futil.getDataFromProperty("password"));
		lp.getLoginBtn().click();
		
	}
	
	@AfterMethod()
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutlink().click();
	}
		
	
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		ereports.flush();
	}

}
