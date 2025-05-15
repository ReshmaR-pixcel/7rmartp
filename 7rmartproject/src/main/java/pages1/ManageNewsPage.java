package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	

	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement managenewsnewbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	 WebElement newsname;
	@FindBy(xpath = "//button[@type='submit']")
	 WebElement managenewssavebutton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement greenalert;
	
	public ManageNewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public ManageNewsPage  clickOnManageNewsNewButton() {
		managenewsnewbutton.click();
		return this;
	}

	public ManageNewsPage  enterTheNews(String newsvalue) {
		newsname.sendKeys(newsvalue);
		return this;
	}

	public ManageNewsPage  clickOnManageNewsSaveButton() {
		managenewssavebutton.click();
		return this;
	}

	public boolean isGreenAlertDisplayed() {
		return greenalert.isDisplayed();
	}


}
