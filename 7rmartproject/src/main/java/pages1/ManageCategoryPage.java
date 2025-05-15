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
import utilities1.PageUtility;

public class ManageCategoryPage {
	
	 	WebDriver driver;

	
	//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']
	
	//@FindBy(xpath="//p[text()='Manage Category']") WebElement managecategorypage;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//input[@id='category']") WebElement categories;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement discount;
	@FindBy(xpath="//input[@id='main_img']") WebElement imageuploadbutton;
	
	@FindBy(xpath="//button[@name='create']") WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
public ManageCategoryPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}
	
	
	/*public void clickOnManageCategory() {
		managecategorypag.click();
	}*/

	public ManageCategoryPage clickOnNew() {
	
		newbutton.click();
		
		return this;
	}
	public ManageCategoryPage enterCategories(String cname) {
		categories.sendKeys(cname);
		return this;
	}
	public ManageCategoryPage  clickDiscount()
	{
		
		discount.click();
		return this;
	}
	public ManageCategoryPage  clickOnImageUpload() {
		
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(imageuploadbutton, Constants.TIGER);//webelement name,
		return this;
		}
	
	public ManageCategoryPage  clickOnSaveButton() {
		//savebutton.click();
		PageUtility pageutility = new PageUtility();
		pageutility.javaClickMethod(savebutton, driver);
		return this;
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
	
}
