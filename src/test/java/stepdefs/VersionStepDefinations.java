package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by vivek on 9/8/17.
 */
public class VersionStepDefinations {


    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String ENDPOINT_GET_BOOK_BY_ISBN = "http://localhost:9441/version";


    @Given("version exist")
    public void verionExits() {
        request = given();
    }

    @When("a user retrieves version")
    public void a_user_retrieves_version() {
        response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
        System.out.println("response: " + response.prettyPrint());
    }

    @Then("status code is (\\d+)")
    public void verify_status_code2(int statusCode) {
        json = response.then().statusCode(statusCode);
    }

    @And("response includes the following items")
    public void response_equals(Map<String,String> responseFields){
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }


}




