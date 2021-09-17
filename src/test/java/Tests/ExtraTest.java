package Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.ExtraPage;
import Pages.LoginPage;
import Pages.LogoutPage;

public class ExtraTest extends BaseTest{
	
	/*----------------topOffer---------------------------------------------------------*/

	@Test(priority=1,groups= {"extratest"},enabled = true)
	public	void topOffer() {
		String testName="topOffer";
		extentTest = extent.startTest("checking the top offer page");
		log.info("Test Case start:"+testName);
		ExtraPage extra=new ExtraPage(driver);
		extra.close();
		extra.topOffer();
		log.info("click on top offer link");
		extra.clickViewAll();
		log.info("clicked on view all deal");
		extra.gotoBack();
		driver.get(prop.getProperty("url"));
		extra.grocery();
		extentTest.log(LogStatus.PASS, "top offer page pass:"+testName);
		extent.endTest(extentTest);
		log.info("Test Case end:"+testName);
	}
	
	/*----------------superCoin---------------------------------------------------------*/

	@Test(priority=2,groups= {"extratest"},enabled = true)
	public void superCoin() {
		String testName="super coin";
		log.info("Test Case start:"+testName);
		extentTest = extent.startTest("checking super coin");
		ExtraPage extra=new ExtraPage(driver);
		LoginPage loginPage=new LoginPage(driver);
		LogoutPage logoutPage=new LogoutPage(driver);
		loginPage.enterEmailId(prop.getProperty("username"));
		log.info("Test Case start:"+prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		log.info("Test Case start:"+prop.getProperty("password"));
		loginPage.clickLogin();
		log.info("click on login");
		logoutPage.click();
		extra.clickSuperCoin();
		log.info("click on super coin");
		extra.clickCoinActivity();
		log.info("clicked on the coin activity");
		extentTest.log(LogStatus.PASS, "checked super coin testcase");
		extent.endTest(extentTest);
		log.info("Test Case end:"+testName);
	}
	
	/*--------------contact-----------------------------------------------------------*/
	
	@Test(priority=3,groups= {"extratest"},enabled = true)
	public void contact() {
		String testName="Contact page";
		log.info("Test Case start:"+testName);
		extentTest = extent.startTest("contact page");
		ExtraPage extra=new ExtraPage(driver);
		extra.close();
		extra.clickContact();
		log.info("clicking on contact us link");
		extra.clickContactMore();
		log.info("click on more help option");
		extentTest.log(LogStatus.PASS, "contact help pages displayed");
		extent.endTest(extentTest);
		log.info("Test Case end:"+testName);
	}
	
	/*---------------securityAndPrivacy----------------------------------------------------------*/
	
	@Test(priority=4,groups= {"extratest"},enabled = true)
	public void securityAndPrivacy() {
		String testName="securityAndPrivacy";
		log.info("Test Case start:"+testName);
		extentTest = extent.startTest("securityAndPrivacy");
		ExtraPage extra=new ExtraPage(driver);
		extra.close();
		extra.clickSecurity();
		log.info("clicking on security And Privacy ");
		extentTest.log(LogStatus.PASS, "securityAndPrivacy test case");
		extent.endTest(extentTest);
		log.info("Test Case end:"+testName);
	}
	
	/*-------------------storyclick------------------------------------------------------*/

	@Test(priority=5,groups= {"extratest"},enabled = true)
	public void storyclick() {
		String testName="story test case";
		log.info("Test Case start:"+testName);
		extentTest = extent.startTest(testName);
		ExtraPage extra=new ExtraPage(driver);
		extra.close();
		log.info("closing login popup");
		extra.clickStory();
		log.info("clicking on story ");
		extentTest.log(LogStatus.PASS, testName);
		extent.endTest(extentTest);
		log.info("Test Case end:"+testName);
	}
	
	/*------------------signupByHover-------------------------------------------------------*/

	@Test(priority=6,groups= {"extratest"},enabled = true)
	public void signupByHover() {
		String testName="signupByHover";
		log.info("Test Case start:"+testName);
		extentTest = extent.startTest(testName);
		ExtraPage extra=new ExtraPage(driver);
		extra.close();
		log.info("closing login popup");
		extra.hoverOnlogin();
		log.info("hovwering on login link");
		extra.ClickOnSignup();
		log.info("clicked on signup");
		log.info("Assert part");
		extentTest.log(LogStatus.PASS, testName);
		extent.endTest(extentTest);
		log.info("Test Case end:"+testName);
	}
	
	/*-----------------------flipkartFacebook--------------------------------------------------*/

	@Test(priority=7,groups= {"extratest"},enabled = true)
	public void flipkartFacebook() {
		String testName="checking flipkart facebook page";
		log.info("Test Case start:"+testName);
		extentTest = extent.startTest(testName);
		ExtraPage extra=new ExtraPage(driver);
		extra.close();
		log.info("closing login popup");
		extra.Checkingfacebook();
		log.info("clicked on facebook");
		extentTest.log(LogStatus.PASS, testName);
		extent.endTest(extentTest);
		log.info("Test Case end:"+testName);
	}
}
	

