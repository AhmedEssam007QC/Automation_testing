package org.example.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.registerPage;

public class registerActions {
    registerPage register = new registerPage();
    @Given("user go to register page")
    public void goToRegisterPage()
    {
        register.contactUsLocator.click();

    }

    @When("user enter valid email and password")
    public void userEnterValidEmailAndPassword() {
    }

    @And("user click on submit button")
    public void userClickOnSubmitButton() {
    }

    @Then("user can register successfully")
    public void userCanRegisterSuccessfully() {
    }
}
