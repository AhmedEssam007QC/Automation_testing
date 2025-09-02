package org.example.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.loginPage;

public class loginActions {
    loginPage login  = new loginPage();
    @Given("user go to login page")
    public void goToLoginPage()
    {
        login.loginLocator.click();

    }

    @When("user enters valid data")
    public void userEntersValidData() {
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
    }

    @Then("user can login successfully")
    public void userCanLoginSuccessfully() {
    }
}
