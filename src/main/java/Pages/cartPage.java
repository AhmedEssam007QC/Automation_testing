package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class cartPage extends BasePage{
    final private By subscriptionCartEmail= By.id("susbscribe_email");
    final private By subscriptionSubmitBTN= By.id("subscribe");
    final private By productsLocator=By.xpath("//*[@class=\"table table-condensed\"]/tbody/tr");
    final private By addFirstProductToCartLocator=By.xpath("//*[@class=\"features_items\"]/div[2]/div/div[1]/div/a");
    final private By addSecondProductToCartLocator=By.xpath("//*[@class=\"features_items\"]/div[3]/div/div[1]/div/a");
    final private By continueShoppingLocator=By.xpath("//*[@class=\"btn btn-success close-modal btn-block\"]");
    final private By proceedToCheckOutButton=By.xpath("//*[@class=\"btn btn-default check_out\"]");
    final private By loginLinkLocator=By.xpath("//*[@class=\"modal-body\"]//a");
    final private By descriptionMessageLocator=By.xpath("//*[@name=\"message\"]");
    final private By placeOrderLocator=By.xpath("//*[@href=\"/payment\"]");
    final private By nameOnCardLocator=By.xpath("//*[@name=\"name_on_card\"]");
    final private By cardNumberLocator=By.xpath("//*[@name=\"card_number\"]");
    final private By CVCLocator=By.xpath("//*[@name=\"cvc\"]");
    final private By expirationMonthLocator=By.xpath("//*[@name=\"expiry_month\"]");
    final private By expirationYearLocator=By.xpath("//*[@name=\"expiry_year\"]");
    final private By payAndConfirmBTN=By.xpath("//*[@id=\"submit\"]");
    final private By removeTheFrirstProduct=By.xpath("//*[@id=\"cart_info_table\"]/tbody//td[6]//*[@data-product-id=\"1\"]");
    final private By recommendedProducts=By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div/div");
    final private By addProductFromRecommendedItems=By.xpath("//*[@id=\"recommended-item-carousel\"]//*[@data-product-id=\"1\"]");
    final private By commentToCheckOut=By.xpath("//*[@id=\"ordermsg\"]//textarea");
    final private By placeOrderButton=By.xpath("//*[@class=\"btn btn-default check_out\"]");
    final private By downloadInvoiceBtn=By.xpath("//*[@class=\"btn btn-default check_out\"]");


    public cartPage(WebDriver driver) {
        super(driver);
    }
    public void subscripiton(String email)
    {
        sendKeys(subscriptionCartEmail,email);
        click(subscriptionSubmitBTN);
    }
    public List<WebElement> products()
    {
        return driver.findElements(productsLocator);
    }
    public void AddProductsToCart()
    {
        click(addFirstProductToCartLocator);
        click(continueShoppingLocator);
        click(addSecondProductToCartLocator);
    }
    public String getProductName(int index)
    {
        return driver.findElement(By.xpath("//*[@class=\"table table-condensed\"]/tbody/tr["+index+"]//h4/a")).getText();
    }
    public void deleteAllproducts(int index)
    {
        click(driver.findElement(By.xpath("//*[@class=\"table table-condensed\"]/tbody/tr["+index+"]/td[6]/a")));
    }
    public void clickProceedToCheckOut()
    {
        click(proceedToCheckOutButton);
    }
    public void clickonLoginLink()
    {
        click(loginLinkLocator);
    }
    public void descriptionMessage(String text)
    {
        sendKeys(descriptionMessageLocator,text);
    }
    public void clickPlaceOrder()
    {
        click(placeOrderLocator);
    }
    public void fillPaymentForm(String name, String numberOfCard, String CVC ,String expiryMonth,String expiryYear)
    {
        sendKeys(nameOnCardLocator,name);
        sendKeys(cardNumberLocator,numberOfCard);
        sendKeys(CVCLocator,CVC);
        sendKeys(expirationMonthLocator,expiryMonth);
        sendKeys(expirationYearLocator,expiryYear);
        click(payAndConfirmBTN);
    }
    public void removeOneProduct()
    {
        click(removeTheFrirstProduct);
    }
    public List<WebElement>recommendedProducts()
    {
        return driver.findElements(recommendedProducts);
    }
//    public void addToCartFromRecommendedProducts(int index)
//    {
//        click(driver.findElement(By.xpath("//*[@id=\"recommended-item-carousel\"]//*[@data-product-id=\"1\"]["+index+"]")));
//        click(continueShoppingLocator);
//
//    }
    public void addToCartFromRecommendedProducts()
    {
        click(addProductFromRecommendedItems);
        click(continueShoppingLocator);
    }
    public void writeCommentToCheckOut(String message)
    {
        sendKeys(commentToCheckOut,message);
        click(placeOrderButton);

    }
    public void downloadInvoice()
    {
        click(downloadInvoiceBtn);
    }

}
