package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities1.PageUtility;

public class LogoutPage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement loginpage;

	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-admin')])[2])")
	WebElement adminusermoreinfo;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement managenewsmoreinfo;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-category')])[3])")
	WebElement managecategorymoreinfo;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-footertext')])[2])")
	WebElement managefootermoreinfo;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")
	WebElement manageContactMoreInfo;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-sub-category')]")
	WebElement subcategorymoreinfo;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	
	public AdminUserPage adminUsersMoreInfo() {
		adminusermoreinfo.click();
		return new AdminUserPage(driver);
	}

	public ManageNewsPage manageNewsMoreInfo() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}

	public ManageCategoryPage clickMoreInfo() {
		managecategorymoreinfo.click();

		return new ManageCategoryPage(driver);

	}

	public ManageFooterTextPage managefooterMoreInfo() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaClickMethod(managefootermoreinfo, driver);
		return new ManageFooterTextPage(driver);
	}

	public ManageContactPage ManageContactMoreInfo() {
		manageContactMoreInfo.click();
		return new ManageContactPage(driver);
	}

	public SubcategoryPage subCategoryMoreInfo() {
		subcategorymoreinfo.click();
		return new SubcategoryPage(driver);
	}

	public LogoutPage admin() {
		admin.click();
		return this;
	}

	public LogoutPage logOut() {
		logout.click();
		return this;
	}

	public boolean isLoginPageLoaded() {
		return loginpage.isDisplayed();

	}
}
