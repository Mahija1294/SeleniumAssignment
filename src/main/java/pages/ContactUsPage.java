package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Home")
	private WebElement homeIcon;
	
	@FindBy(xpath = "//a[contains(text(),' Contact us')]")
    private WebElement contactUsButton;
	
	@FindBy(xpath ="//h2[text()='Get In Touch']")
	private WebElement getInTouchText;
	
	@FindBy(xpath ="//input[@data-qa='name']")
	private WebElement nameText;
	
	@FindBy(xpath ="//input[@data-qa='email']")
	private WebElement emailText;
	
	@FindBy(xpath ="//input[@data-qa='subject']")
	private WebElement subjectText;
	
	@FindBy(xpath ="//textarea[@id='message']")
	private WebElement messageText;
	
	@FindBy(xpath ="//input[@name='upload_file']")
	private WebElement uploadFile;
	
	@FindBy(xpath ="//input[@data-qa='submit-button']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessage;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
    WebElement homeButton;
	
	public ContactUsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeIconLocator() {
		return homeIcon;
	}
	
	public void clickcontactUsButton() {
	    click(contactUsButton);
	}
	
	public boolean getInTouchTextIsVisible() {
        return getInTouchText.isDisplayed();
    }
	
	public void nameText(String enterContactName)
	{
		type(nameText, enterContactName);	
	}
	
	public void emailText(String enterEmailText)
	{
		type(emailText, enterEmailText);	
	}
	
	public void subjectText(String enterSubjectText)
	{
		type(subjectText, enterSubjectText);	
	}
	
	public void messageText(String enterMessageText)
	{
		type(messageText, enterMessageText);	
	}
	
	public void uploadFile(String filePath) {
        uploadFile.sendKeys(filePath);
    }
	
	public void clickOnSubmitButton() {
        submitButton.click();
    }
	
	public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void clickHome() {
        homeButton.click();
}
}
