package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.ManageNewsPage;
import utilities1.ExcelUtility;

public class ManagenewsTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class)
	
	public void verifyUserIsAbleToCreateManageNews() throws Exception {
		
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		
	//String newsvalue = "test automation";
		String text=ExcelUtility.getStringData(1, 0,"managenewspage");
	
	LoginPage loginpage1=new LoginPage(driver);
	
	loginpage1.enterUsername(username);
	loginpage1.enterPassword(password);
	loginpage1.clickOnSignInButton();
	
	
	
	
	ManageNewsPage managenewspage1 = new ManageNewsPage(driver);
	
	managenewspage1.clickOnManageNewsInfo();
	managenewspage1.clickOnManageNewsNewButton();
	
	managenewspage1.enterTheNews(text);
	managenewspage1.clickOnManageNewsSaveButton();
	
	boolean isalertdisplayed = managenewspage1.isGreenAlertDisplayed();
	Assert.assertTrue(isalertdisplayed);
}

}
