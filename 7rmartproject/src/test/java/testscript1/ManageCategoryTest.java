package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.LogoutPage;
import pages1.ManageCategoryPage;
import utilities1.ExcelUtility;
import utilities1.FakerUtility;

public class ManageCategoryTest extends Base {
	public LogoutPage logout;
	public ManageCategoryPage managecategory;
	
@Test(retryAnalyzer = retry.Retry.class,description="verify user is able to add category")

	public void verifyUserIsAbleToAddCategorySuccessfully() throws Exception  {

	
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		FakerUtility fakerutility = new FakerUtility();
		String category1 = fakerutility.creatARandomFirstName();
		
        LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername( username).enterPassword(password);
		
		logout=loginpage.clickOnSignInButton();
		
		
		//ManageCategoryPage maincatagory =new ManageCategoryPage(driver);
		
		managecategory=logout.clickMoreInfo();
		managecategory.clickOnNew().enterCategories(category1).clickDiscount().clickOnImageUpload().clickOnSaveButton();
		
		
		boolean isgreenalertdisplayed= managecategory.isAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed);
		

}
}