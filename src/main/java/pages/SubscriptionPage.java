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

public class SubscriptionPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Home")
	private WebElement homeIcon;
	
	@FindBy(xpath ="//h2[text()='Subscription']")
	private WebElement subscriptionText;
	
	@FindBy(xpath="//input[@id='susbscribe_email']")
	private WebElement emailAddress;
	
	@FindBy(xpath= "//button[@id='subscribe']")
	private WebElement subscribeButton;
	
	@FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement successMessage;
	
	public SubscriptionPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeIconLocator() {
		return homeIcon;
	}
	
	public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public WebElement subscriptionTextIsVisible() {
        return subscriptionText;
    }
	
	public void enteremailAddress(String enterEmailAddress)
	{
		type(emailAddress, enterEmailAddress);	
	}
	
	public void clickOnSubscribeButton() {
        subscribeButton.click();
    }
	
	public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }
	
}
