package testscript1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.AdminUserPage;
import pages1.LoginPage;
import utilities1.ExcelUtility;

public class AdminUserTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class)

	
	public void verifyThatUserIsAbleToSaveUserDeatils() throws IOException {

		/**String usernamevalue = "admin";
		String passwordvalue = "admin";**/
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		/*FakerUtility fakerutility=new FakerUtility();
		String adminusername=fakerutility.creatARandomFirstName();
		String adminpassword=fakerutility.creatARandomFirstName();*/
		
		String adminusername=ExcelUtility.getStringData(0, 0,"adminuserpage");
		String adminpassword=ExcelUtility.getStringData(0, 1,"adminuserpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();

		

		/**String newusername = "Ravin";
		String newpassword= "Ravin";**/
		
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		
		adminuserpage.clickOnAdminUserMoreInfo();
		adminuserpage.clickOnAdminUserNewButton();
		adminuserpage.enterNewUsername(adminusername);
		adminuserpage.enterNewPassword(adminpassword);
		adminuserpage.clickOnAdminSelectUsertype();
		adminuserpage.clickOnAdminUserSaveButton();

	

		boolean issavebuttondisplayed = adminuserpage.isSaveButtonDisplayed();
		Assert.assertTrue(issavebuttondisplayed);

	}

	
}