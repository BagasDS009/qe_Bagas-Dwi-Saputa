package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.login.Login;


public class LoginStep {
    @Steps
    Login login;

    @Given("I as on the login page")
    public void onTheLoginPage() {
        login.onTheLoginPage();
    }
    @When("I enter my username and password correctly")
    public void enterUsernameAndPassword() {
        login.enterUsernameAndPassword();
    }
    @And("I click login button")
    public void clickLoginButton() {
        login.clickLoginButton();
    }
    @Then("I am on the home page")
    public void onTheHomePage(){
        login.onTheHomePage();
    }
}
