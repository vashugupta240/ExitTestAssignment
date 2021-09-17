package Tests;

import org.testng.annotations.Test;
import org.junit.Assert;
import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;
import Utils.CheckForTestExecution;

public class LoginTest extends BaseTest{

	/*------------------validLogin--------------------------------------------------------------------*/

	@Test(dataProvider ="ValidLogin",priority=1,groups= {"login"} )
	public void validLogin(String username ,String password,String checkExecution,String testName) 
	{
		log.info("toCheckForTestExecution:"+testName);
		CheckForTestExecution.toCheckForTestExecution(checkExecution);
		extentTest = extent.startTest("Verify the valid login");
		log.info("Test execution start");
		LoginPage login=new LoginPage(driver);
		login.enterEmailId(username);
		log.info("username entered:"+username);
		login.enterPassword(password);
		log.info("password entered:"+password);
		login.clickLogin();
		log.info("Login done");
		Assert.assertTrue(login.verifyLogin1.getText().equalsIgnoreCase("tushar"));
		log.info("Assert Done");
		extentTest.log(LogStatus.PASS, "valid login is sucessful");
		extent.endTest(extentTest);
		log.info("testcase done: "+testName);
	}
	
	/*------------------invalidLogin--------------------------------------------------------------------*/

	@Test(dataProvider = "invalidLogin",priority=2,groups= {"login"})
	public void invalidLogin(String username ,String password,String checkExecution,String testName) {
		log.info("toCheckForTestExecution:"+testName);
		CheckForTestExecution.toCheckForTestExecution(checkExecution);
		log.info("Test execution start:"+testName);
		extentTest = extent.startTest("Verify the invalid login");
		LoginPage login=new LoginPage(driver);
		login.enterEmailId(username);
		log.info("username entered:"+username);
		login.enterPassword(password);
		log.info("password entered:"+password);
		login.clickLogin();
		log.info("Login failed");
		Assert.assertNull(login.verifyLogin.getText());
		extentTest.log(LogStatus.PASS, testName+" Test Case for invalid condition");
		extent.endTest(extentTest);
		log.info("testcase done:"+testName);
	}
	
	/*------------------nullValueLogin--------------------------------------------------------------------*/

	@Test(priority=3,groups= {"login"},enabled = true)
	public void nullValueLogin() {
		String testName="Null value login";
		log.info("Test execution start:"+testName);
		extentTest = extent.startTest("Verify the invalid login");
		LoginPage login=new LoginPage(driver);
		log.info("click on login without any value");
		login.clickLogin();
		log.info("Login failed");
		Assert.assertNull(login.verifyLogin.getText());
		extentTest.log(LogStatus.PASS, testName+" Test Case for invalid condition");
		extent.endTest(extentTest);
		log.info("testcase done:"+testName);
	}
}
