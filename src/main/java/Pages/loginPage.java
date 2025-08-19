package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends BasePage{
final private By emailLocator =By.xpath("//*[@data-qa=\"login-email\"]");
final private By passwordLocator=By.xpath("//*[@data-qa=\"login-password\"]");
final private By loginButtonLocator=By.xpath("//*[@data-qa=\"login-button\"]");
    public loginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void login(String email, String password)
    {
        sendKeys(emailLocator,email);
        sendKeys(passwordLocator,password);
        click(loginButtonLocator);

    }
}
