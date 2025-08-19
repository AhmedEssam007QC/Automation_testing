package Tests;

import Pages.cartPage;
import Pages.homePage;
import Pages.loginPage;
import Pages.registerPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class loginTest extends BaseTest{
    homePage home;
    registerPage register;
    loginPage login;
    Faker fake = new Faker();
    cartPage cart;
    SoftAssert soft= new SoftAssert();
    @Test
    public void loginWithValidData()
    {
        home= new homePage(driver);
        register= new registerPage(driver);
        login= new loginPage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToLoginOrSignUp();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"login-form\"]/h2")).getText().toLowerCase().contains("login to your account"));
        register.signUpFirst("ahmed","ahmed17@softTrend.com");
        register.signUpSecond("ahmedessam007","18","August","1995",fake.name().firstName(),fake.name().lastName(),fake.company().name(),fake.address().fullAddress(),"India",fake.address().state(),fake.address().city(), fake.address().zipCode(),fake.phoneNumber().cellPhone());
        register.ClickContinue();
        home.clickLogout();
        login.login("ahmed8@softTrend.com","ahmedessam007");
        register.deleteAcoount();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("account deleted!"));
        register.ClickContinue();
        soft.assertAll();
    }
    @Test
    public void loginWithInvalidData()
    {
        home= new homePage(driver);
        register= new registerPage(driver);
        login= new loginPage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToLoginOrSignUp();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"login-form\"]/h2")).getText().toLowerCase().contains("login to your account"));
        login.login("ahmed8@softTrend.com","ahmedessam007");
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"login-form\"]//*[@action=\"/login\"]/p")).getText().toLowerCase().contains("your email or password is incorrect!"));
        soft.assertAll();
    }
    @Test
    public void logOut()
    {
        home= new homePage(driver);
        register= new registerPage(driver);
        login= new loginPage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToLoginOrSignUp();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"login-form\"]/h2")).getText().toLowerCase().contains("login to your account"));
        register.signUpFirst("ahmed","ahmed12@softTrend.com");
        register.signUpSecond("ahmedessam007","18","August","1995",fake.name().firstName(),fake.name().lastName(),fake.company().name(),fake.address().fullAddress(),"India",fake.address().state(),fake.address().city(), fake.address().zipCode(),fake.phoneNumber().cellPhone());
        register.ClickContinue();
        home.clickLogout();
        login.login("ahmed12@softTrend.com","ahmedessam007");
        home.clickLogout();
        home.navigateToLoginOrSignUp();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/login");
        soft.assertAll();
    }
    @Test
    public void loginBeforeCheckOut()
    {
        home= new homePage(driver);
        cart= new cartPage(driver);
        login= new loginPage(driver);
        register= new registerPage(driver);
        home.navigateToLoginOrSignUp();
        register.signUpFirst("ahmed essam","ahmedessam25@gmail.com");
        register.signUpSecond("ahmedessam007","18","August","1995",fake.name().firstName(),fake.name().lastName(),fake.company().name(),fake.address().fullAddress(),"India",fake.address().state(),fake.address().city(),fake.address().zipCode(),fake.phoneNumber().cellPhone());
        home.clickLogout();
        home.navigateToLoginOrSignUp();
        login.login("ahmedessam25@gmail.com","ahmedessam007");
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"nav navbar-nav\"]/li[10]")).getText().toLowerCase().contains("logged in as"));
        cart.AddProductsToCart();
        home.navigateToCart();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/view_cart");
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
