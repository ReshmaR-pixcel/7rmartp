package pages1;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants1.Constants;
import utilities1.FileUploadUtility;
import utilities1.PageUtility;

public class SubcategoryPage {
	WebDriver driver;

	// p[text()='Sub Category']
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	WebElement newbutton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement categoryname;

	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement entersubcategoryname;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageupload;
	@FindBy(xpath = "//button[@name='create']")
	WebElement savebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement greenalert;

	

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=3723&page_ad=1']")
	WebElement editaction;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement updatecategory;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement updatesubcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement updateimageuploadfile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updatealert;

	public SubcategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public SubcategoryPage clickOnNewButton() {
		newbutton.click();
		return this;
	}

	public SubcategoryPage enterCategoryName() {
		
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(updatecategory, 5);
		return this;
	}

	public SubcategoryPage enterSubCategoryName(String name1) {
		entersubcategoryname.sendKeys(name1);
		return this;
	}

	public SubcategoryPage clickOnImageUpload() {
		
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(imageupload, Constants.BEETROOT);// webelement name,
		return this;
	}

	public SubcategoryPage clickOnSaveButton() {
		// savebutton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(savebutton));
		savebutton.click();
		return this;
	}

	public boolean isGreenAlertDisplayed() {
		return greenalert.isDisplayed();
	}

	public SubcategoryPage clickOnAction() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaClickMethod(editaction, driver);
		return this;
	}

	public SubcategoryPage clickOnUpdateCategory() {
		// updatebutton.click();
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(updatecategory, 5);
		return this;
	}

	public SubcategoryPage updateSubCategory(String updatetext) {
		updatesubcategory.clear();
		updatesubcategory.sendKeys(updatetext);
		 return this;
	}

	public SubcategoryPage updateImage() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(updateimageuploadfile, Constants.BEETROOT);
		 return this;
	}

	public SubcategoryPage updateSave() {
		// update.click();
		PageUtility pageutility= new PageUtility();
		pageutility.javaClickMethod(update, driver);
		return this;
	
	}

	public boolean isUpdateAlertDisplyed() {
		return updatealert.isDisplayed();
	}

	
}
