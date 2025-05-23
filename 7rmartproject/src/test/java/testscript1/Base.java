package testscript1;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import constants1.Constants;
import utilities1.ScreenshotUtility;
import utilities1.WaitUtility;


public class Base {
	
	public WebDriver driver;
	public ScreenshotUtility scrshot;
	public Properties properties;
	public FileInputStream fileinputstream;
	
	@BeforeMethod(alwaysRun=true)
	
@Parameters("browser")
	public void intializeBrowser(String browser) throws Exception
	{
		try {
			properties =new Properties();
			fileinputstream= new FileInputStream(Constants.CONFIGFILE);// creating an object for file input stream
			properties.load(fileinputstream);// passing down the file path inside load
			
		}
		catch(Exception e) {
			System.out.println("invalid");
		}
		if (browser.equalsIgnoreCase("chrome")){
			
		driver =new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")){
			driver =new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")){
			driver =new FirefoxDriver();
		}
		else 
		{
			throw new Exception("failed uploading");
		}


		//driver = new ChromeDriver();
		//driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url")); // file inputstram object is properties to get property as url 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun=true)

	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenshotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		
		driver.quit();
		}	
}

}