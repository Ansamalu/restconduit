package com.co.conduit.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.co.conduit.utils.Constants.TOKEN;

public class GetToken implements Question<Boolean> {


    public static GetToken obtain(){
        return new GetToken();


    }
    @Override
    public Boolean answeredBy(Actor actor) {
        TOKEN = SerenityRest.lastResponse().path("user.token");
        return TOKEN.isEmpty();
    }
}
