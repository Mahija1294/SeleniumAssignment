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

public class ProductsPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Home")
	private WebElement homeIcon;
	
	@FindBy(xpath = "//h2[text()='Blue Top']")
	private WebElement blueTop;
	
	@FindBy(xpath = "//a[contains(text(),' Products')]")
    private WebElement productsButton;
	
	@FindBy(xpath = "//h2[text()='All Products']")
    private WebElement productsHeader;
	
	@FindBy(xpath = "//div[@class='features_items']//div[@class='product-image-wrapper']")
    private List<WebElement> productList;
	
	@FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    private WebElement firstProduct;
	
	@FindBy(xpath = "//p[text()='Category: Women > Tops']")
	private WebElement category;
	
	@FindBy(xpath = "//span[text()='Rs. 500']")
	private WebElement price;
	
	@FindBy(xpath = "//b[text()='Availability:']")
	private WebElement availability;
	
	@FindBy(xpath = "//b[text()='Condition:']")
	private WebElement condition;
	
	@FindBy(xpath = "//b[text()='Brand:']")
	private WebElement brand;
	
	@FindBy(xpath = "//input[@id='search_product']")
	private WebElement productName;
	
	@FindBy(id = "submit_search")
    WebElement searchButton;
	
	@FindBy(xpath = "//h2[text()='Searched Products']")
    WebElement searchedProductsHeader;

    @FindBy(xpath = "//div[@class='productinfo text-center']")
    WebElement productsList;
	
	public ProductsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeIconLocator() {
		return homeIcon;
	}
	
	public void clickProductsButton() {
	    click(productsButton);
	}
	
	public boolean isUserNavigatedToAllProductsPage() {
        return productsHeader.isDisplayed();
    }
	
	public boolean isProductsListVisible() {
        return productList.size() > 0;
    }
	
	public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public WebElement getFirstProduct() {
		return firstProduct;
	}
	
	public void clickFirstProductsButton() {
	    click(firstProduct);
	}
	
	public boolean isProductDetailPageVisible() {
        return blueTop.isDisplayed();
    }

    public boolean verifyProductDetailsVisible() {
        return blueTop.isDisplayed() &&
        	   category.isDisplayed() &&
               price.isDisplayed() &&
               availability.isDisplayed() &&
               condition.isDisplayed() &&
               brand.isDisplayed();
    }
    
    public void enterproductName(String searchProductName)
	{
		type(productName, searchProductName);	
	}
    
    public void clickOnSearchButton() {
        searchButton.click();
    }
    
    public boolean isSearchedProductsHeaderVisible() {
        return searchedProductsHeader.isDisplayed();
    }

    public boolean areProductsVisible() {
        return productsList.isDisplayed();
    }
}