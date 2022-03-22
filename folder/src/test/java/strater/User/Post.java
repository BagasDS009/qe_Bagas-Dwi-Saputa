package strater.User;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Post {
    protected String url = "https://reqres.in/api/";

    @Step("I set post api endpoint")
    public String setPostApiEndPoints(){
        return url + "users";
    }

    @Step("I send post http request")
    public void sendPostHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name","morpheus");
        requestBody.put("job","leader");
        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).post(setPostApiEndPoints());
    }
    @Step("I receive valid http response code 201")
    public void receiveValidHttpResonseCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }
    @Step("I receive valid data for new user")
    public void receiveValidDataForNewUser() {
        restAssuredThat(response -> response.body("'name'", equalTo("morpheus")));
        restAssuredThat(response -> response.body("'job'", equalTo("leader")));
    }
}
