package strater.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get {
    protected static String url = "https://reqres.in/api/";

    @Step("I set get api endpoint")
    public String setGetApiEndPoints(){

        return url + "users/2";
    }
    @Step("I send get http request")
    public void sendGetHttpRequest(){

        SerenityRest.given().get(setGetApiEndPoints());
    }
    @Step("I receive valid http response code 200")
    public void receiveValidHttpResonseCode200(){

        restAssuredThat(reponse -> reponse.statusCode(200));
    }
    @Step("I receive valid data for detail user")
    public void receiveValidDataForDetailUser() {

        restAssuredThat(reponse -> reponse.body("'data'.'id'", equalTo(2)));
        restAssuredThat(reponse -> reponse.body("'data'.'first_name'", equalTo("Janet")));
        restAssuredThat(reponse -> reponse.body("'data'.'last_name'", equalTo("Weaver")));
    }
}
