package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class contactUSPage extends BasePage{
final private By nameLocator= By.xpath("//*[@data-qa=\"name\"]");
final private By emailLocator= By.xpath("//*[@data-qa=\"email\"]");
final private By subjectLocator= By.xpath("//*[@data-qa=\"subject\"]");
final private By messageLocator = By.xpath("//*[@data-qa=\"message\"]");
final private By uploadFileBTN= By.xpath("//*[@type=\"file\"]");
final private By submitBTN= By.xpath("//*[@data-qa=\"submit-button\"]");
    public contactUSPage(WebDriver driver) {
        super(driver);
    }
    public void fillContactUSData(String name,String email,String subject,String message,String filePath)
    {
        sendKeys(nameLocator,name);
        sendKeys(emailLocator,email);
        sendKeys(subjectLocator,subject);
        sendKeys(messageLocator,message);
        uploadFile(uploadFileBTN,filePath);

    }
    public void AcceptAlertHandle()
    {
        AcceptAlert();
    }
    public void submit()
    {
        click(submitBTN);
    }
}
