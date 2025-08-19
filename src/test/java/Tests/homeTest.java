package Tests;

import Pages.homePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class homeTest extends BaseTest{
  homePage home;
  SoftAssert soft= new SoftAssert();
  @Test
    public void verifyScrollDownUsingButton()
  {
      home= new homePage(driver);
      soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
      home.scrollDownToTheEnd();
      soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"single-widget\"]/h2")).getText().toLowerCase().contains("subscription"));
      home.scrollUpScreen();
      soft.assertTrue(driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]//*[@class=\"carousel-inner\"]/div[1]//h2")).getText().toLowerCase().contains("full-fledged"));
      soft.assertAll();
  }
  @Test
    public void VerifyScrollUpwithoutArrowbuttonandScrollDownfunctionality()
  {
      home= new homePage(driver);
      soft.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
      soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"single-widget\"]/h2")).getText().toLowerCase().contains("subscription"));
      home.scrollByJavaExecuter();
      home.scrollUpScreen();
      soft.assertTrue(driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]//*[@class=\"carousel-inner\"]/div[1]//h2")).getText().toLowerCase().contains("full-fledged"));
      soft.assertAll();
  }


}
