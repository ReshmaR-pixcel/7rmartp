package testscript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages1.LoginPage;
import pages1.LogoutPage;
import pages1.SubcategoryPage;
import utilities1.ExcelUtility;
import utilities1.FakerUtility;

public class SubcategoryTest extends Base {
	public LogoutPage logoutpage;
	public SubcategoryPage subcategorypage;
	
	@Test( retryAnalyzer = retry.Retry.class, description="verify if user is able to add subcategory details")
	public void verifyUserCanAddCategorySuccessfully() throws Exception {
		
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");
		
		//String name1="plant";
		FakerUtility fakerutility = new FakerUtility();
		String category1  = fakerutility.creatARandomFirstName();
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.enterUsername(username).enterPassword(password);
		
		logoutpage=loginpage.clickOnSignInButton();
		subcategorypage=logoutpage.subCategoryMoreInfo();
		subcategorypage.clickOnNewButton().enterCategoryName().enterSubCategoryName(category1).clickOnImageUpload().clickOnSaveButton();
		//SubcategoryPage subcategoryp=new SubcategoryPage(driver);
		
		boolean isgreenalertdisplayed=subcategorypage.isGreenAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed);
		
		
		
	}
@Test(retryAnalyzer = retry.Retry.class,description="verify if user is able to update subcategory details")
public void verifyUserCanUpdateSubCategorySuccessfully() throws Exception {
		
		
		String username = ExcelUtility.getStringData(1, 0, "Login_Page");
		String password = ExcelUtility.getStringData(1, 1, "Login_Page");

		
		FakerUtility fakerutility = new FakerUtility();
		String editcategory = fakerutility.creatARandomFirstName();
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
				
				logoutpage=loginpage.clickOnSignInButton();
				subcategorypage=logoutpage.subCategoryMoreInfo();
				subcategorypage.clickOnAction().clickOnUpdateCategory().updateSubCategory(editcategory).updateImage().updateSave();
		
		//SubcategoryPage subcategoryp=new SubcategoryPage(driver);
		
	
		boolean isgreenalertdisplayed=subcategorypage.isUpdateAlertDisplyed();
		Assert.assertTrue(isgreenalertdisplayed);
	
		
	}

}
