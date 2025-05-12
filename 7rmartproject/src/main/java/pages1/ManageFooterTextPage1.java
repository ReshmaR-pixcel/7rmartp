package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage1 {
	
	WebDriver driver;
	
	
	
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")  WebElement managefootertext;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")  WebElement actionbutton;
@FindBy(xpath="//textarea[@id='content']") WebElement address;
@FindBy(xpath="//input[@id='email']") WebElement email;
@FindBy(xpath="//input[@id='phone']")  WebElement phone;
@FindBy(xpath="//i[@class='icon fas fa-check']") WebElement greenalertupdate;
@FindBy(xpath="//button[@name='Update']") WebElement updatebutton;

public ManageFooterTextPage1(WebDriver driver) {
	
	this.driver= driver;
	PageFactory.initElements(driver, this);
	
}


public void clickOnManageFooterText() {
	managefootertext.click();
}
public void clickOnActionButton() {
	actionbutton.click();
}
public void enterAddress(String addressvalue) {
	address.sendKeys(addressvalue);
}
public void enterEmail(String emailid) {
	email.sendKeys(emailid);
}
public void enterPhone( String phonenumber) {
	phone.sendKeys(phonenumber);
}
public void clickOnUpdate() {
	updatebutton.click();
}
public boolean isGreenAlertDisplayed() {
	return greenalertupdate.isDisplayed();
}
public boolean isupdateButtonDisplayed() {
	return updatebutton.isDisplayed();
}
}