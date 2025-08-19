package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.security.Key;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }
    protected void click(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    protected void click(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
    protected void sendKeys(WebElement element,String text)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }
    protected void sendKeys(By by, String text)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(text);
    }
    protected void select(By by, String value)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        Select select= new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }
    protected void AcceptAlert()
    {
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }
    protected void DismissAlert()
    {
        Alert alert= driver.switchTo().alert();
        alert.dismiss();
    }
    protected void uploadFile(By by, String filePath)
    {
        driver.findElement(by).sendKeys(filePath);
    }
    protected void scrollDown()
    {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
    }
    protected void scrollToTheEndOfPage()
    {
        Actions action= new Actions(driver);
        action.sendKeys(Keys.END).perform();
    }
}
