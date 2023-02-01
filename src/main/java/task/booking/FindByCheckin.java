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


public class FindByCheckin implements Task {
    ResponseBooking responseBooking;
    String response,checkin;
    public FindByCheckin() {
    }

    public static FindByCheckin ofBooking() {
        return instrumented(FindByCheckin.class);
    }
    private static final Logger logger = LogManager.getLogger(FindByCheckin.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        responseBooking=actor.recall(RESPONSE_BOOKING);
        actor.attemptsTo(Get.resource("/booking").with(resquest->resquest
                                .queryParam("chekin",responseBooking.getBooking().getBookingdates().getCheckin())));
        response= SerenityRest.lastResponse().asString();
        actor.attemptsTo(Ensure.that(response).contains(responseBooking.getBookingid()+""));
        logger.info("Buscando por fecha de llegada......");

    }
}
