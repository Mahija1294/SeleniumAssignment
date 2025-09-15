package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    private WebElement accountDeletedText;
    
    @FindBy(linkText = "Home")
	private WebElement homeIcon;
    
    public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
    
    public void clickDeleteAccountButton() {
	    click(deleteAccountButton);
	}

	public boolean isAccountDeletedVisible() {
	    return accountDeletedText.isDisplayed();
	}
	
	public WebElement getHomeIconLocator() {
		return homeIcon;
	}
}
