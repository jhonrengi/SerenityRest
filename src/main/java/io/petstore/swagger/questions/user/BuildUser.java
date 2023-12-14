package io.petstore.swagger.questions.user;

import io.petstore.swagger.models.user.PostUserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BuildUser implements Question <PostUserModel> {

    private final String id;
    private final String username;
    private final String firstname;
    private final String lastname;

    public BuildUser(String id, String username, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public PostUserModel answeredBy(Actor actor) {

        PostUserModel userData = PostUserModel.builder()
                .id(Long.parseLong(id))
                .username(username)
                .firstName(firstname)
                .lastName(lastname)
                .email("emailprueba@prueba.com")
                .password("111111")
                .build();
        return userData;
    }

    public static BuildUser was(String id, String username, String firstname, String lastname){
        return new BuildUser(id,username,firstname,lastname);
    }
}
