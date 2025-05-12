package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	 WebElement Admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	 WebElement logout;
	@FindBy(xpath = "//body[@class='login-page']")
	 WebElement loginpage;
	



	public void clickOnAdminbutton() {
		Admin.click();
	}

	public void clickOnLogoutButton() {
		logout.click();
	}

	public boolean isLoginPageDisplayed() {
		return loginpage.isDisplayed();
	}
}
