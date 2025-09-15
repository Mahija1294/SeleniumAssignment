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
import pages.TestCasesPage;

public class TestCasesTest extends BaseTest {
	
	@Test
	public void testCasesTest()
	{
		WebDriver driverref = DriverManager.getDriver();
		TestCasesPage testCasesPage = new TestCasesPage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(testCasesPage.getHomeIconLocator()));
	    boolean isVisisble = testCasesPage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		// click on TestCases button
		testCasesPage.clickTestCasesButton();
		
		// verify navigation
		Assert.assertTrue(
	            testCasesPage.isUserNavigatedToTestCasesPage(),"User is navigated to Test Cases page!");
	}
	
}	
	