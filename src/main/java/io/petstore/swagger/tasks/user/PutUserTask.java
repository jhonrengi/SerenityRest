package io.petstore.swagger.tasks.user;

import io.petstore.swagger.models.user.PutUserModel;

import io.petstore.swagger.questions.user.BuildUserPut;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUserTask implements Task {

    private final String endPoint;
    private final String id;
    private final String username;
    private final String firstname;
    private final String lastname;


    public PutUserTask(String endPoint, String id, String username, String firstname, String lastname) {
        this.endPoint = endPoint;
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        PutUserModel userInfo = actor.asksFor(BuildUserPut.was(id,username,firstname,lastname));
        actor.attemptsTo(
                Put.to(endPoint).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }

    public static PutUserTask fromUser(String endPoint, String id, String username, String firstname, String lastname){

        return  instrumented(PutUserTask.class, endPoint,id,username,firstname,lastname);
    }
}
