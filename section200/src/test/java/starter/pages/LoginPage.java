package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private By username() {
        return By.id("userName");
    }
    private By password() {
        return By.id("password");
    }
    private By loginButton() {
        return By.id("login");
    }

    @Step
    public void openPage() {
       open();
    }
    @Step
    public void validdateOnLoginPage() {
        $(loginButton()).isDisabled();
    }
    @Step
    public void inputUsername(String username) {
        $(username()).type(username);
    }
    @Step
    public void inputValidPassword(String password){
        $(password()).type(password);
    }
    @Step
    public void clicLoginButton(){
        $(loginButton()).click();
    }
}