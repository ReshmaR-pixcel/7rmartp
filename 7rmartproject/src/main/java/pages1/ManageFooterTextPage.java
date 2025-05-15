package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities1.PageUtility;

public class ManageFooterTextPage {
	
	WebDriver driver;
	
	
	
/*@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")  WebElement managefootertext;*/

	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1')]") WebElement actionbutton;
@FindBy(xpath="//textarea[@id='content']") WebElement address;
@FindBy(xpath="//input[@id='email']") WebElement email;
@FindBy(xpath="//input[@id='phone']")  WebElement phone;
@FindBy(xpath="//button[@name='Update']") WebElement updatebutton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement greenalertupdate;


public ManageFooterTextPage(WebDriver driver) {
	
	this.driver= driver;
	PageFactory.initElements(driver, this);
	
}


/*public void clickOnManageFooterText() {
	managefootertext.click();
}*/

public ManageFooterTextPage clickOnActionButton() {
	actionbutton.click();
	return this;
}
public ManageFooterTextPage enterAddress(String addressvalue) {
	address.clear();
	address.sendKeys(addressvalue);
	return this;
}
public ManageFooterTextPage enterEmail(String emailid) {
	email.clear();
	email.sendKeys(emailid);
	return this;
}
public ManageFooterTextPage enterPhone( String phonenumber) {
	phone.clear();
	phone.sendKeys(phonenumber);
	
	return this;
}

public ManageFooterTextPage clickOnUpdate() {
	//updatebutton.click();
	PageUtility pageutility = new PageUtility();
	pageutility.javaClickMethod(updatebutton, driver);
	return this;
}
public boolean isGreenAlertDisplayed() {
	return greenalertupdate.isDisplayed();
}
public boolean isupdateButtonDisplayed() {
	return updatebutton.isDisplayed();
}
}