package pages1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AdminUserPage {
	WebDriver driver;

	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	//WebElement adminusermoreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement adminusernew;
	@FindBy(xpath = "//input[@id='username']")
	WebElement adminuserusername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement adminpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement adminusernewsave;
	@FindBy(xpath = "//button[@type='button']")
	WebElement adminuseralert;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*public AdminUserPage clickOnAdminUserMoreInfo() {
		// adminusermoreinfo.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", adminusermoreinfo);
		return this;
	}*/

	public AdminUserPage clickOnAdminUserNewButton() {
		// adminusernew.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", adminusernew);
		return this;
	}

	public AdminUserPage enterNewUsername(String newusername) {
		adminuserusername.sendKeys(newusername);
		return this;
	}

	public AdminUserPage enterNewPassword(String newpassword) {
		adminpassword.sendKeys(newpassword);
		return this;
		
	}

	public AdminUserPage clickOnAdminSelectUsertype() {
		
		Select select = new Select(usertype);
		select.selectByValue("staff");


		//PageUtility pageutility = new PageUtility();
		//pageutility.selectByIndex(usertype, 1);
		return this;
	}

	public AdminUserPage clickOnAdminUserSaveButton() {

		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", adminusernewsave);
		return this;
	}

	public boolean isAdminUserAlertDisplayed() {
		return adminuseralert.isDisplayed();
	}



}
