package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.SubcategoryPage1;
import utilities1.ExcelUtility;
import utilities1.FakerUtility;

public class SubcategoryTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyUserCanAddCategorySuccessfully() throws Exception {
		
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();
	
		//String name1="plant";
		FakerUtility fakerutility = new FakerUtility();
		String category1  = fakerutility.creatARandomFirstName();
		
		SubcategoryPage1 subcategoryp=new SubcategoryPage1(driver);
		subcategoryp.clickOnSubCategory();
		subcategoryp.clickOnNewButton();
		subcategoryp.enterCategoryName();
		subcategoryp.enterSubCategoryName(category1);
		subcategoryp.clickOnImageUpload();
		subcategoryp.clickOnSaveButton();
		boolean isgreenalertdisplayed=subcategoryp.isGreenAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed);
		
		
		
	}
@Test(retryAnalyzer = retry.Retry.class)
public void verifyUserCanUpdateSubCategorySuccessfully() throws Exception {
		
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignInButton();
	
		//String name1="vegetables";
		
		FakerUtility fakerutility = new FakerUtility();
		String category1  = fakerutility.creatARandomFirstName();
		//String name1=fakerutility.creatARandomFirstName();
		
		SubcategoryPage1 subcategoryp=new SubcategoryPage1(driver);
		subcategoryp.clickOnSubCategory();
		subcategoryp.clickOnAction();
		subcategoryp.enterCategoryName();
		subcategoryp.enterSubCategoryName(category1);
		subcategoryp.clickOnImageUpload();
		subcategoryp.clickOnUpdateCategory();
		boolean isupdatebuttondisplayed=subcategoryp.isUpdateButtonDisplayed();
		Assert.assertTrue(isupdatebuttondisplayed);
	
		
	}

}
