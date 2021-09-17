package Pages;

import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtraPage {
	WebDriver driver;

	public ExtraPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*-------------------------------------------------------------------------*/
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]")
	public WebElement closeElement;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Top Offers')]")
	public WebElement topOfferElement;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Grocery')]")
	public WebElement clickViewAllElement;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]")
	public WebElement clickGroceryElement;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[2]"
			+ "/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/button[1]")
	public WebElement clickLocationElement;

	/*-------------------------------------------------------------------------*/
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'SuperCoin Zone')]")
	public WebElement clickSuperCoinElement;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]"
			+ "/a[1]/div[1]/div[1]/img[2]")
	public WebElement clickCoinActivityElement;

	/*-------------------------------------------------------------------------*/

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Contact Us')]")
	public WebElement clickContactElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]")
	public WebElement clickContactMoreElement;

	/*-------------------------------------------------------------------------*/
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Security')]")
	public WebElement clickSecurityElement;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/footer[1]/div[1]/div[2]/div[1]/div[3]/a[4]")
	public WebElement clickPrivacyElement;

	/*-------------------------------------------------------------------------*/

	@FindBy(how = How.LINK_TEXT, using = "Flipkart Stories")
	public WebElement story;

	/*---------------------signup----------------------------------------------------*/
	@FindBy(how = How.LINK_TEXT, using = "Login")
	public WebElement login;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, '_3wJI0x')]")
	public WebElement signup;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),\"Looks like you're new here!\")]")
	public WebElement v_login;

	/*----------------------checking facebook---------------------------------------------------*/

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Facebook')]")
	public WebElement clickFacebookElement;
	
	/*----------------offer page---------------------------------------------------------*/

	public void close() {
		closeElement.click();
	}

	public void topOffer() {

		topOfferElement.click();
	}

	public void clickViewAll() {
		clickViewAllElement.click();
	}

	public void gotoBack() {
		driver.navigate().back();
	}

	public void grocery() {
		clickGroceryElement.click();
		clickLocationElement.click();
	}

	/*------------------super coin-------------------------------------------------------*/
	public void clickSuperCoin() {
		Actions action = new Actions(driver);
		action.moveToElement(clickSuperCoinElement);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'SuperCoin Zone')]")));
		action.click().build().perform();
	}

	public void clickCoinActivity() {
		clickCoinActivityElement.click();
	}

	/*----------------contact page-----------------------------------------------------*/
	public void clickContact() {
		clickContactElement.click();
	}

	public void clickContactMore() {
		clickContactMoreElement.click();
	}

	/*--------------security page------------------------------------------------*/
	public void clickSecurity() {
		clickSecurityElement.click();
		clickPrivacyElement.click();
	}

	/*-----------------checking story--------------------------------------------------------*/

	public void clickStory() {
		Actions actions = new Actions(driver);
		actions.moveToElement(story).click().build().perform();
	}

	/*---------------hover login Menu and opening signup----------------------------------------------------------*/
	public void hoverOnlogin() {
		Actions act = new Actions(driver);
		act.moveToElement(login).perform();
	}

	public void ClickOnSignup() {
		Actions act = new Actions(driver);
		act.moveToElement(signup).click().build().perform();
	}

	
	
	/*-------------checking faceook------------------------------------------------*/
	public void Checkingfacebook() {
		clickFacebookElement.click();
	}
}
