package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	WebDriver driver;

	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'My Profile')]")
	public WebElement clickProfileElement;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Manage Addresses')]")
	public WebElement clickManageAddressElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]"
			+ "/div[1]/div[1]/div[1]/div[1]")
	public WebElement clickAddNewAddressElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")
	public WebElement enterNameElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")
	public WebElement enterMobileNumberElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]")
	public WebElement enterPincodeElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/input[1]")
	public WebElement enterLocalityElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/textarea[1]")
	public WebElement enterAddressElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/div[2]/select[1]")
	public WebElement enterStateElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/label[1]/div[1]")
	public WebElement clickRadioButtonElement;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save')]")
	public WebElement clickSaveElement;
	/*--------------*/
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/div[2]/div[1]/div[1]/div[1]/div[1]/img[1]")
	public WebElement clickOnDotElement;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]"
			+ "/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]")
	public WebElement clickDeleteElement;
	

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'YES, DELETE')]")
	public WebElement clickYesElement;
	
	public void clickProfile() {
		Actions action = new Actions(driver);
		action.moveToElement(clickProfileElement);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'My Profile')]")));
		action.click().build().perform();
	}

	public void clickManageAddress() {
		clickManageAddressElement.click();
	}

	public void clickAddNewAddress() {
		clickAddNewAddressElement.click();
	}

	public void enterName(String nameText) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		driver.manage().timeouts();
		enterNameElement.sendKeys(nameText);
	}

	public void enterMobileNumber(String mobileNumber) {
		enterMobileNumberElement.sendKeys(mobileNumber);
	}

	public void enterPincode(String pinCode) {
		enterPincodeElement.sendKeys(pinCode);
	}

	public void enterLocality(String Locality) {
		enterLocalityElement.sendKeys(Locality);
	}

	public void enterAddress(String address) {
		enterAddressElement.sendKeys(address);
	}

	public void enterState(String state) {
		enterStateElement.sendKeys(state);
	}

	public void clickRadioButton() {
		clickRadioButtonElement.click();
	}

	public void clickSave() {
		clickSaveElement.click();
	}
	/*-------------------------------*/
	public void clickOnDot() {
		Actions action = new Actions(driver);
		action.moveToElement(clickOnDotElement).perform();
	}
	public void clickDelete() {
		clickDeleteElement.click();

	}
	public void clickYes() {
		clickYesElement.click();

	}
}

