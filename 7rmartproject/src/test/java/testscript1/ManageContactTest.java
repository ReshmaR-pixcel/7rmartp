package testscript1;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import pages1.LoginPage;
import pages1.ManageContactPage;
import utilities1.ExcelUtility;
import utilities1.FakerUtility;


public class ManageContactTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class)
	
	public void verifyUserCanEditManageContactSuccessfully() throws Exception {

		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();
	

		FakerUtility fakerutility = new FakerUtility();
		String manageConatctPhone= fakerutility.generatePhone();
		String manageContactEmail = fakerutility.generateEmail();
		String managecontactAddress = fakerutility.generateAddress();
		String manageContactDeliveryTime = "5 pm";
		String manageContactDeliveryCharge = "50";

	ManageContactPage managecontact = new ManageContactPage(driver);
	
	managecontact.clickOnManageContact();
	managecontact.clickOnActionButton();
	
	managecontact.enterPhonenumber(manageConatctPhone);
	managecontact.enterEmail(manageContactEmail);
	managecontact.enterAddress(managecontactAddress);
	managecontact.enterDeliveryTime(manageContactDeliveryTime);
	managecontact.enterDeliveryChargeLimit(manageContactDeliveryCharge);
	managecontact.clickOnUpdate();
	
	boolean isupdatebuttondisplayed= managecontact.isUpdateButtonDisplayed();
	AssertJUnit.assertTrue(isupdatebuttondisplayed);
		
}
	
}
