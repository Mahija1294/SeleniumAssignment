package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestCasesPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Home")
	private WebElement homeIcon;
	
	@FindBy(xpath = "//a[contains(text(),' Test Cases')]")
    private WebElement testCasesButton;
	
	@FindBy(xpath = "//b[text()='Test Cases']")
    private WebElement testCasesHeader;
	
	public TestCasesPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHomeIconLocator() {
		return homeIcon;
	}
	
	public void clickTestCasesButton() {
	    click(testCasesButton);
	}
	
	public boolean isUserNavigatedToTestCasesPage() {
        return testCasesHeader.isDisplayed();
    }
}
