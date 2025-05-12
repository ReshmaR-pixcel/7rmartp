package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	 WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement managenewsnewbutton;
	@FindBy(xpath = "//button[@type='submit']")
	 WebElement managenewssavebutton;
	@FindBy(xpath = "//textarea[@id='news']")
	 WebElement newsname;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement greenalert;
	
	public ManageNewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnManageNewsInfo() {
		managenewsmoreinfo.click();
	}

	public void clickOnManageNewsNewButton() {
		managenewsnewbutton.click();
	}

	public void enterTheNews(String newsvalue) {
		newsname.sendKeys(newsvalue);
	}

	public void clickOnManageNewsSaveButton() {
		managenewssavebutton.click();
	}

	public boolean isGreenAlertDisplayed() {
		return greenalert.isDisplayed();
	}


}
