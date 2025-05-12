package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.LogoutPage;

public class LogoutTest extends Base {

	@Test

	public void verifyUserCanLogoutSuccessfully()  {
		
		String usernamevalue = "admin";
		String passwordvalue = "admin";
		LoginPage loginpage1 = new LoginPage(driver);
		loginpage1.enterUsername(usernamevalue);
		loginpage1.enterPassword(passwordvalue);
		loginpage1.clickOnSignInButton();

		

		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickOnAdminbutton();
		logoutpage.clickOnLogoutButton();
		boolean isloginpagedisplayed = logoutpage.isLoginPageDisplayed();
		Assert.assertTrue(isloginpagedisplayed);
	}
}
