package io.petstore.swagger.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import io.petstore.swagger.questions.user.ResponseCode;
import io.petstore.swagger.tasks.user.GetUserTask;
import io.petstore.swagger.tasks.user.PostUserTask;
import io.petstore.swagger.tasks.user.PutUserTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.petstore.swagger.constants.Constants.URL_BASE_USER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class UserStepDefinition {

    private  static final String restAPI= URL_BASE_USER;
    @When("I consume the endpoint {string} and I send the user information id {string}, username {string} firstname {string} lastname {string}")
    public void sendInfoUser(String endpoint, String id, String username, String firstname, String lastname) {
        Actor user= Actor.named("user")
                .whoCan(CallAnApi.at(restAPI));
        user.attemptsTo(
                PostUserTask.fromUser(endpoint,id,username,firstname,lastname)
        );
    }


    @Then("I can validate the response services {int}")
    public void iCanValidateTheResponseServices(Integer code) {
        Actor user= Actor.named("user");

       user.should(
               seeThat(
                      "The response code is",ResponseCode.was(),equalTo(code) //ResponseCode.was(),equalTo(code)
               )
        );
    }

    @When("I consume the endpoint {string} and I send the user information username {string}")
    public void getInfoUser(String endpoint, String username) {
        Actor user= Actor.named("user")
                .whoCan(CallAnApi.at(restAPI));
        user.attemptsTo(
                GetUserTask.getUser(endpoint)
        );
    }
    @Then("I can validate the answer service {int}")
    public void i_can_validate_the_answer_service(Integer int1) {
        Actor user= Actor.named("user");

        user.should(
                seeThat(
                        "The response code is",ResponseCode.was(),equalTo(int1)
                )
        );
    }

    @When("I consume the endpoint {string} and I update the user's information id {string}, username {string} firstname {string} lastname {string}")
    public void updateInfoUser(String endpoint, String id, String username, String firstname, String lastname) {
        Actor user= Actor.named("user")
                .whoCan(CallAnApi.at(restAPI));
        user.attemptsTo(
                PutUserTask.fromUser(endpoint,id,username,firstname,lastname)
        );
    }
    @Then("can validate the response services {int}")
    public void canValidateTheResponseServices(Integer int1) {
        Actor user= Actor.named("user");

        user.should(
                seeThat(
                        "The response code is",ResponseCode.was(),equalTo(int1)
                )
        );
    }




}
