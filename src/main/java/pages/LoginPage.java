package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signUpLoginButton;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailAddressLocator;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordLocator;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedInAsText;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    private WebElement accountDeletedText;
    
    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	private WebElement incorrectEmailText;
    
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logOutButton;
	
//	By emailAddressLocator = By.xpath("//input[@data-qa='login-email']");
//	By passwordLocator = By.xpath("//input[@data-qa='login-password']");
//	By loginButton = By.xpath("//button[@data-qa='login-button']");
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignUpLoginButton()
	{
		click(signUpLoginButton);
	}
	
	public void enterUsername(String emailAddress)
	{
		type(emailAddressLocator, emailAddress);	
	}
	
	public void enterPassword(String password)
	{
		type(passwordLocator, password);	
	}
	
	public void clickLoginButton()
	{
		click(loginButton);
	}
	
	public String getLoginTitle()
	{
		return driver.getTitle();
	}
    
	public boolean isLoggedInAsVisible() {
	    return loggedInAsText.isDisplayed();
	}
	
	public WebElement getloggedInAsText() {
		return loggedInAsText;
	}

	public void clickDeleteAccountButton() {
	    click(deleteAccountButton);
	}

	public boolean isAccountDeletedVisible() {
	    return accountDeletedText.isDisplayed();
	}
    
	public WebElement getIncorrectEmailText() {
	    return incorrectEmailText;
	}
	
	public void clicklogOutButton() {
	    click(logOutButton);
	}

	
	
	//All the locators of that page
	//Executions on those locators
	
}
