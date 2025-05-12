package pages1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities1.PageUtility;

public class AdminUserPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminusermoreinfo;
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

	public void clickOnAdminUserMoreInfo() {
		// adminusermoreinfo.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", adminusermoreinfo);
	}

	public void clickOnAdminUserNewButton() {
		// adminusernew.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", adminusernew);
	}

	public void enterNewUsername(String newusername) {
		adminuserusername.sendKeys(newusername);

	}

	public void enterNewPassword(String newpassword) {
		adminpassword.sendKeys(newpassword);
	}

	public void clickOnAdminSelectUsertype() {
		/**
		 * Select select=new Select(usertype); select.selectByValue("staff");
		 **/

		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(usertype, 1);

	}

	public void clickOnAdminUserSaveButton() {

		// adminusernewsave.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", adminusernewsave);
	}

	public boolean isAdminUserAlertDisplayed() {
		return adminuseralert.isDisplayed();
	}

	public boolean isSaveButtonDisplayed() {
		return adminusernewsave.isDisplayed();
	}

}
