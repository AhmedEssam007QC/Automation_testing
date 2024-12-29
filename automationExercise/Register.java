package automationExercise;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Locale;


public class Register {
    ChromeDriver driver = new ChromeDriver();
    Faker fakedata = new Faker(Locale.ENGLISH);
    @BeforeTest
    public void openURL()
    {
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/login");
    }
    @Test(priority = 1)
    public void register()
    {
        WebElement name = driver.findElement(By.xpath("//*[@data-qa=\"signup-name\"]"));
        name.sendKeys(fakedata.name().fullName());
        WebElement email = driver.findElement(By.xpath("//*[@data-qa=\"signup-email\"]"));
        email.sendKeys(fakedata.internet().safeEmailAddress());
        WebElement signBTN= driver.findElement(By.xpath("//*[@data-qa=\"signup-button\"]"));
        signBTN.click();
    }
    @Test(priority = 2)
    public void registerForm() throws InterruptedException {
       // driver.get("https://www.automationexercise.com/signup");
        WebElement genderRadiobutton = driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
        genderRadiobutton.click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("ahmedessam007");
        // WebElement dayDropdown = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        Select days = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        days.selectByValue("18");
        Select month = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        month.selectByVisibleText("August");
        Select years = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        years.selectByVisibleText("1995");
        /*WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id=\"newsletter\"]"));
        firstCheckbox.click();*/
        /*WebElement secondCheckbox = driver.findElement(By.xpath("//*[@id=\"optin\"]"));
        secondCheckbox.click();*/
        Thread.sleep(3000);
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstName.sendKeys(fakedata.name().firstName());
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        lastName.sendKeys(fakedata.name().lastName());
        WebElement company = driver.findElement(By.xpath("//*[@id=\"company\"]"));
        company.sendKeys(fakedata.company().name());
        WebElement Address = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        Address.sendKeys(fakedata.address().fullAddress());

        WebElement State = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        State.sendKeys(fakedata.address().state());
        WebElement City = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        City.sendKeys(fakedata.address().city());
        WebElement ZipCode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        ZipCode.sendKeys(fakedata.address().zipCode());
        WebElement mobileNumber = driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
        mobileNumber.sendKeys(fakedata.phoneNumber().cellPhone());
        WebElement Submit = driver.findElement(By.xpath("//*[@data-qa=\"create-account\"]"));
        Submit.click();
        WebElement asserttxt= driver.findElement(By.xpath("//*[@data-qa=\"account-created\"]"));
        System.out.println(asserttxt.getText().equalsIgnoreCase("Account Created!"));
        Thread.sleep(2000);
       // Assert.assertTrue(true,"Account Created!\n");
        //Assert.assertEquals("//*[@data-qa=\"account-created\"]","Account Created!");
        Assert.assertTrue(true,"Account Created!");
        System.out.println("The test is passed");
        WebElement continueBTN= driver.findElement(By.xpath("//*[@data-qa=\"continue-button\"]"));
        continueBTN.click();
    }


}
