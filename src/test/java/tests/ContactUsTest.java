package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.ContactUsPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SignUpPage;
import pages.SubscriptionPage;
import pages.TestCasesPage;

public class ContactUsTest extends BaseTest {
	
    @Test
	public void contactUsTest()
	{
		WebDriver driverref = DriverManager.getDriver();
		ContactUsPage contactUsPage = new ContactUsPage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(contactUsPage.getHomeIconLocator()));
	    boolean isVisisble = contactUsPage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		//click on contact us button
		contactUsPage.clickcontactUsButton();
		
		//get in us touch text visibility
		Assert.assertTrue(contactUsPage.getInTouchTextIsVisible(),"Get in Touch text is visible!");
		
		//enter name and email
		contactUsPage.nameText("Mahija");
		contactUsPage.emailText("mahi@gmail.com");
		
		//enter subject and message
		contactUsPage.subjectText("Java");
		contactUsPage.messageText("Please share the details");
		
		//upload file
		contactUsPage.uploadFile("C:\\Users\\mahim\\OneDrive\\Pictures\\133922856060363092.jpg");
		
		//submit 
		contactUsPage.clickOnSubmitButton();
		
		//alert message
		Alert alert = driverref.switchTo().alert();
        alert.accept();
        
        //success message verification & Home button
        String successText = contactUsPage.getSuccessMessage();
        Assert.assertEquals(successText, "Success! Your details have been submitted successfully.");
        contactUsPage.clickHome();
        Assert.assertTrue(driverref.getCurrentUrl().contains("automationexercise.com"), "Navigated to Home Page!");
		
	}
}
