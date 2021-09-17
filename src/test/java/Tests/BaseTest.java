package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.ExcelDataProvider;
import Utils.Screenshots;

public class BaseTest extends ExcelDataProvider{
	protected static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	static File file = new File(".\\Resources\\config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();
	public static Logger log=LogManager.getLogger(BaseTest.class);

	
	/*------------INITIALIZING FILE----------------------------------------*/
	static {
		try {
			fis = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	/*------------EXTENT REPORT----------------------------------------*/

	@BeforeSuite(groups= {"login","address","extratest","allproduct","travel"})
	public void setExtend() {
		extent = new ExtentReports(".\\Reports\\ExtentReport.html");
	}

	@AfterSuite(groups= {"login","address","extratest","allproduct","travel"})
	public void endReport() {
		extent.flush();
		extent.close();
	}
	/*------------SCREENSHOT METHOD----------------------------------------*/

	@AfterMethod(groups= {"login","address","extratest","allproduct","travel"})
	public void attachScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = Screenshots.captureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case Passes successfilly");
		}
	}
/*-----INITIALIZING THE WEBDRIVER (HEADLESS AND NON HEADLESS GOTO CONFIG FILE TO CHANGE THE INPUT)------*/

	@BeforeMethod(groups= {"login","address","extratest","allproduct","travel"})
	public static void intinalizeWebdriver() {
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{			System.out.println("chech");

			/*------------HEADLESS PART FOR CHROME----------------------------------------*/

			if (prop.getProperty("headlessmode").equalsIgnoreCase("true"))
			{
				System.setProperty(prop.getProperty("chromeProperty"), prop.getProperty("ChromeDriverPath"));
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			
			/*------------NON HEADLESS----------------------------------------*/

			else
			{				
				System.setProperty(prop.getProperty("chromeProperty"), prop.getProperty("ChromeDriverPath"));
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			/*------------HEADLESS MODE FOR FIREFOX----------------------------------------*/

			if(prop.getProperty("headlessmode").equalsIgnoreCase("true"))
			{
				System.setProperty(prop.getProperty("firefoxProperty"), prop.getProperty("firefoxDriverPath"));
				FirefoxOptions options=new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			
			/*------------NON HEADLESS----------------------------------------*/

			else
			{
				System.setProperty(prop.getProperty("firefoxProperty"), prop.getProperty("firefoxDriverPath"));
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().maximize();				
			}
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("ie"))
		{
			if (prop.getProperty("headlessmode").equalsIgnoreCase("true")) 
			{
				System.setProperty(prop.getProperty("internetExplolerProperty"), prop.getProperty("internetExplolerPath"));
				InternetExplorerOptions options=new InternetExplorerOptions();
//				options.addArguments("--headless");
				driver = new InternetExplorerDriver(options);
			}
			else 
			{
				System.setProperty(prop.getProperty("internetExplolerProperty"), prop.getProperty("internetExplolerPath"));
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();	
			}
	}
		else
		{
			log.error("PLEASE PROVIDE THE VALID INPUT FOR THE BROSWER");
			System.out.println("PLEASE PROVIDE THE VALID INPUT FOR THE BROSWER");
		}
		
	}
	
	/*------------OPENING BROWSER----------------------------------------*/

	@BeforeMethod(groups= {"login","address","extratest","allproduct","travel"})
	public static void openBrowser() {
		log.info("Opening browser");
		driver.get(prop.getProperty("url"));
	}
	/*------------CLOSING BROWSER----------------------------------------*/

	@AfterMethod(groups= {"login","address","extratest","allproduct","travel"})
	public static void closeBrowser() {
		log.info("closing browser");
		driver.close();
	}
	
	
}