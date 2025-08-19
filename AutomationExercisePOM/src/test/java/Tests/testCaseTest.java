package Tests;

import Pages.homePage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testCaseTest extends BaseTest {
    homePage home;
    SoftAssert soft= new SoftAssert();
    Faker fake= new Faker();
    @Test
    public void verifyTestCasesPage()
    {
        home= new homePage(driver);
        home.navigateToHome();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
        home.navigateToTestCases();
        soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/test_cases");
        soft.assertAll();

    }

}
