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
import pages.SignUpPage;

public class RegisterUserTest extends BaseTest {
	
	//@Test
	public void registerUser()
	{
		WebDriver driverref = DriverManager.getDriver();
		SignUpPage signUpPage = new SignUpPage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(signUpPage.getHomeIconLocator()));
	    boolean isVisisble = signUpPage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		// click on signUp link
		signUpPage.clickSignUpLink();
		
		// verify the visibility of new user sign up
		wait.until(ExpectedConditions.visibilityOf(signUpPage.getNewUserSignUpTextLocator()));
		isVisisble = signUpPage.getNewUserSignUpTextLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		// enter username and email for signUp
		signUpPage.enterSignUpUserName("Mahija");
		signUpPage.enterSignUpEmailAddress("mahi7779@gmail.com");
		signUpPage.clickSignUpButton();
		
		// verify the visibility of enter account information
		wait.until(ExpectedConditions.visibilityOf(signUpPage.getEnterAccountInformationLocator()));
		Assert.assertEquals(signUpPage.isEnterAccountInformationVisible(), true);
		
		//select Title
		signUpPage.selectTitleMrs();
		signUpPage.enterName("Mahija");
		//signUpPage.enterEmail("mahija@gmail.com");
		signUpPage.enterPassword("123456@@THGK");
		
		//select DOB
		//Thread.sleep(10000);
		signUpPage.selectDateOfBirth("18", "October", "1992");
		
		//click check box
		signUpPage.selectNewsletterCheckbox();
		signUpPage.selectOptinCheckbox();
		
		//Add address Fields
		signUpPage.enterFirstName("Mahija");
		signUpPage.enterLastName("D");
		signUpPage.enterCompany("ABC");
		signUpPage.enterAddress1("ARGJ");
		signUpPage.enterAddress2("DTY3");
		signUpPage.selectCountry("India");
		signUpPage.enterState("Telangana");
		signUpPage.enterCity("Hyderabad");
		signUpPage.enterZipcode("500084");
		signUpPage.enterMobileNumber("3095678301");
		signUpPage.clickCreateAccountButton();
		signUpPage.isAccountCreatedVisible();
		
		//continue		
		wait.until(ExpectedConditions.visibilityOf(signUpPage.getAccountCreatedTextLocator()));
     	Assert.assertEquals(signUpPage.isAccountCreatedVisible(), true);
     	
     	signUpPage.clickContinueButton();
     	
     	wait.until(ExpectedConditions.visibilityOf(signUpPage.getloggedInAsText()));
     	Assert.assertEquals(signUpPage.isLoggedInAsVisible(), true);
     	signUpPage.isLoggedInAsVisible();
     	
     	//delete
     	signUpPage.clickDeleteAccountButton();
     	signUpPage.isAccountDeletedVisible();
     	signUpPage.clickAccountDeletedContinueButton();
	}	
	@Test
	public void registerUserWithExistingEmail() 
	{
		WebDriver driverref = DriverManager.getDriver();
		SignUpPage signUpPage = new SignUpPage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(signUpPage.getHomeIconLocator()));
	    boolean isVisisble = signUpPage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		// click on signUp link
		signUpPage.clickSignUpLink();
		
		// verify the visibility of new user sign up
		wait.until(ExpectedConditions.visibilityOf(signUpPage.getNewUserSignUpTextLocator()));
		isVisisble = signUpPage.getNewUserSignUpTextLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		// enter username and email for signUp
		signUpPage.enterSignUpUserName("Mahija");
		signUpPage.enterSignUpEmailAddress("mahi0914@gmail.com");
		signUpPage.clickSignUpButton();
		
		wait.until(ExpectedConditions.visibilityOf(signUpPage.getIncorrectEmail()));
     	Assert.assertEquals(signUpPage.getIncorrectEmail().isDisplayed(), true);
		
	}
}
