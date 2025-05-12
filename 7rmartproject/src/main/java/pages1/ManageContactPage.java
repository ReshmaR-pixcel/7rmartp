package pages1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	WebDriver driver;

	
	
	@FindBy(xpath = "//p[text()='Manage Contact']")
	 WebElement managecontactbutton; 
	
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement edit; 
	
	@FindBy(xpath = "//input[@id='phone']")
	 WebElement enterphone; 
	
	@FindBy(xpath = "//input[@id='email']")
	 WebElement enteremail;
	
	
	@FindBy(xpath = "//textarea[@name='address']")
	 WebElement enteraddress;
	
	
	@FindBy(xpath = "//textarea[@name='del_time']")
	 WebElement deliverytime; 
	
	@FindBy(xpath = "//input[@id='del_limit']")
	 WebElement enterlimit;
	
	 
	//i[@class='icon fas fa-check']      
	//button[@type='button']
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement greenalert; 
	
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement updatebutton; 
	
	
	public ManageContactPage (WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageContact() {
		//managecontactbutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",managecontactbutton );
	}
	
	public void clickOnActionButton() {
		//edit.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",edit );
	}
	public void enterPhonenumber(String number) {
		enterphone.sendKeys(number);
	}
	public void enterEmail(String email) {
		enteremail.sendKeys(email);
	}
	public void enterAddress(String address) {
		enteraddress.sendKeys(address);
	}
	public void enterDeliveryTime(String Time) {
		deliverytime.sendKeys(Time);
	}
	public void enterDeliveryChargeLimit(String limit) {
		enterlimit.sendKeys(limit);
	}
	public void clickOnUpdate() {
		//updatebutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",updatebutton );
	}
	
	public boolean isAlertDisplayed() {
		return greenalert.isDisplayed();
	}
	public boolean isUpdateButtonDisplayed() {
		return updatebutton.isDisplayed();
	}
}
