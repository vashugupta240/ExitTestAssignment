package Tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.AddressPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Utils.CheckForTestExecution;

public class AddressTest extends BaseTest {
	@Test(dataProvider = "addressTest",priority=1,groups= {"address"})
	public void addAddress(String username,String password,String name,String locality,String address,String state,
			String checkExecution,String testName) {
		log.info("toCheckForTestExecution:"+testName);
		CheckForTestExecution.toCheckForTestExecution(checkExecution);
		log.info("Test start:"+testName);
		extentTest = extent.startTest("checking the add address functionality");
		LogoutPage logout=new LogoutPage(driver);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmailId(username);
		log.info("username entered:"+username);
		loginPage.enterPassword(password);
		log.info("password entered:"+password);
		loginPage.clickLogin();
		log.info("login done");
		logout.click();
		AddressPage addressPage=new AddressPage(driver);
		addressPage.clickProfile();
		log.info("clicked on profile");
		addressPage.clickManageAddress();
		log.info("clicked on manage address");
		addressPage.clickAddNewAddress();
		log.info("clickAddNewAddress");
		addressPage.enterName(name);
		log.info("name entered:"+name);
		addressPage.enterMobileNumber("8601091361");
		log.info("mobile number entered");
		addressPage.enterPincode("201310");
		log.info("pincode entered");
		addressPage.enterLocality(locality);
		log.info("locality name entered:"+locality);
		addressPage.enterAddress(address);
		log.info("address entered:"+address);
		addressPage.enterState(state);
		log.info("state entered:"+username);
		addressPage.clickRadioButton();
		log.info("button clicked");
		addressPage.clickSave();
		log.info("Address saved");
		extentTest.log(LogStatus.PASS, testName+" test case pass");
		extent.endTest(extentTest);
		log.info("Test end:"+testName);	
	}

	
	@Test(priority=2,groups= {"address"},enabled = true)
	public void deleteAddress() {
		String deleteString="delete Address testcase";
		extentTest = extent.startTest("deleting the address");
		LogoutPage logout=new LogoutPage(driver);
		log.info("Test execution start:"+deleteString);
		LoginPage login=new LoginPage(driver);
		login.enterEmailId(prop.getProperty("username"));
		log.info("username entered:"+prop.getProperty("username"));
		login.enterPassword(prop.getProperty("password"));
		log.info("password entered:"+prop.getProperty("password"));
		login.clickLogin();
		log.info("Login done");
		logout.click();
		AddressPage addressPage=new AddressPage(driver);
		addressPage.clickProfile();
		log.info("click on profile");
		addressPage.clickManageAddress();
		log.info("clicked on manage address");
		addressPage.clickOnDot();
		log.info("clicked on dots");
		addressPage.clickDelete();
		log.info("click on delete");
		addressPage.clickYes();
		log.info("click on yes");
		extentTest.log(LogStatus.PASS, deleteString+" passed");
		extent.endTest(extentTest);
		log.info("Test case end:"+deleteString);
	}
}
