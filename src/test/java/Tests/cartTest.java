package Tests;

import Pages.cartPage;
import Pages.homePage;
import Pages.productsPage;
import Pages.registerPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class cartTest extends BaseTest{
    cartPage cart;
    homePage home;
    registerPage register;
    productsPage products;
    SoftAssert soft= new SoftAssert();
    Faker fake= new Faker();
    @Test
    public void verifySubscription()
    {
        home = new homePage(driver);
        cart= new cartPage(driver);
        home.navigateToHome();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToCart();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"col-sm-3 col-sm-offset-1\"]//h2")).getText().toLowerCase().contains("subscription"));
        cart.subscripiton(fake.internet().emailAddress());
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"alert-success alert\"]")).getText().toLowerCase().contains("you have been"));
        soft.assertAll();
    }
    @Test
    public void addToCart()
    {
        home = new homePage(driver);
        cart= new cartPage(driver);
        home.navigateToHome();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToProducts();
        cart.AddProductsToCart();
        home.navigateToCart();
        //System.out.println(cart.products().size());
        for (int i = 1; i <=cart.products().size() ; i++) {
           String nameOfProducts= cart.getProductName(i);
            System.out.println(nameOfProducts);
            soft.assertEquals(cart.getProductName(i),nameOfProducts);


        }
        soft.assertAll();

    }
    @Test
    public void removeProductsFromCart()
    {
        cart=new cartPage(driver);
        home= new homePage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        cart.AddProductsToCart();
        home.navigateToCart();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/view_cart");
//        for (int i = 1; i <=cart.products().size() ; i++) {
//            cart.deleteAllproducts(i);
//        }
        cart.removeOneProduct();
        soft.assertTrue(driver.findElement(By.xpath("//*[@id=\"cart_info_table\"]/tbody//*[@id=\"product-2\"]/td[2]/h4/a")).getText().toLowerCase().contains("men"));
          soft.assertAll();
    }
    @Test
    public void addToCartFromRecommendedItem()
    {
        home= new homePage(driver);
        cart= new cartPage(driver);
        home.navigateToHome();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"recommended_items\"]//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("recommended"));
//        for (int i = 1; i <=cart.recommendedProducts().size() ; i++) {
//            cart.addToCartFromRecommendedProducts(i);
//
//        }
        cart.addToCartFromRecommendedProducts();
        home.navigateToCart();
        soft.assertAll();

    }
    @Test
    public void verifyAddressDetailsInCheckOut()
    {
        home= new homePage(driver);
        cart= new cartPage(driver);
        register= new registerPage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToLoginOrSignUp();
        register.signUpFirst("ahmed essam","ahmedessam206@gmail.com");
        register.signUpSecond("ahmedessam007","18","August","1995",fake.name().firstName(),fake.name().lastName(),fake.company().name(),"test","India",fake.address().state(),fake.address().city(),fake.address().zipCode(),fake.phoneNumber().cellPhone());
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("account created!"));
        register.clickOnContinueButton();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"nav navbar-nav\"]/li[10]")).getText().toLowerCase().contains("logged in as"));
        cart.AddProductsToCart();
        home.navigateToCart();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/view_cart");
        cart.clickProceedToCheckOut();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"address item box\"]/li[4]")).getText().toLowerCase().contains("test"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@id=\"address_invoice\"]//li[4]")).getText().contains("test"));
        home.clickOnDeleteAccount();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("account deleted!"));
        register.ClickContinue();
        soft.assertAll();

    }
    @Test
    public void downloadInvoiceAfterPurchasingOrder()
    {
        home= new homePage(driver);
        cart= new cartPage(driver);
        register= new registerPage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToLoginOrSignUp();
        register.signUpFirst("ahmed essam","ahmedessam301@gmail.com");
        register.signUpSecond("ahmedessam007","18","August","1995",fake.name().firstName(),fake.name().lastName(),fake.company().name(),"test","India",fake.address().state(),fake.address().city(),fake.address().zipCode(),fake.phoneNumber().cellPhone());
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("account created!"));
        register.clickOnContinueButton();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"nav navbar-nav\"]/li[10]")).getText().toLowerCase().contains("logged in as"));
        cart.AddProductsToCart();
        home.navigateToCart();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/view_cart");
        cart.clickProceedToCheckOut();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"address item box\"]/li[4]")).getText().toLowerCase().contains("test"));
        cart.writeCommentToCheckOut("test");
        cart.fillPaymentForm(fake.name().fullName(),fake.business().creditCardNumber(),"222","08","2090");
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]/b")).getText().toLowerCase().contains("order placed"));
        cart.downloadInvoice();
        soft.assertAll();
    }


}
