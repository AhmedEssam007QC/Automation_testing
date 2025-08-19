package Tests;

import Pages.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class productsTest extends BaseTest{
    homePage home;
    productsPage products;
    cartPage cart;
    loginPage login;
    SoftAssert soft= new SoftAssert();
    registerPage register;
    Faker fake= new Faker();
    @Test
    public void verifyAllProductsAndDetails()
    {
        home= new homePage(driver);
        products= new productsPage(driver);
        home.navigateToHome();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToProducts();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("all products"));
        products.viewProducts();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"product-details\"]//*[@class=\"product-information\"]/h2")).getText().toLowerCase().contains("blue top"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"product-details\"]//*[@class=\"product-information\"]//p[1]")).getText().toLowerCase().contains("category"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"product-details\"]//*[@class=\"product-information\"]//span/span")).getText().toLowerCase().contains("rs"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"product-details\"]//*[@class=\"product-information\"]//p[2]")).getText().toLowerCase().contains("availability"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"product-details\"]//*[@class=\"product-information\"]//p[3]")).getText().toLowerCase().contains("condition"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"product-details\"]//*[@class=\"product-information\"]//p[4]")).getText().toLowerCase().contains("brand"));
        soft.assertAll();
    }
    @Test
    public void searchForProduct()
    {
        home= new homePage(driver);
        products= new productsPage(driver);
        home.navigateToHome();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToProducts();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("all products"));
        products.searchForAproduct("blue top");
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("searched products"));
        soft.assertAll();

    }
    @Test
    public void viewProductQuantity()
    {
        home = new homePage(driver);
        cart= new cartPage(driver);
        home.navigateToHome();
        products= new productsPage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.viewProducts();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/product_details/1");
        products.changeQuantity("4");
        products.clickAddToCart();
        home.navigateToCart();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"table table-condensed\"]/tbody/tr/td[2]/h4")).getText().toLowerCase().contains("blue"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"table table-condensed\"]/tbody/tr/td[4]/button")).getText().toLowerCase().contains("4"));
        soft.assertAll();
    }
    @Test
    public void viewCategoryProducts()
    {
        home= new homePage(driver);
        products= new productsPage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"left-sidebar\"]/h2")).getText().toLowerCase().contains("category"));
        home.clickOnWomanCategory();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("dress"));
        home.clickOnMenCategory();
        soft.assertAll();
    }
    @Test
    public void viewandcardBrandProduct()
    {
        home= new homePage(driver);
        products= new productsPage(driver);
        home.navigateToProducts();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"brands_products\"]/h2")).getText().toLowerCase().contains("brands"));
        products.clickOnBrandName();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("polo"));
        products.clickOnHANDMBrand();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("h&m"));
        soft.assertAll();
    }
    @Test
    public void searchProductsAndVerifyCartAfterLogin()
    {
        home= new homePage(driver);
        login= new loginPage(driver);
        products= new productsPage(driver);
        register= new registerPage(driver);
        home.navigateToProducts();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("all products"));
        products.searchForAproduct("top");
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("searched products"));
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"features_items\"]//*[@class=\"col-sm-4\"]//*[@class=\"single-products\"]//*[@class=\"productinfo text-center\"]//p")).getText().toLowerCase().contains("blue top"));
       // products.addBlueTopToCart();
        for (int i = 1; i <=products.searchedProducts().size() ; i++) {
            products.addSearchedProductsToCart(i);

        }
        home.navigateToCart();
        for (int i = 1; i <=products.productsInTheCart().size() ; i++) {
            System.out.println( products.getNameOfProductsInTheCart(i));

        }
        home.navigateToLoginOrSignUp();
        register.signUpFirst("ahmed","ahmed201@softTrend.com");
        register.signUpSecond("ahmedessam007","18","August","1995",fake.name().firstName(),fake.name().lastName(),fake.company().name(),fake.address().fullAddress(),"India",fake.address().state(),fake.address().city(), fake.address().zipCode(),fake.phoneNumber().cellPhone());
        register.ClickContinue();
        home.clickLogout();
        login.login("ahmed201@softTrend.com","ahmedessam007");
        home.navigateToCart();
        soft.assertAll();
    }
    @Test
    public void addReviewOnProduct()
    {
        products= new productsPage(driver);
        home= new homePage(driver);
        home.navigateToProducts();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"title text-center\"]")).getText().toLowerCase().contains("all products"));
        products.viewProducts();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"nav nav-tabs\"]//a")).getText().toLowerCase().contains("write your review"));
        products.submitReview(fake.name().fullName(),fake.internet().emailAddress(),"hello");
        soft.assertTrue(driver.findElement(By.xpath("//*[@id=\"review-section\"]//*[@class=\"alert-success alert\"]/span")).getText().toLowerCase().contains("thank you for your review"));
        soft.assertAll();

    }
}
