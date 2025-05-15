package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants1.Constants;
import pages1.LoginPage;
import utilities1.ExcelUtility;

@Test

public class LoginTest1 extends Base {
	
	@Test(groups = { "regression"} ,retryAnalyzer = retry.Retry.class, description = "verify the user able to login using  valid valid username and password")

	public void verifyUserIsAbleToLoginUsingValidUsernameAndPassword() throws IOException {

		/**String usernamevalue = "admin";
		String passwordvalue = "admin";**/
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();

		boolean isdashboardloaded = loginpage.isHomePageLoaded();
		Assert.assertTrue(isdashboardloaded);
		

	}

	@Test(groups = { "regression"} ,retryAnalyzer = retry.Retry.class, description = "verify the user able to login using  valid username and incorrect password")

	public void verifyUserIsAbleToLoginUsingValidUsernameAndIncorrectPassword() throws IOException {

	/**	String usernamevalue = "admin";
		String passwordvalue = "Aravind";**/
		
		String username = ExcelUtility.getStringData(2, 0, "Login_Page");
		String password = ExcelUtility.getStringData(2, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		loginpage.clickOnSignInButton();
		
		boolean isalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed,Constants.LOGINWITHVALIDUSERNAMEANDINCORRECTPASSWORD);

	}

	@Test(groups = { "regression"} ,retryAnalyzer = retry.Retry.class, description = "verify the user able to login using invalid username and correct password")
	public void verifyUserIsAbleToLoginUsingInValidUsernameAndCorrectPassword() throws IOException {

	/**	String usernamevalue = "good";
		String passwordvalue = "admin";**/
		
		String username = ExcelUtility.getStringData(3, 0, "Login_Page");
		String password = ExcelUtility.getStringData(3, 1, "Login_Page");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		
		loginpage.clickOnSignInButton();

		
		boolean isalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed,Constants.LOGINWITHINVALIDUSERNAMEANDCORRECTPASSWORD);

	}

	@Test(groups = { "regression"} ,retryAnalyzer = retry.Retry.class, description = "verify the user able to login using invalid username and incorrect password")
public void verifyUserIsAbleToLoginUsingInValidUsernameAndInCorrectPassword() throws IOException  {
		
	/**String usernamevalue="good";
	String passwordvalue="Aravind";**/
		
		String username = ExcelUtility.getStringData(4, 0, "Login_Page");
		String password = ExcelUtility.getStringData(4, 1, "Login_Page");
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.clickOnSignInButton();
	
	/*@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws Exception {
		return new Object[][] {
				{ ExcelUtility.readStringData(4, 0, "Loginpage"), ExcelUtility.readStringData(4, 1, "Loginpage") } };
	}*/
	
	
	boolean isalertdisplayed = loginpage.isAlertDisplayed();
	Assert.assertTrue(isalertdisplayed, Constants.LOGINWITHINVALIDUSERNAMEANDINCORRECTPASSWORD);
	
}
}
