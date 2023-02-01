package task.auth;

import model.Auth.RequestAuth;
import model.Auth.ResponseAuth;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static util.Contants.TOKEN;

public class AuthToken implements Task {
    RequestAuth requestAuth;
    ResponseAuth responseAuth;
    String response;
    public AuthToken() {
    }


    public static AuthToken getToken() {
        return instrumented(AuthToken.class);
    }
    private static final Logger logger = LogManager.getLogger(AuthToken.class);
    @Override

    public <T extends Actor> void performAs(T actor) {
        logger.info("Auth Token................");
        requestAuth = new RequestAuth.Builder().build();
        actor.attemptsTo(
                Post.to("/auth")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body(requestAuth)
                        )
        );
        response= SerenityRest.lastResponse().asString();
        responseAuth= from(response).getObject("",ResponseAuth.class);
        actor.remember(TOKEN,responseAuth.getToken());

    }
}
