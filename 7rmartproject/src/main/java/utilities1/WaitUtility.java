package utilities1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final int EXPLICIT_WAIT = 10;
	public static final int IMPLICIT_WAIT=10;//test class
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    wait.until(ExpectedConditions.elementToBeClickable(element));//page class
	}
	public void waitForElementIsSelectable(WebDriver driver,WebElement element) 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
    }
	public void waitForVisibilityOfTheElement(WebDriver driver,String xpath,long time)
	
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitForInVisibilityOfTheElement(WebDriver driver,String xpath,long time)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitForAlertToBePresent(WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    wait.until(ExpectedConditions.alertIsPresent());
	}
}

//selenium has to wait certain time before loading url then if the element isn't load throw exception- implicit-globally-test class
// fluent wait  doesn't wait for exception to complete