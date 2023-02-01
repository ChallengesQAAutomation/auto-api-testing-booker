package task.booking;

import model.Booking.response.ResponseBooking;
import model.Booking.response.find.ResponseBookingFind;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static util.Contants.RESPONSE_BOOKING;


public class FindById implements Task {
    ResponseBooking responseBooking;
    String response;
    public FindById() {
    }

    public static FindById ofBooking() {
        return instrumented(FindById.class);
    }
    private static final Logger logger = LogManager.getLogger(FindById.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        responseBooking=actor.recall(RESPONSE_BOOKING);
        actor.attemptsTo(Get.resource("/booking/"+responseBooking.getBookingid()));
        response= SerenityRest.lastResponse().asString();
        actor.attemptsTo(Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200));
        logger.info("Buscando por id......");

    }
}
