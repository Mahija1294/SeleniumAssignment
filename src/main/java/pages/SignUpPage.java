package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Home")
	private WebElement homeIcon;
	
	@FindBy(linkText = "Signup / Login")
	private WebElement signUpIcon;
	
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement newUserSignUpText;
	
	@FindBy(xpath = "//input[@data-qa='signup-name']")
	private WebElement signUpName;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement signUpEmailAddress;
	
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	private WebElement signUpButton;
	
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement enterAccountInformation;
	
	@FindBy(xpath = "//input[@name='title' and @value='Mrs']")
	private WebElement titleMrsRadio;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//select[@name='days']")
    private WebElement dayDropdown;

    @FindBy(xpath = "//select[@name='months']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[@name='years']")
    private WebElement yearDropdown;
    
    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//input[@name='optin']")
    private WebElement optinCheckbox;

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='company']")
    private WebElement companyInput;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address1Input;

    @FindBy(xpath = "//input[@name='address2']")
    private WebElement address2Input;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//input[@name='state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@name='zipcode']")
    private WebElement zipcodeInput;

    @FindBy(xpath = "//input[@name='mobile_number']")
    private WebElement mobileNumberInput;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;
    
    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountCreatedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedInAsText;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    private WebElement accountDeletedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement accountDeletedContinueButton;
    
    @FindBy(xpath = "//p[text()='Email Address already exist!']")
	private WebElement incorrectEmail;
	
	public SignUpPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHomeIconLocator() {
		return homeIcon;
	}
	
	public void clickSignUpLink()
	{
		click(signUpIcon);
	}
	
	public WebElement getNewUserSignUpTextLocator() {
		return newUserSignUpText;
	}
	
	public void enterSignUpUserName(String signUpUserName)
	{
		type(signUpName, signUpUserName);	
	}
	
	public void enterSignUpEmailAddress(String emailAddress)
	{
		type(signUpEmailAddress, emailAddress);	
	}
	
	public void clickSignUpButton() {
		click(signUpButton);
	}
	
	public boolean isEnterAccountInformationVisible() {
	    return enterAccountInformation.isDisplayed();
	}
	
	public WebElement getEnterAccountInformationLocator() {
	    return enterAccountInformation;
	}
	public WebElement getdayDropdown() {
		return dayDropdown;
	}
	 public void selectDateOfBirth(String day, String month, String year) {
	        Select selectDay = new Select(dayDropdown);
	        selectDay.selectByVisibleText(day);

	        Select selectMonth = new Select(monthDropdown);
	        selectMonth.selectByVisibleText(month);

	        Select selectYear = new Select(yearDropdown);
	        selectYear.selectByVisibleText(year);
	 }       
	
	public void selectTitleMrs() {
		    click(titleMrsRadio);
		}

	public void enterName(String name) {
	    type(nameInput, name);
	}

	public void enterEmail(String email) {
	    type(emailInput, email);
	}

	public void enterPassword(String password) {
	    type(passwordInput, password);
	}
	
	public void selectNewsletterCheckbox() {
	        click(newsletterCheckbox);
	}

	public void selectOptinCheckbox() {
	        click(optinCheckbox);
	}

	public void enterFirstName(String firstName) {
	    type(firstNameInput, firstName);
	}

	public void enterLastName(String lastName) {
	    type(lastNameInput, lastName);
	}

	public void enterCompany(String company) {
	    type(companyInput, company);
	}

	public void enterAddress1(String address1) {
	    type(address1Input, address1);
	}

	public void enterAddress2(String address2) {
	    type(address2Input, address2);
	}

	public void selectCountry(String country) {
	    new Select(countryDropdown).selectByVisibleText(country);
	}

	public void enterState(String state) {
	    type(stateInput, state);
	}

	public void enterCity(String city) {
	    type(cityInput, city);
	}

	public void enterZipcode(String zipcode) {
	    type(zipcodeInput, zipcode);
	}

	public void enterMobileNumber(String mobileNumber) {
	    type(mobileNumberInput, mobileNumber);
	}
    
	public boolean isAccountCreatedVisible() {
	    return accountCreatedText.isDisplayed();
	}
	
	public WebElement getAccountCreatedTextLocator() {
		return accountCreatedText;
	}
	
	public void clickCreateAccountButton() {
	    click(createAccountButton);
	}

	public void clickContinueButton() {
	    click(continueButton);
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

	public void clickAccountDeletedContinueButton() {
	    click(accountDeletedContinueButton);
	}
	
	public WebElement getIncorrectEmail() {
	    return incorrectEmail;
	}

}
