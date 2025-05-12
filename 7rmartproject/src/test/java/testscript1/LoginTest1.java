package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import utilities1.ExcelUtility;

@Test

public class LoginTest1 extends Base {
	@Test(groups = { "regression"} ,retryAnalyzer = retry.Retry.class)

	public void verifyUserIsAbleToLoginUsingValidUsernameAndPassword() throws IOException {

		/**String usernamevalue = "admin";
		String passwordvalue = "admin";**/
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();

		boolean ishomepageavailable = loginpage.isDashboardLoaded();
		Assert.assertTrue(ishomepageavailable);
		

	}

	@Test(groups = { "regression"} ,retryAnalyzer = retry.Retry.class)

	public void verifyUserIsAbleToLoginUsingValidUsernameAndIncorrectPassword() throws IOException {

	/**	String usernamevalue = "admin";
		String passwordvalue = "Aravind";**/
		
		String username = ExcelUtility.getStringData(2, 0, "Login_Page");
		String password = ExcelUtility.getStringData(2, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();

		
		boolean isalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed);

	}

	@Test(groups = { "regression"} ,retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToLoginUsingInValidUsernameAndCorrectPassword() throws IOException {

	/**	String usernamevalue = "good";
		String passwordvalue = "admin";**/
		
		String username = ExcelUtility.getStringData(3, 0, "Login_Page");
		String password = ExcelUtility.getStringData(3, 1, "Login_Page");
		LoginPage loginpage1 = new LoginPage(driver);
		loginpage1.enterUsername(username);
		loginpage1.enterPassword(password);
		loginpage1.clickOnSignInButton();

		
		boolean isalertdisplayed = loginpage1.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed);

	}

	@Test(groups = { "regression"} ,retryAnalyzer = retry.Retry.class)
public void verifyUserIsAbleToLoginUsingInValidUsernameAndInCorrectPassword() throws IOException  {
		
	/**String usernamevalue="good";
	String passwordvalue="Aravind";**/
		
		String username = ExcelUtility.getStringData(4, 0, "Login_Page");
		String password = ExcelUtility.getStringData(4, 1, "Login_Page");
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.clickOnSignInButton();
	
	
	boolean isalertdisplayed = loginpage.isAlertDisplayed();
	Assert.assertTrue(isalertdisplayed);
	
}
}
