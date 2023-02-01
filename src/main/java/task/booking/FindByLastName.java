package task.booking;

import model.Booking.response.ResponseBooking;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static util.Contants.NAME_UPDATED;
import static util.Contants.RESPONSE_BOOKING;


public class FindByLastName implements Task {
    ResponseBooking responseBooking;
    String response;
    public FindByLastName() {
    }

    public static FindByLastName ofClient() {
        return instrumented(FindByLastName.class);
    }
    private static final Logger logger = LogManager.getLogger(FindByLastName.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        responseBooking=actor.recall(RESPONSE_BOOKING);
        actor.attemptsTo(Get.resource("/booking").with(resquest->resquest
                                .queryParam("lastname",responseBooking.getBooking().getLastname())));
        response= SerenityRest.lastResponse().asString();
        actor.attemptsTo(Ensure.that(response).contains(responseBooking.getBookingid()+""));
        logger.info("Buscando por apellido......");

    }
}
