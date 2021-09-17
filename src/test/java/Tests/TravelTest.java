package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.TravelPage;

public class TravelTest extends BaseTest {
	@Test(priority=1,groups= {"travel"},enabled = true)
	public void TravelOneWay() {
		String testName="one way travel";
		extentTest = extent.startTest(testName+" test case");
		log.info("Test Case start:"+testName);
		TravelPage travelPage=new TravelPage(driver);
		travelPage.closeLogin();
		travelPage.ClickTravel();
		log.info("clicked on travel link");
		travelPage.ClickOneWay();
		log.info("clicked on oneway radio button");
		travelPage.SelectFrom();
		log.info("select the origin");
		travelPage.SelectTo();
		log.info("select departure");
		travelPage.DepartOnDate();
		String dateString=travelPage.v_oneway.getText();
		log.info("select depart date");
		travelPage.selectTravelClass();
		log.info("select class");
		travelPage.ClickSearch();
		log.info("click on search");
		String comString=travelPage.v_twoway1.getText();
		Assert.assertEquals(dateString, comString);
		extentTest.log(LogStatus.PASS, "travel detail "+testName+ " test case");
		extent.endTest(extentTest);
		log.info("testcase done:"+testName);
	}
	
	@Test(priority=2,groups= {"travel"},enabled = true)
	public void TravelTwoWay() {
		String testName="two way travel";
		extentTest = extent.startTest(testName+" test case");
		TravelPage travelPage=new TravelPage(driver);
		log.info("Test Case start:"+testName);
		travelPage.closeLogin();
		travelPage.ClickTravel();
		log.info("clicked on travel link");
		travelPage.ClickTwoWay();
		log.info("clicked on twoway radio button");
		travelPage.SelectFrom();
		log.info("select the origin");
		travelPage.SelectTo();
		log.info("select departure");
		travelPage.DepartOnDate();
		log.info("select depart date");
		travelPage.ReturnDate();
		log.info("select return date");
		travelPage.selectTravelClass();
		log.info("select class");
		travelPage.ClickSearch();
		log.info("click on search");
		extentTest.log(LogStatus.PASS, "travel detail for "+testName+" test case");
		extent.endTest(extentTest);
		log.info("testcase done:"+testName);
	}
}
