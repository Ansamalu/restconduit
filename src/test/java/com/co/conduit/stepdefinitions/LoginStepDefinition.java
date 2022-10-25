package com.co.conduit.stepdefinitions;

import com.co.conduit.questions.GetToken;
import com.co.conduit.questions.VerifyLogin;
import com.co.conduit.tasks.PostLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import static com.co.conduit.utils.Constants.URL;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinition {

    Actor Anni = Actor.named("Anni is a web user");

    @Given("Anni enter the page Conduit")
    public void anniEnterThePageConduit() {
      Anni.whoCan(CallAnApi.at(URL));
    }

    @When("she enter the personal credentials")
    public void sheEnterThePersonalCredentials() {
        Anni.attemptsTo(PostLogin.consume());
    }
    @Then("she should login successfully")
    public void sheShouldLoginSuccessfully() {
        Anni.should(GivenWhenThen.seeThat("Status code",
                VerifyLogin.credentials(), equalTo(200)));

        Anni.should(GivenWhenThen.seeThat("Status code",
                GetToken.obtain(), Matchers.equalTo(Boolean.FALSE)));
    }

}
