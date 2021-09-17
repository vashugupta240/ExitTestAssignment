package Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;
import Pages.LogoutPage;
import Utils.CheckForTestExecution;

public class LogoutTest extends BaseTest {
@Test(dataProvider = "loginForAllMethod",priority=1,groups= {"login"})
	public void logout(String username,String password,String checkExecution,String testName) {
	log.info("toCheckForTestExecution:"+testName);
	CheckForTestExecution.toCheckForTestExecution(checkExecution);
	log.info("Test case Start:"+testName);
	extentTest = extent.startTest("logout functionality");
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterEmailId(username);
	log.info("username entered:"+username);
	loginPage.enterPassword(password);
	log.info("password entered:"+password);
	loginPage.clickLogin();
	log.info("login done");
	LogoutPage logout=new LogoutPage(driver);
	logout.click();
	log.info("clicked on profile");
	logout.clickLogout();
	log.info("logout done");
	extentTest.log(LogStatus.PASS, "logout is sucessful");
	extent.endTest(extentTest);
	log.info("test case end:"+testName);
}
}
