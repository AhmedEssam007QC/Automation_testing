package Tests;

import Pages.BasePage;
import Pages.contactUSPage;
import Pages.homePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class contactUsTest extends BaseTest{
    homePage home;
    contactUSPage contact;
    SoftAssert soft= new SoftAssert();
    Faker fake= new Faker();
    @Test
    public void contactUS()
    {
        home= new homePage(driver);
        contact= new contactUSPage(driver);
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToContactUs();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"contact-form\"]/h2")).getText().toLowerCase().contains("get in touch"));
        contact.fillContactUSData(fake.name().fullName(),fake.internet().emailAddress(),"test subject","test message","C:\\Users\\Dell\\Desktop\\CVs\\AhmedEssamCV.pdf");
        contact.submit();
        contact.AcceptAlertHandle();
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"status alert alert-success\"]")).getText().toLowerCase().contains("success!"));
        soft.assertAll();
    }

}
