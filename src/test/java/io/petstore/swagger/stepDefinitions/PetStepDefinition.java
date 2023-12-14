package io.petstore.swagger.stepDefinitions;
/*
 * @(#) PetStepDefinition.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.cucumber.java.en.*;
import io.petstore.swagger.models.pet.PostPetModel;
import io.petstore.swagger.questions.pet.ResponseServerCode;
import io.petstore.swagger.tasks.pet.PostPetTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.petstore.swagger.constants.Constants.URL_BASE_PET;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


public class PetStepDefinition {
    private  static final String restAPI= URL_BASE_PET;

    @When("I consume the endpoint {string} and I send the user information id {string}, nameCategory {string} namePet {string}")
    public void sendInfoPet(String endpoint, String id, String nameCategory, String namePet) {
        Actor user= Actor.named("user")
                .whoCan(CallAnApi.at(restAPI));
        user.attemptsTo(
                PostPetTask.fromPet(endpoint,id,nameCategory,namePet)
        );


    }
    @Then("I can validate the response service {int}")
    public void iCanValidateTheResponseService(Integer code) {
        Actor user= Actor.named("user");

        user.should(
                seeThat(
                        "The response code is", ResponseServerCode.was(),equalTo(code)
                )
        );

    }
}
