package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProductSearchPage {
	
	WebDriver driver;
	public ProductSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	/*--------------------------------------------------------------------------------------*/

	@FindBy(how = How.XPATH, using = "//div/form/div/div/input[@type='text']")
	public WebElement enterProductNameElement;
	
	@FindBy(how = How.XPATH,using = "//button[@type='submit']")
	public WebElement clickSearchButtonElement;
	
	@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]")
	public WebElement productClickElement;
	
	@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
	public WebElement addToCartElement;
	
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'Place Order')]")
	public WebElement clickPlaceOrderElement;
	
	@FindBy(how = How.XPATH,using = "//button[contains(text(),'Deliver Here')]")
	public WebElement clickDeleverHereElement;
	
	@FindBy(how = How.XPATH,using = "//button[contains(text(),'CONTINUE')]")
	public WebElement clickContinueElement;
	
	@FindBy(how = How.XPATH,using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]")
	public WebElement checkElement;
	
	@FindBy(how = How.XPATH,using = "//span[contains(text(),'APPLE iPhone 8 Plus (PRODUCT)RED (Red, 256 GB)')]")
	public WebElement verifyProductElement;
	
	@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]")
	public WebElement verifyAddedElement;
	
	/*--------------------------------------------------------------------------------------*/

	@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/a[1]/div[2]/div[1]/div[1]")
	public WebElement hoverElectronicElement;
	
	@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/a[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/a[3]")
	public WebElement hoverCamAndAccElement;
	
	@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/a[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/a[2]")
	public WebElement clickDSLRElement;
	
	@FindBy(how = How.XPATH,using = "//h1[contains(text(),'DSLR & Mirrorless')]")
	public WebElement verifyTabElement;
	
	
	/*--------------------------------------------------------------------------------------*/

	public void enterProductName(String name) {
		enterProductNameElement.clear();
		enterProductNameElement.sendKeys(name);
	}
	public void clickSearchButton() {
		clickSearchButtonElement.submit();
	}
	public void clickProduct() throws Exception  {
		driver.getWindowHandle();
		productClickElement.click();
		driver.close();
		Thread.sleep(300);
		for(String tab:driver.getWindowHandles()) {
			driver.switchTo().window(tab);
		}
	}
	public void addToCart() {
		Actions actions=new Actions(driver);
		actions.moveToElement(addToCartElement).click().build().perform();
	}
	
	public void clickPlaceOrder() {
		clickPlaceOrderElement.click();
	}
	
	public void clickDeleverHere() {
		clickDeleverHereElement.click();
	}
	public void clickContinue() {
		clickContinueElement.click();
	}
	/*--------------------------------------------------------------------------------------*/
	public void hoverElectronic() {
		Actions actions=new Actions(driver);
		actions.moveToElement(hoverElectronicElement).perform();
		}
	public void hoverCamAndAcc() {
		Actions actions=new Actions(driver);
		actions.moveToElement(hoverCamAndAccElement).perform();
	}
	public void clickDSLR() {
		Actions actions=new Actions(driver);
		actions.moveToElement(clickDSLRElement).click().build().perform();
	}
	/*--------------------------------------------------------------------------------------*/

}
