package testscript1;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import pages1.LoginPage;
import pages1.LogoutPage;
import pages1.ManageContactPage;
import utilities1.ExcelUtility;
import utilities1.FakerUtility;


public class ManageContactTest extends Base {
	public LogoutPage logoutpage;
	public ManageContactPage managecontactpage;

	@Test(retryAnalyzer = retry.Retry.class, description = "Verify the user is able to update contact details")
	
	public void verifyUserCanEditManageContactSuccessfully() throws Exception {

		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		
		String manageConatctPhone=  ExcelUtility.getIntegerData(1, 0, "managecontact");
		String manageContactEmail = ExcelUtility.getStringData(1, 1, "managecontact");
		String managecontactAddress = ExcelUtility.getStringData(1, 2, "managecontact");
		String manageContactDeliveryTime =ExcelUtility.getIntegerData(1, 3, "managecontact");
		String manageContactDeliveryCharge =ExcelUtility.getIntegerData(1, 4,"managecontact");
	
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		
		logoutpage=loginpage.clickOnSignInButton();
	

		
	//ManageContactPage managecontact = new ManageContactPage(driver);
	
		managecontactpage=logoutpage.ManageContactMoreInfo();
		managecontactpage.clickOnActionButton().enterPhonenumber(manageConatctPhone).enterEmail(manageContactEmail).enterAddress(managecontactAddress).enterDeliveryTime(manageContactDeliveryTime).enterDeliveryChargeLimit(manageContactDeliveryCharge).clickOnUpdate();
	

	
	boolean isgreenalertdisplayed= managecontactpage.isAlertDisplayed();
	AssertJUnit.assertTrue(isgreenalertdisplayed);
		
}
	
}
