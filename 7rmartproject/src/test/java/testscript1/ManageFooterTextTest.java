package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.LogoutPage;
import pages1.ManageFooterTextPage;
import utilities1.ExcelUtility;

public class ManageFooterTextTest extends Base {
	public LogoutPage logoutpage;
	public ManageFooterTextPage managefootertext;
	
	@Test(retryAnalyzer = retry.Retry.class,description="verify if user is able to update footer details")

	public void verifyUserCanUpdateFooterTextDetails() throws Exception {

		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
	
		logoutpage=loginpage.clickOnSignInButton();

		String address=ExcelUtility.getStringData(1, 0,"managefooter");
		String email=ExcelUtility.getStringData(1, 1,"managefooter");
		String phone=ExcelUtility.getIntegerData(1, 2, "managefooter");
		
		//ManageFooterTextPage footertextpage = new ManageFooterTextPage(driver);

		managefootertext=logoutpage.managefooterMoreInfo();
		managefootertext.clickOnActionButton().enterAddress(address).enterEmail(email).enterPhone(phone).clickOnUpdate();
		
		
		boolean isalertdisplayed = managefootertext.isGreenAlertDisplayed();
		Assert.assertTrue(isalertdisplayed);

	}

	@Test(retryAnalyzer = retry.Retry.class,description="verify if update button is displayed")
	public void verifyUpdateButtonIsDisplayed() throws Exception {

		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		
		logoutpage=loginpage.clickOnSignInButton();

		managefootertext=logoutpage.managefooterMoreInfo();
		
		//ManageFooterTextPage footertextpage = new ManageFooterTextPage(driver);

		managefootertext.clickOnActionButton().clickOnUpdate();
		
		
		boolean isupdatebuttondisplayed = managefootertext.isupdateButtonDisplayed();
		Assert.assertTrue(isupdatebuttondisplayed);
	}
}