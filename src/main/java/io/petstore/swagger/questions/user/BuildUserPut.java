package io.petstore.swagger.questions.user;

import io.petstore.swagger.models.user.PutUserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BuildUserPut implements Question <PutUserModel> {

    private final String id;
    private final String username;
    private final String firstname;
    private final String lastname;


    public BuildUserPut(String id, String username, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public PutUserModel answeredBy(Actor actor) {

        PutUserModel userData = PutUserModel.builder()
                .id(Long.parseLong(id))
                .username(username)
                .firstName(firstname)
                .lastName(lastname)
                .email("emailprueba@prueba.com")
                .password("111111")
                .build();
        return userData;
    }

    public static BuildUserPut was(String id, String username, String firstname, String lastname){
        return new BuildUserPut(id,username,firstname,lastname);
    }
}
