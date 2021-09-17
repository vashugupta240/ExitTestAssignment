package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TravelPage {
	WebDriver driver;

	public TravelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]")
	public WebElement closeLoginElement;
	
	@FindBy(how=How.XPATH, using= "//div[contains(text(),'Travel')]")
    public WebElement clickTravelElement;
   
    @FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]")
    public WebElement onewayElement;
   
    @FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[2]/div[1]")
    public WebElement twowayElement;
   
    @FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]"
            + "/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement fromdropElement;
   
    @FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"
            + "/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/span[1]")
    public WebElement clickfromdropElement;
   
    @FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]"
            + "/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]")
    public WebElement todropElement;
   
    @FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]"
            + "/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]")
    public WebElement clicktodropElement;
   
    @FindBy(how=How.XPATH, using= "//tbody/tr[5]/td[4]/div[1]/button[1]")
    public WebElement departDateElement;
   
    @FindBy(how=How.XPATH, using= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]"
            + "/form[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[2]/td[1]/div[1]/button[1]")
    public WebElement returnDateElement;
   
    @FindBy(how=How.XPATH, using= "//button[contains(text(),'Done')]")
    public WebElement travelClassElement;
   
    @FindBy(how=How.XPATH, using= "//span[contains(text(),'SEARCH')]")
    public WebElement clickSearchElement;
   
    @FindBy(how=How.XPATH, using= "//div[contains(text(),'27 Oct, Wed')]")
    public WebElement v_oneway;
   
    @FindBy(how=How.XPATH, using= "//span[contains(text(),'27 Oct, Wed')]")
    public WebElement v_twoway1;
   
    @FindBy(how=How.XPATH, using= "//span[contains(text(),'07 Nov, Sun')]")
    public WebElement v_twoway2;
       
   
    /**********Page Actions for Travel Page**********/
   
    public void closeLogin() {
		closeLoginElement.click();
	}
    /*****this is used to click Travel*****/
    public void ClickTravel() {
    	clickTravelElement.click();
    }
   
    /*****this is used to click Two Way*****/
    public void ClickTwoWay() {
        twowayElement.click();
    }
   
    /*****this is used to click One Way*****/
    public void ClickOneWay() {
        onewayElement.click();
    }
   
    /*****this is used to Select From*****/
    public void SelectFrom() {
        fromdropElement.click();
        clickfromdropElement.click();
    }
   
    /*****this is used to Select To*****/
    public void SelectTo() {
        todropElement.click();
        clicktodropElement.click();
    }
   
    /*****this is used to Depart On Date*****/
    public void DepartOnDate() {
        departDateElement.click();
    }
   
    /*****this is used to Return On Date*****/
    public void ReturnDate() {
        returnDateElement.click();
    }
   
    /*****this is used to select Travellers*****/
    public void selectTravelClass() {
        travelClassElement.click();
    }
   
    /*****this is used to click search*****/
    public void ClickSearch() {
        clickSearchElement.click();
    }
}
