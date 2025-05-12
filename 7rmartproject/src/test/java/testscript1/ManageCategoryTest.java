package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.ManageCategoryPage;
import utilities1.ExcelUtility;
import utilities1.FakerUtility;

public class ManageCategoryTest extends Base {
	
@Test(retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToAddCategorySuccessfully() throws Exception  {

	
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		FakerUtility fakerutility = new FakerUtility();
		String category1 = fakerutility.creatARandomFirstName();
		
        LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername( username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();
		
		
		ManageCategoryPage maincatagory =new ManageCategoryPage(driver);
		
		maincatagory.clickOnNew();
		maincatagory.enterCategories(category1);
		maincatagory.clickDiscount();
		maincatagory.clickOnImageUpload();
		maincatagory.clickOnSaveButton();
		
		
		
		
		boolean newcategory = maincatagory.isNewCategoryDisplayed();
		Assert.assertTrue(newcategory);
		

}
}