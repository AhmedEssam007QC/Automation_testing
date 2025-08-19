package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class registerPage extends BasePage{
    final private By nameLocator = By.xpath("//*[@data-qa=\"signup-name\"]");
    final private By emailLocator = By.xpath("//*[@data-qa=\"signup-email\"]");
    final private By signUBTNLocator= By.xpath("//*[@data-qa=\"signup-button\"]");
    final private By mrOrMrsLocator= By.id("id_gender1");
    final private By passwordLocator=By.xpath("//*[@data-qa=\"password\"]");
    final private By dayLocator=By.id("days");
    final private By monthLocator= By.id("months");
    final private By yearLocator= By.id("years");
    final private By newsLetterLocator=By.id("newsletter");
    final private By recievespecialOfferLocator= By.id("optin");
    final private By firstNameLocator= By.id("first_name");
    final private By lastNameLocator=By.id("last_name");
    final private By addressLocator=By.id("address1");
    final private By countryLocator=By.id("country");
    final private By stateLocator=By.id("state");
    final private By cityLocator=By.id("city");
    final private By zipCodeLocator=By.id("zipcode");
    final private By mobileNumberLocator=By.id("mobile_number");
    final private By createAccountBTNLocator= By.xpath("//*[@data-qa=\"create-account\"]");
    final private By continueButtonLocator= By.xpath("//*[@data-qa=\"continue-button\"]");
    final private By deleteAccountLocator=By.xpath("//*[@class=\"nav navbar-nav\"]/li[5]");

    public registerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void signUpFirst(String name,String email)
    {
        sendKeys(nameLocator,name);
        sendKeys(emailLocator,email);
        click(signUBTNLocator);
    }
    public void signUpSecond(String password,String days, String months, String years,String firstName, String lastName, String company, String address,String country, String state, String city, String zipCode,String mobileNumber)
    {
        sendKeys(passwordLocator,password);
        select(dayLocator,days);
        select(monthLocator,months);
        select(yearLocator,years);
        click(newsLetterLocator);
        click(recievespecialOfferLocator);
        sendKeys(firstNameLocator,firstName);
        sendKeys(lastNameLocator,lastName);
        sendKeys(countryLocator,company);
        sendKeys(addressLocator,address);
        select(countryLocator,country);
        sendKeys(stateLocator,state);
        sendKeys(cityLocator,city);
        sendKeys(zipCodeLocator,zipCode);
        sendKeys(mobileNumberLocator,mobileNumber);
        click(createAccountBTNLocator);

    }
    public void clickOnContinueButton()
    {
        click(continueButtonLocator);
    }
    public void deleteAcoount()
    {
        click(deleteAccountLocator);

    }
    public void ClickContinue()
    {
        click(continueButtonLocator);
    }
}
