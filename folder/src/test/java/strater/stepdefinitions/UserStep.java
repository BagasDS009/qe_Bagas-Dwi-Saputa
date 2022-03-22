package strater.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import strater.User.Get;
import strater.User.Post;

public class UserStep {
    @Steps
    Get get;
    Post post;

    @Given("I set get api endpoint")
    public void setGetApiEndPoints(){
        get.setGetApiEndPoints();
    }
    @When("I send get http request")
    public void sendGetHttpRequest(){
        get.sendGetHttpRequest();
    }
    @Then("I receive valid http response code 200")
    public void receiveValidHttpResonseCode200(){
        get.receiveValidHttpResonseCode200();
    }
    @And("I receive valid data for detail user")
    public void receiveValidDataForDetailUser(){
        get.receiveValidDataForDetailUser();
    }

    @Given("I set post api endpoint")
    public void setPostApiEndPoints(){

        post.setPostApiEndPoints();
    }
    @When("I send post http request")
    public void sendPostHttpRequest(){

        post.sendPostHttpRequest();
    }
    @Then("I receive valid http response code 201")
    public void receiveValidHttpResonseCode201(){

        post.receiveValidHttpResonseCode201();
    }
    @And("I receive valid data for new user")
    public void receiveValidDataForNewUser(){

        post.receiveValidDataForNewUser();
    }
}
