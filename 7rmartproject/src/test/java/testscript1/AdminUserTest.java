package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.AdminUserPage;
import pages1.LoginPage;
import pages1.LogoutPage;
import utilities1.ExcelUtility;
import utilities1.FakerUtility;

public class AdminUserTest extends Base {
	public LogoutPage logoutpage;
	public AdminUserPage adminuserpage;
	@Test(retryAnalyzer = retry.Retry.class,description="verify theat user is able to save user details")

	
	public void verifyThatUserIsAbleToSaveUserDeatils() throws IOException {

		/**String usernamevalue = "admin";
		String passwordvalue = "admin";**/
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		FakerUtility fakerutility=new FakerUtility();
		String adminusername=fakerutility.creatARandomFirstName();
		String adminpassword=fakerutility.creatARandomFirstName();
		
		/*String adminusername=ExcelUtility.getStringData(0, 0,"adminuserpage");
		String adminpassword=ExcelUtility.getStringData(0, 1,"adminuserpage");*/

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(adminpassword);
		
		LogoutPage logoutpage= loginpage.clickOnSignInButton();

		

		/**String newusername = "Ravin";
		String newpassword= "Ravin";**/
		
		//AdminUserPage adminuserpage = new AdminUserPage(driver);
		
		
		adminuserpage=logoutpage.adminUsersMoreInfo();
		
		adminuserpage.clickOnAdminUserNewButton().clickOnAdminUserNewButton().enterNewUsername(adminusername).enterNewPassword(adminpassword).clickOnAdminSelectUsertype().clickOnAdminUserSaveButton();
		

	

		boolean isalertdisplayed = adminuserpage.isAdminUserAlertDisplayed();
		Assert.assertTrue(isalertdisplayed);

	}

	
}