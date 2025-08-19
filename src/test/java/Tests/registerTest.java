package Tests;

import Pages.cartPage;
import Pages.homePage;
import Pages.productsPage;
import Pages.registerPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class registerTest extends BaseTest{
    homePage home;
    registerPage register;
    SoftAssert soft= new SoftAssert();
    Faker fake = new Faker();
    cartPage cart;
    productsPage products;
    @Test
    public void Register()
    {
        home= new homePage(driver);
        register= new registerPage(driver);
        soft= new SoftAssert();
        fake= new Faker();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToLoginOrSignUp();
        register.signUpFirst("ahmed","ahmed8@softTrend.com");
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"login-form\"]/h2/b")).getText().toLowerCase().contains("enter account information"));
        register.signUpSecond("ahmedessam007","18","August","1995",fake.name().firstName(),fake.name().lastName(),fake.company().name(),fake.address().fullAddress(),"India",fake.address().state(),fake.address().city(), fake.address().zipCode(),fake.phoneNumber().cellPhone());
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("account created!"));
        register.clickOnContinueButton();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"nav navbar-nav\"]/li[10]")).getText().toLowerCase().contains("logged in as"));
        register.deleteAcoount();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("account deleted!"));
        register.ClickContinue();
        soft.assertAll();
    }
    @Test
    public void registerWithExistingEmail()
    {
        home= new homePage(driver);
        register= new registerPage(driver);
        soft= new SoftAssert();
        fake= new Faker();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToLoginOrSignUp();
        register.signUpFirst("ahmed","ahmed12@softTrend.com");
        soft.assertTrue(driver.findElement(By.xpath("//*[@action=\"/signup\"]/p")).getText().toLowerCase().contains("email address already exist!"));
        soft.assertAll();
    }
    @Test
    public void registerWhileCheckOut()
    {
        home= new homePage(driver);
        cart= new cartPage(driver);
        products= new productsPage(driver);
        register= new registerPage(driver);
        home.navigateToHome();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        cart.AddProductsToCart();
        home.navigateToCart();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/view_cart");
        cart.clickProceedToCheckOut();
        cart.clickonLoginLink();
        register.signUpFirst("ahmed essam","ahmedessam992@gmail.com");
        register.signUpSecond("ahmedessam007","18","August","1995",fake.name().firstName(),fake.name().lastName(),fake.company().name(),fake.address().fullAddress(),"India",fake.address().state(),fake.address().city(),fake.address().zipCode(),fake.phoneNumber().cellPhone());
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("account created!"));
        register.clickOnContinueButton();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"nav navbar-nav\"]/li[10]")).getText().toLowerCase().contains("logged in as"));
        home.navigateToCart();
        cart.clickProceedToCheckOut();
        soft.assertTrue(driver.findElement(By.xpath("//*[@id=\"cart_items\"]//*[@class=\"container\"]//div[2]/h2")).getText().toLowerCase().contains("address"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"step-one\"][2]/h2")).getText().toLowerCase().contains("review"));
        cart.descriptionMessage("test");
        cart.clickPlaceOrder();
        cart.fillPaymentForm(fake.name().fullName(),fake.business().creditCardNumber(),"888","09","2029");
        soft.assertTrue(driver.findElement(By.xpath("//*[@style=\"font-size: 20px; font-family: garamond;\"]")).getText().toLowerCase().contains("congratulations"));
        home.clickOnDeleteAccount();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("deleted"));
        register.clickOnContinueButton();
        soft.assertAll();

    }
    @Test
    public void registerBeforeCheckOut()
    {
        home= new homePage(driver);
        register= new registerPage(driver);
        cart= new cartPage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToLoginOrSignUp();
        register.signUpFirst("ahmed essam","ahmedessam17@gmail.com");
        register.signUpSecond("ahmedessam007","18","August","1995",fake.name().firstName(),fake.name().lastName(),fake.company().name(),fake.address().fullAddress(),"India",fake.address().state(),fake.address().city(),fake.address().zipCode(),fake.phoneNumber().cellPhone());
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("account created!"));
        register.clickOnContinueButton();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"nav navbar-nav\"]/li[10]")).getText().toLowerCase().contains("logged in as"));
        //home.navigateToProducts();
        cart.AddProductsToCart();
        home.navigateToCart();
        cart.clickProceedToCheckOut();
        soft.assertTrue(driver.findElement(By.xpath("//*[@id=\"cart_items\"]//*[@class=\"container\"]//div[2]/h2")).getText().toLowerCase().contains("address"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"step-one\"][2]/h2")).getText().toLowerCase().contains("review"));
        cart.descriptionMessage("test");
        cart.clickPlaceOrder();
        cart.fillPaymentForm(fake.name().fullName(),fake.business().creditCardNumber(),"888","09","2029");
        soft.assertTrue(driver.findElement(By.xpath("//*[@style=\"font-size: 20px; font-family: garamond;\"]")).getText().toLowerCase().contains("congratulations"));
        home.clickOnDeleteAccount();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("deleted"));
        register.clickOnContinueButton();
        soft.assertAll();





    }
}
