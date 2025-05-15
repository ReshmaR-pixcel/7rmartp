package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signin;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement dashboard;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterUsername(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
	}

	public LoginPage enterPassword(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return this;
	}

	public LogoutPage clickOnSignInButton() {
		signin.click();
		return new LogoutPage(driver); //home page
	}

	public boolean isHomePageLoaded() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
