package com.co.conduit.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

/**
 * Post something to a REST resource.
 * This is a simple interaction class suitable for simple queries.
 */
public class Post extends RestInteraction {

    private final String resource;

    public Post(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().post(as(actor).resolve(resource)).then().log().all();
    }

    public static net.serenitybdd.screenplay.rest.interactions.Post to(String resource) {
        return instrumented(net.serenitybdd.screenplay.rest.interactions.Post.class, resource);
    }

}
