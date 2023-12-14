package io.petstore.swagger.tasks.user;

import io.petstore.swagger.models.user.PostUserModel;
import io.petstore.swagger.questions.user.BuildUser;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostUserTask implements Task {
    private final String endPoint;
    private final String id;
    private final String username;
    private final String firstname;
    private final String lastname;

    public PostUserTask(String endPoint, String id, String username, String firstname, String lastname) {
        this.endPoint = endPoint;
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        PostUserModel userInfo = actor.asksFor(BuildUser.was(id,username,firstname,lastname));
        actor.attemptsTo(
                Post.to(endPoint).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }

    public static PostUserTask fromUser(String endPoint, String id, String username, String firstname, String lastname){

        return  instrumented(PostUserTask.class, endPoint,id,username,firstname,lastname);
    }
}
