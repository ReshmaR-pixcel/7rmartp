package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities1.PageUtility;

public class ManageContactPage {
	WebDriver driver;

	
	
	/*@FindBy(xpath = "//p[text()='Manage Contact']")
	 WebElement managecontactbutton; */
	
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement edit; 
	
	@FindBy(xpath = "//input[@id='phone']")
	 WebElement enterphone; 
	
	@FindBy(xpath = "//input[@id='email']")
	 WebElement enteremail;
	
	
	@FindBy(xpath = "(//textarea[@id='content'])[1]")
	 WebElement enteraddress;
	
	
	@FindBy(xpath = "(//textarea[@id='content'])[2]")
	 WebElement deliverytime; 
	
	@FindBy(xpath = "//input[@id='del_limit']")
	 WebElement enterdeliverychargelimit;
	
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement updatebutton;  
	
	//i[@class='icon fas fa-check']      
	//button[@type='button']
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement greenalert; 
	
	public ManageContactPage (WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*public void clickOnManageContact() {
		//managecontactbutton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",managecontactbutton );
	}*/
	
	public ManageContactPage clickOnActionButton() {
		edit.click();
		return this;
		
	}
	public ManageContactPage enterPhonenumber(String number) {
		enterphone.clear();
		enterphone.sendKeys(number);
		return this;
	}
	public ManageContactPage enterEmail(String email) {
		enteremail.clear();
		enteremail.sendKeys(email);
		return this;
	}
	public ManageContactPage enterAddress(String address) {
		enteraddress.clear();
		enteraddress.sendKeys(address);
		return this;
	}
	public ManageContactPage enterDeliveryTime(String Time) {
		deliverytime.clear();
		deliverytime.sendKeys(Time);
		return this;
	}
	public ManageContactPage enterDeliveryChargeLimit(String limit) {
		enterdeliverychargelimit.clear();
		enterdeliverychargelimit.sendKeys(limit);
		return this;
	}
	public ManageContactPage clickOnUpdate() {
		//updatebutton.click();
		PageUtility pageutility= new PageUtility();
		pageutility.javaClickMethod(updatebutton, driver);
		return this;
	}
	
	public boolean isAlertDisplayed() {
		return greenalert.isDisplayed();
	}
	
}
