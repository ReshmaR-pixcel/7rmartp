package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.ManageFooterTextPage1;
import utilities1.ExcelUtility;

public class ManageFooterTextTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class)

	public void verifyUserCanUpdateFooterTextDetails() throws Exception {

		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();

	

		
		String address=ExcelUtility.getStringData(1, 0,"managefooter");
		String email=ExcelUtility.getStringData(1, 1,"managefooter");
		String phone=ExcelUtility.getStringData(1, 2, "managefooter");
		
		ManageFooterTextPage1 footertextpage = new ManageFooterTextPage1(driver);

		footertextpage.clickOnManageFooterText();
		footertextpage.clickOnActionButton();
		footertextpage.enterAddress(address);
		footertextpage.enterEmail(email);
		footertextpage.enterPhone(phone);
		footertextpage.clickOnUpdate();
		
		boolean isgreenalertdisplayed = footertextpage.isGreenAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed);

	}

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyUpdateButtonIsDisplayed() throws Exception {

		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();

		
		ManageFooterTextPage1 footertextpage = new ManageFooterTextPage1(driver);

		footertextpage.clickOnManageFooterText();
		footertextpage.clickOnActionButton();
		footertextpage.clickOnUpdate();
		
		boolean isupdatebuttondisplayed = footertextpage.isupdateButtonDisplayed();
		Assert.assertTrue(isupdatebuttondisplayed);
	}
}