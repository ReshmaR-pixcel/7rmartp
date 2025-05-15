package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.LogoutPage;
import utilities1.ExcelUtility;

public class LogoutTest extends Base{
	public LogoutPage logoutpage;
	
	@Test(description="verify if user is able to logout")
	public void verifyIfUserIsAbleToLogout() throws Exception
	{
		String username = ExcelUtility.getStringData(1, 0, "login_page");
		String password = ExcelUtility.getStringData(1, 1, "login_page");
        LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUsername(username).enterPassword(password);
		logoutpage=loginpage.clickOnSignInButton();
		
		logoutpage.admin().logOut();
		boolean loginpageLoaded = logoutpage.isLoginPageLoaded();
		Assert.assertTrue(loginpageLoaded);
		
		
	}

}