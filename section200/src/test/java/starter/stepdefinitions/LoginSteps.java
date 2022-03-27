package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.HomePage;
import starter.pages.LoginPage;

public class LoginSteps {
    @Steps
    LoginPage loginPage;
    @Steps
    HomePage homePage;

    @Given("I am on the login page")
    public void amOnTheLoginPage(){
        loginPage.openPage();
        loginPage.validdateOnLoginPage();
    }
    @When("I input username")
    public void inputUsername(){
        loginPage.inputUsername("bagas");
    }
    @And("I input valid password")
    public void inputValidPassword(){
        loginPage.inputValidPassword("Bagas09*");
    }
    @And("I click login button")
    public void clicLoginButton(){
        loginPage.clicLoginButton();
    }
    @Then("I am on the page home")
    public void amOnThePageHome(){
        homePage.validateOnHomePage();
    }
}
