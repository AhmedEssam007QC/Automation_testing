package org.example.pages;

import org.example.stepDef.hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerPage {
    public registerPage()
    {
        PageFactory.initElements(hooks.driver,this);
    }
    @FindBy(xpath = "//*[@class=\"shop-menu pull-right\"]/ul/li[8]/a")
    public WebElement contactUsLocator;
}
