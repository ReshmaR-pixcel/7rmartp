package pages1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants1.Constants;
import utilities1.FileUploadUtility;
import utilities1.PageUtility;

public class SubcategoryPage1 {
	WebDriver driver;

	// p[text()='Sub Category']
	@FindBy(xpath = "//p[text()='Sub Category']")
	WebElement subcategoryinner;
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

	// update
	// button[@name='update']

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=3723&page_ad=1']")
	WebElement editaction;
	/*@FindBy(xpath = "//button[@name='update']")
	WebElement updatebutton;*/

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

	public SubcategoryPage1(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnSubCategory() {
		// subcategoryinner.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", subcategoryinner);

	}

	public void clickOnNewButton() {
		// newbutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", newbutton);
	}

	public void enterCategoryName() {
		// Select select=new Select(categoryname);
		// select.selectByVisibleText("Beetroot");
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(updatecategory, 5);

	}

	public void enterSubCategoryName(String name1) {
		entersubcategoryname.sendKeys(name1);
	}

	public void clickOnImageUpload() {
		// imageupload.sendKeys("C:\\Users\\91828\\Downloads\beetroot.jpg");
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(imageupload, Constants.BEETROOT);// webelement name,
	}

	public void clickOnSaveButton() {
		// savebutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", savebutton);
	}

	public boolean isGreenAlertDisplayed() {
		return greenalert.isDisplayed();
	}

	public void clickOnAction() {
		// editaction.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", editaction);
	}

	public void clickOnUpdateCategory() {
		// updatebutton.click();
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(updatecategory, 5);
	}

	public void updateSubCategory(String updatetext) {
		updatesubcategory.clear();
		updatesubcategory.sendKeys(updatetext);
		// return this;
	}

	public void updateImage() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(updateimageuploadfile, Constants.BEETROOT);
		// return this;
	}

	public void updateSave() {
		// update.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", update);
		// return this;
	}

	public boolean isUpdateAlertDisplyed() {
		return updatealert.isDisplayed();
	}

	public boolean isUpdateButtonDisplayed() {
		return update.isDisplayed();
	}
}
