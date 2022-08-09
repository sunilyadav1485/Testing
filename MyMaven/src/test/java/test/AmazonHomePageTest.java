package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utils.Utility;
import base.Pojo;
import pom.AmaHomePageHeader;
import pom.LoginPage;
import pom.SignOutAmazon;

public class AmazonHomePageTest extends Pojo {

	private WebDriver driver;
	private AmaHomePageHeader homePageHeader;
	private LoginPage login;
	private int testId;
	private SignOutAmazon signOutAmazon;
	private SoftAssert softassert;

	@BeforeTest
	@Parameters("browser")
	public void lunchBrowser(String browser) {

		if (browser.equals("chrome")) {

			driver = openChromeBrowser();

		}

		if (browser.equals("edge")) {

			driver = openMicrosoftEdgeBrowser();

		}

		if (browser.equals("firefox")) {

			driver = openFireFoxBrowser();

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void clickOnSignUpOfHomepage() {

		login = new LoginPage(driver);

		login.clickOnSignUp();
		
		signOutAmazon = new SignOutAmazon(driver);
		
		homePageHeader = new AmaHomePageHeader(driver);

	}

	@BeforeMethod
	public void loginPage() throws EncryptedDocumentException, IOException {

		String mobileNumber = Utility.getDataFromDataSheet(driver, 4, 0);

		login.enterMobileNo(mobileNumber);
		
		login.clickOnContinueButton();
		
		String pass = Utility.getDataFromDataSheet(driver, 5, 0);
		
		login.enterPassword(pass);
		
		login.clickSignInButton();
		
		softassert = new SoftAssert();

	}

	@AfterMethod
	public void logOut(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			
			Utility.saveScreenShot(driver, testId);

		}

		signOutAmazon.moveToSignOutEle();
		
		signOutAmazon.clickOnSignOut();
	}

	@Test(priority = 1)
	public void toVerifyTodaysDealTab() {
		testId = 101;

		homePageHeader.clickOnTodaysDeal();
		
		String acturl=homePageHeader.clickOnHomeAndKitchen();
		
		String url = driver.getCurrentUrl();
		
		Assert.assertEquals(acturl, url);
		
		String title = driver.getTitle();
		
		softassert.assertEquals("Amazon.in - Today's Deals", title);

		softassert.assertAll();

	}

	@Test(priority = 2)
	public void toVerifyHomeAndKitchenTab() {
		testId = 102;
		
		homePageHeader.clickOnHomeAndKitchen();
		
		
		String acturl1=	homePageHeader.clickOnHomeAndKitchen();
	
		String url = driver.getCurrentUrl();
		
		
		Assert.assertEquals(acturl1, url);
		
		String title = driver.getTitle();
		
		softassert.assertEquals("Home Store: Buy Home & Kitchen products online at best prices in India - Amazon.in",
				title);
		softassert.assertAll();

	}

//	@Test(priority = 3)
//	public void toVerifyCoupensTab() {
//		homePageHeader.clickOnCoupens();
//	}
//
//	@Test(priority = 4)
//	public void toVerifyGiftCardTab() {
//		testId = 04;
//		homePageHeader.clickOnGiftCard();
//	}

//	@Test(priority = 5)
//	public void toVerifyAmazonPayTab() {
//
//		homePageHeader.clickOnAmazonPay();
//	}
//
//	@Test(priority = 6)
//	public void toVerifyPetSuppliesTab() {
//		homePageHeader.clickOnPetSupplies();
//	}

//	@Test(priority = 7)
//	public void toVerifyBuyAgainTab() {
//		homePageHeader.clickOnBuyAgain();
//	}

//	@Test(priority = 8)
//	public void toVerifySportFitnessOutdorTab() {
//		homePageHeader.clickOnSportFitnessOutdor();
//	}
//
//	@Test(priority = 9)
//	public void toVerifyKindleEbookTab() {
//		homePageHeader.clickOnKindleEbook();
//	}

//	@Test(priority = 10)
//	public void toVerifyBrowsingHistryTab() {
//		homePageHeader.clickOnBrowsingHistry();
//	}

//	@Test(priority = 11)
//	public void toVerifyHomeImprovementTab() {
//		homePageHeader.clickOnHomeImprovement();
//	}

	@AfterClass
	public void clearObject() {
		login = null;
		signOutAmazon = null;
		homePageHeader = null;

	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
		driver = null;
		System.gc();

	}

}
