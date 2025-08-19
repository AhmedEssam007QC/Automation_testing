package Tests;

import Pages.homePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class subscriptionTest extends BaseTest{
    homePage home;
    SoftAssert soft= new SoftAssert();
    Faker fake= new Faker();
    @Test
    public void subscriptionInHomePage()
    {
        home = new homePage(driver);
        home.navigateToHome();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        soft.assertTrue(driver.findElement(By.xpath("//*[@id=\"footer\"]//h2")).getText().toLowerCase().contains("subscription"));
        home.homeSubscription(fake.internet().emailAddress());
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"alert-success alert\"]")).getText().toLowerCase().contains("you have been successfully subscribed!"));
        soft.assertAll();

    }
}
