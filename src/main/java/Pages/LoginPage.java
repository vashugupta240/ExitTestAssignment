package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//form/div/input[@type='text']")
	public WebElement enterEmailElement;
	
	@FindBy(how = How.XPATH, using = "//form/div/input[@type='password']")
	public WebElement enterPasswordElement;

	@FindBy(how = How.XPATH, using = "//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
	public WebElement clickLoginElement;
	
	@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/span[3]/span[1]")
	public WebElement verifyLogin;
	@FindBy(how = How.XPATH,using = "//div[contains(text(),'Tushar')]")
	public WebElement verifyLogin1;
	
	
	public void enterEmailId(String emailId) {
		enterEmailElement.clear();
		enterEmailElement.sendKeys(emailId);
	}
	public void enterPassword(String password) {
		enterPasswordElement.clear();
		enterPasswordElement.sendKeys(password);		
	}
	public void clickLogin() {
		clickLoginElement.click();
	}
	public String verify() {
		String verifyString= verifyLogin1.getText();
		return verifyString;
	}
}
