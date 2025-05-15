package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.LogoutPage;
import pages1.ManageNewsPage;
import utilities1.ExcelUtility;

public class ManagenewsTest extends Base {
	public LogoutPage logoutpage;
	public ManageNewsPage managenews;
	
	@Test(retryAnalyzer = retry.Retry.class,description="verify that user is able to create news")
	
	public void verifyUserIsAbleToCreateManageNews() throws Exception {
		
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		
	//String newsvalue = "test automation";
		String text=ExcelUtility.getStringData(1, 0,"managenewspage");
	
	LoginPage loginpage=new LoginPage(driver);
	
	loginpage.enterUsername(username).enterPassword(password);
	
	logoutpage=loginpage.clickOnSignInButton();
	
	
	
	
	//ManageNewsPage managenewspage = new ManageNewsPage(driver);
	managenews=logoutpage.manageNewsMoreInfo();
	managenews.clickOnManageNewsNewButton().enterTheNews(text).clickOnManageNewsSaveButton();
	
	
	boolean isalertdisplayed = managenews.isGreenAlertDisplayed();
	Assert.assertTrue(isalertdisplayed);
}

}
