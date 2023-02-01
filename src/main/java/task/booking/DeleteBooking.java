package task.booking;

import model.Booking.response.ResponseBooking;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static util.Contants.*;

public class DeleteBooking implements Task {

    Integer bookingId;
    public DeleteBooking() {
    }



    public static DeleteBooking ofBooking() {
        return instrumented(DeleteBooking.class);
    }
    private static final Logger logger = LogManager.getLogger(DeleteBooking.class);
    @Override

    public <T extends Actor> void performAs(T actor) {
        bookingId=actor.recall(BOOKINGID);
        actor.attemptsTo(
                Delete.from("/booking/"+bookingId)
                        .with(request -> request.header("Content-Type", "application/json")
                        )
        );
        actor.attemptsTo(Ensure.that(SerenityRest.lastResponse().asString()).contains(MESSAGE_DELETE));
        actor.attemptsTo(Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(201));
        logger.info("eliminada la reserva");

    }
}
