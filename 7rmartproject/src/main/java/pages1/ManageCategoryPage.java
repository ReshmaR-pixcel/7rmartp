package pages1;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import constants1.Constants;
import utilities1.FileUploadUtility;

public class ManageCategoryPage {
	
	public 	WebDriver driver;

	
	//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']
	
	@FindBy(xpath="//p[text()='Manage Category']") WebElement managecategorypag;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//input[@id='category']") WebElement categories;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement discount;
	@FindBy(xpath="//input[@id='main_img']") WebElement imageuploadbutton;
	
	
	@FindBy(xpath="//button[@name='create']") WebElement savebutton;
	
public ManageCategoryPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}
	
	
	public void clickOnManageCategory() {
		managecategorypag.click();
	}
	public void clickOnNew() {
		//newbutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",newbutton );
	}
	public void enterCategories(String cname) {
		categories.sendKeys(cname);
	
	}
	public void clickDiscount()
	{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
				fluentWait.until(ExpectedConditions.elementToBeClickable(discount));
		discount.click();
		//return this;
	}
	public void clickOnImageUpload() {
		//imageuploadbutton.sendKeys("C:\\Users\\91828\\Downloads\tiger.jpg");
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(imageuploadbutton, Constants.TIGER);//webelement name,
		}
	
	public void clickOnSaveButton() {
		//savebutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",savebutton );
	
	}
	public boolean isNewCategoryDisplayed() {
		return savebutton.isDisplayed();
	}
	
}
