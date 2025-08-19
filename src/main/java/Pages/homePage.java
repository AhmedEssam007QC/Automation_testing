package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class homePage extends BasePage{
    final private By homePageLocator = By.xpath("//*[@class=\"nav navbar-nav\"]/li[1]");
    final private By productsLocator=By.xpath("//*[@class=\"nav navbar-nav\"]/li[2]");
    final private By cartLocator=By.xpath("//*[@class=\"nav navbar-nav\"]/li[3]");
    final private By signUpLoginLocator=By.xpath("//*[@class=\"nav navbar-nav\"]/li[4]");
    final private By testCasesLocator = By.xpath("//*[@class=\"nav navbar-nav\"]/li[5]");
    final private By ApiTestLocator= By.xpath("//*[@class=\"nav navbar-nav\"]/li[6]");
    final private By videoTutorialLocator = By.xpath("//*[@class=\"nav navbar-nav\"]/li[7]");
    final private By contactUsLocator = By.xpath("//*[@class=\"nav navbar-nav\"]/li[8]");
    final private By logoutLocator=By.xpath("//*[@class=\"nav navbar-nav\"]/li[4]");
    final private By subscriptionEmailLocator=By.id("susbscribe_email");
    final private By subscriptionSubmitBTN=By.id("subscribe");
    final private By viewProductsDetailsBTN= By.xpath("//*[@class=\"features_items\"]//*[@class=\"col-sm-4\"]/div/div[2]//a");
    final private By deleteButton=By.xpath("//*[@class=\"nav navbar-nav\"]/li[5]");
    final private By womanCategory=By.xpath("//*[@id=\"accordian\"]//h4/a");
    final private By dressSubCategory=By.xpath("//*[@class=\"panel-group category-products\"]//*[@id=\"Women\"]//li[1]/a");
    final private By menCategory=By.xpath("//*[@class=\"panel-group category-products\"]/div[2]//h4/a");
    final private By scrollUpButtonOnScreen= By.xpath("//*[@id=\"scrollUp\"]");
    public homePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void navigateToHome()
    {
        click(homePageLocator);
    }
    public void navigateToProducts()
    {
        click(productsLocator);
    }
    public void navigateToCart()
    {
        click(cartLocator);
    }
    public void navigateToLoginOrSignUp()
    {
        click(signUpLoginLocator);
    }
    public void navigateToTestCases()
    {
        click(testCasesLocator);
    }
    public void navigateToAPITesting()
    {
        click(ApiTestLocator);
    }
    public void navigateToVideoTutorial()
    {
        click(videoTutorialLocator);
    }
    public void navigateToContactUs()
    {
        click(contactUsLocator);
    }
    public void clickLogout()
    {
        click(logoutLocator);
    }
    public void homeSubscription(String email)
    {
        sendKeys(subscriptionEmailLocator,email);
        click(subscriptionSubmitBTN);
    }
    public void viewProducts()
    {
        click(viewProductsDetailsBTN);
    }
    public void clickOnDeleteAccount()
    {
        click(deleteButton);
    }
    public void clickOnWomanCategory()
    {
        click(womanCategory);
        click(dressSubCategory);

    }
    public void clickOnMenCategory()
    {
        click(menCategory);
    }
    public void scrollDownPageUsingArrow()
    {
        scrollDown();

    }
    public void scrollDownToTheEnd()
    {
        scrollToTheEndOfPage();
    }
    public void scrollUpScreen()
    {
        click(scrollUpButtonOnScreen);
    }
    public void scrollByJavaExecuter()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@class=\"single-widget\"]/h2")));
    }

}
