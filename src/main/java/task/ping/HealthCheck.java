package task.ping;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static util.Contants.MESSAGE_VERIFY_SERVICE;


public class HealthCheck implements Task {
    public HealthCheck() {
    }

    public static HealthCheck consumePingServices() {
        return instrumented(HealthCheck.class);
    }
    private static final Logger logger = LogManager.getLogger(HealthCheck.class);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Get.resource("/ping"));
        logger.info("PING......");

    }
}
