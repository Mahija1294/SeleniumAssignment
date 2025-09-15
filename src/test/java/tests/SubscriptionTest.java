package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SignUpPage;
import pages.SubscriptionPage;
import pages.TestCasesPage;

public class SubscriptionTest extends BaseTest {
	
    @Test
	public void subscriptionTest()
	{
		WebDriver driverref = DriverManager.getDriver();
		SubscriptionPage subscriptionPage = new SubscriptionPage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(subscriptionPage.getHomeIconLocator()));
	    boolean isVisisble = subscriptionPage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		//subscription text visibility
		subscriptionPage.scrollToElement(subscriptionPage.subscriptionTextIsVisible());
		
		//enter email address
		subscriptionPage.enteremailAddress("mahija@gmail.com");
		subscriptionPage.clickOnSubscribeButton();
		
		//success message visibility
		Assert.assertTrue(subscriptionPage.isSuccessMessageVisible(), "Success message is visible");
		
	}
}    
