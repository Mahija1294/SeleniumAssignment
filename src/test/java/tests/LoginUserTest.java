package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class LoginUserTest extends BaseTest {
	
	//@Test
	public void loginUser()
	{
		WebDriver driverref = DriverManager.getDriver();
		LoginPage loginpage = new LoginPage(driverref);
		HomePage homepage = new HomePage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(homepage.getHomeIconLocator()));
	    boolean isVisisble = homepage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		//signup/login button
		loginpage.clickSignUpLoginButton();
		
		//enter email address, password & login
//		loginpage.enterUsername("mahi0914@gmail.com");
//		loginpage.enterPassword("123RA$");
//		loginpage.clickLoginButton();
				
//		wait.until(ExpectedConditions.visibilityOf(loginpage.getloggedInAsText()));
//     	Assert.assertEquals(loginpage.isLoggedInAsVisible(), true);
//     	loginpage.isLoggedInAsVisible();
//     	
//     	//delete
//     	loginpage.clickDeleteAccountButton();
//     	loginpage.isAccountDeletedVisible();
		
	}
	
	//@Test
	public void loginUserWithIncorrectDetails()
	{
		WebDriver driverref = DriverManager.getDriver();
		LoginPage loginpage = new LoginPage(driverref);
		HomePage homepage = new HomePage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(homepage.getHomeIconLocator()));
	    boolean isVisisble = homepage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		//signup/login button
		loginpage.clickSignUpLoginButton();
		
		//enter email address, password & login
		loginpage.enterUsername("mahi1409@gmail.com");
		loginpage.enterPassword("1234TY$");
		loginpage.clickLoginButton();
				
		wait.until(ExpectedConditions.visibilityOf(loginpage.getIncorrectEmailText()));
     	Assert.assertEquals(loginpage.getIncorrectEmailText().isDisplayed(), true);

		
		
	}
   
	@Test
	public void logout()
	{
		WebDriver driverref = DriverManager.getDriver();
		LoginPage loginpage = new LoginPage(driverref);
		HomePage homepage = new HomePage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(homepage.getHomeIconLocator()));
	    boolean isVisisble = homepage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		//signup/login button
		loginpage.clickSignUpLoginButton();
		
		//enter email address, password & login
		loginpage.enterUsername("mahi0914@gmail.com");
		loginpage.enterPassword("123RA$");
		loginpage.clickLoginButton();
				
		wait.until(ExpectedConditions.visibilityOf(loginpage.getloggedInAsText()));
     	Assert.assertEquals(loginpage.isLoggedInAsVisible(), true);
     	loginpage.isLoggedInAsVisible();
        
     	//logout
     	loginpage.clicklogOutButton();
     	
		
		
	}

}
