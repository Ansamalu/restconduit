package com.co.conduit.tasks;

import com.co.conduit.models.credentials.Data;
import com.co.conduit.models.credentials.User;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostLogin implements Task {

    Data data = new Data();
    User user = new User();
    public static PostLogin consume(){
        return Tasks.instrumented(PostLogin.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        user.setEmail("carvajalanni@gmail.com");
        user.setPassword("12345");
        data.setUser(user);
        actor.attemptsTo(
                Post.to("/users/login")
                        .withRequest(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(data))
        );
    }
}
