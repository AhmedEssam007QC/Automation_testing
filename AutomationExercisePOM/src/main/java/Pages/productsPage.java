package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class productsPage extends BasePage{
    final private By viewProductsDetailsBTN= By.xpath("//*[@class=\"features_items\"]//*[@class=\"col-sm-4\"]/div/div[2]//a");
    final private By searchProducts= By.id("search_product");
    final private By searchBTN=By.id("submit_search");
    final private  By quantityLocator=By.id("quantity");
    final private By addToCartBTN=By.xpath("//*[@class=\"btn btn-default cart\"]");
    final private By clickContinueBTN = By.xpath("//*[@class=\"btn btn-success close-modal btn-block\"]");
    final private By brandsNameLocator=By.xpath("//*[@class=\"brands-name\"]//li[1]/a");
    final private By HandMBrandLocator=By.xpath("//*[@class=\"brands-name\"]//li[2]/a");
    final private By addproductTocartAftersearch=By.xpath("//*[@class=\"single-products\"]/div/a");
    final private By searchedProducts=By.xpath("//*[@class=\"single-products\"]");
    final private By continueShoppingLocator=By.xpath("//*[@class=\"btn btn-success close-modal btn-block\"]");
    final private By productsInTheCart=By.xpath("//*[@class=\"table table-condensed\"]/tbody/tr");
    final private By reviewName=By.xpath("//*[@id=\"name\"]");
    final private By reviewEmail=By.xpath("//*[@id=\"email\"]");
    final private By reviewMessage=By.xpath("//*[@id=\"review\"]");
    final private By submitREviewBTN=By.xpath("//*[@id=\"button-review\"]");


    public productsPage(WebDriver driver) {
        super(driver);
    }
    public void viewProducts()
    {
        click(viewProductsDetailsBTN);
    }
    public void searchForAproduct(String name)
    {
        sendKeys(searchProducts,name);
        click(searchBTN);
    }
    public void changeQuantity(String value)
    {
        driver.findElement(quantityLocator).clear();
        sendKeys(quantityLocator,value);
    }
    public void clickAddToCart()
    {
        click(addToCartBTN);
        click(clickContinueBTN);
    }
    public void clickOnBrandName()
    {
        click(brandsNameLocator);
    }
    public void clickOnHANDMBrand()
    {
        click(HandMBrandLocator);
    }
    public void addBlueTopToCart()
    {
        click(addproductTocartAftersearch);
    }
    public List<WebElement> searchedProducts()
    {
        return driver.findElements(searchedProducts);
    }
    public void addSearchedProductsToCart(int index)
    {
        click(driver.findElement(By.xpath("//*[@class=\"features_items\"]//*[@class=\"col-sm-4\"]["+index+"]/div/div/div/a")));
        click(continueShoppingLocator);
    }
    public List<WebElement> productsInTheCart()
    {
        return driver.findElements(productsInTheCart);
    }
    public String getNameOfProductsInTheCart(int index)
    {
        return driver.findElement(By.xpath("//*[@class=\"table table-condensed\"]/tbody/tr["+index+"]//h4")).getText();
    }
    public void submitReview(String name, String email, String message)
    {
        sendKeys(reviewName,name);
        sendKeys(reviewEmail,email);
        sendKeys(reviewMessage,message);
        click(submitREviewBTN);
    }



}

