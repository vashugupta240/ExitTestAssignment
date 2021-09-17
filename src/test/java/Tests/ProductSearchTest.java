package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;
import Pages.ProductSearchPage;
import Pages.TravelPage;
import Utils.CheckForTestExecution;

public class ProductSearchTest extends BaseTest {
	
	/*------------------searchProduct--------------------------------------------------------------------*/

	@Test(dataProvider = "searchAproduct",priority=1,groups= {"allproduct"} )
	public void searchProduct(String username,String password,String productName,String checkExecution,String testName) {
		log.info("toCheckForTestExecution:"+testName);
		CheckForTestExecution.toCheckForTestExecution(checkExecution);
		log.info("Test case start:"+testName);
		extentTest = extent.startTest("searching a product:"+productName);
		ProductSearchPage searchPage=new ProductSearchPage(driver);
		LoginPage login=new LoginPage(driver);
		login.enterEmailId(username);
		log.info("username entered:"+username);
		login.enterPassword(password);
		log.info("password entered:"+password);
		login.clickLogin();
		log.info("login done");
		searchPage.enterProductName(productName);
		log.info("product Name entered:"+productName);
		searchPage.clickSearchButton();
		log.info("clicked on search");
		Assert.assertTrue(searchPage.checkElement.getText().equalsIgnoreCase(productName));
		log.info("producted searched: "+productName);
		extentTest.log(LogStatus.PASS, "product search found:"+productName);
		extent.endTest(extentTest);
		log.info("Test case end:"+testName);
	}
	
	/*-------------------buyProduct-------------------------------------------------------------------*/

	
	@Test(dataProvider = "buyAProduct",priority=2,groups= {"allproduct"} )
	public void buyProduct(String username,String password,String productName,String checkExecution,String testName) throws Exception {
		log.info("toCheckForTestExecution:"+testName);
		CheckForTestExecution.toCheckForTestExecution(checkExecution);
		log.info("Test case start:"+testName);
		extentTest = extent.startTest("Buying a product:"+productName);
		ProductSearchPage searchPage=new ProductSearchPage(driver);
		LoginPage login=new LoginPage(driver);
		login.enterEmailId(username);
		log.info("username entered:"+username);
		login.enterPassword(password);
		log.info("password entered:"+password);
		login.clickLogin();
		log.info("login done");
		searchPage.enterProductName(productName);
		log.info("product Name entered:"+productName);
		searchPage.clickSearchButton();
		log.info("clicked on search");
		searchPage.clickProduct();
		log.info("clicked on product");
		String prodString=searchPage.verifyProductElement.getText();
		searchPage.addToCart();
		log.info("clicked to add to cart");
		String prodString2=searchPage.verifyAddedElement.getText();
		Assert.assertEquals(prodString, prodString2);
		searchPage.clickPlaceOrder();
		log.info("clicked on place order");
		searchPage.clickDeleverHere();
		log.info("clicked on deliver here");
		searchPage.clickContinue();
		log.info("clicked on continue");
		extentTest.log(LogStatus.PASS, "purchase successfull ");
		extent.endTest(extentTest);
		log.info("Test case end:"+testName);		
	}
	/*--------------tabHover------------------------------------------------------------------------*/

	@Test(priority=3,groups= {"allproduct"},enabled = true)
	public void tabHover() {
		String testName="tab Functionality";
		log.info("test case start:"+testName);
		extentTest = extent.startTest("checking quicks tabs:"+testName);
		ProductSearchPage product=new ProductSearchPage(driver);
		TravelPage travelPage=new TravelPage(driver);
		travelPage.closeLogin();
		product.hoverElectronic();
		log.info("hover over the electronic tab");
		product.hoverCamAndAcc();
		log.info("hover over the camera tab");
		product.clickDSLR();
		log.info("click on dslr");
		Assert.assertTrue(product.verifyTabElement.getText().equalsIgnoreCase("DSLR & Mirrorless"));
		extentTest.log(LogStatus.PASS, "camera search displayed");
		extent.endTest(extentTest);
		log.info("Testcase end:"+testName);
	}
}
