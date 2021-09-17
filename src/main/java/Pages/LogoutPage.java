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

public class LogoutPage {
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement clickElement;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Logout')]")
	public WebElement clickLogoutElement;
	
	public void click() {
		Actions action=new Actions(driver);
		action.moveToElement(clickElement).perform();
		
	}
	public void clickLogout() {
		Actions action=new Actions(driver);
		action.moveToElement(clickLogoutElement);
	        WebDriverWait wait = new WebDriverWait(driver,10);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Logout')]")));
	        action.click().build().perform();
	}
}
