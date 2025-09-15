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
import pages.TestCasesPage;

public class ProductsTest extends BaseTest {
	
//	@Test
	public void testCasesTest()
	{
		WebDriver driverref = DriverManager.getDriver();
		ProductsPage productsPage = new ProductsPage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(productsPage.getHomeIconLocator()));
	    boolean isVisisble = productsPage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		// click on Products button
		productsPage.clickProductsButton();
		
		// verify navigation
		Assert.assertTrue(productsPage.isUserNavigatedToAllProductsPage(),"User is navigated to Products page!");
				
		// verify products list visibility
		Assert.assertTrue(productsPage.isProductsListVisible(),"Products list is visible!");
		
		productsPage.scrollToElement(productsPage.getFirstProduct());
		
		// click on First Product button
		productsPage.clickFirstProductsButton();
		
		//Product Details Visibility
		Assert.assertTrue(productsPage.isProductDetailPageVisible(), "Product detail page is loaded!");		
		
	}
	
	@Test
	public void SearchTest() throws InterruptedException
	{
		WebDriver driverref = DriverManager.getDriver();
		ProductsPage productsPage = new ProductsPage(driverref);
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(productsPage.getHomeIconLocator()));
	    boolean isVisisble = productsPage.getHomeIconLocator().isDisplayed();
		Assert.assertEquals(isVisisble, true);
		
		// click on TestCases button
		productsPage.clickProductsButton();
		
		// verify navigation
		Assert.assertTrue(productsPage.isUserNavigatedToAllProductsPage(),"User is navigated to Products page!");

		// search product
		productsPage.enterproductName("Blue Top");
		productsPage.clickOnSearchButton();
		
		//Searched products visibility
		Assert.assertTrue(productsPage.isSearchedProductsHeaderVisible(), "'SEARCHED PRODUCTS' is visible");
		Assert.assertTrue(productsPage.areProductsVisible(), "Products visible for search term");
}
}