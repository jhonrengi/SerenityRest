package io.petstore.swagger.tasks.user;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUserTask implements Task {

    private final String endPoint;


    public GetUserTask(String endPoint) {
        this.endPoint = endPoint;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/user/carlos24")
        );
    }

    public static GetUserTask getUser ( String endPoint){
        return  instrumented(GetUserTask.class, endPoint);
    }
}
