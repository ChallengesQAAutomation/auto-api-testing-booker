package task.booking;

import model.Booking.request.RequestBooking;
import model.Booking.response.ResponseBooking;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static util.Contants.BOOKINGID;
import static util.Contants.RESPONSE_BOOKING;

public class UpdateNameClient implements Task {

    ResponseBooking responseBooking;
    String response,name="Luis",requestBooking="";
    Integer bookingId;
    public UpdateNameClient() {
    }

    public UpdateNameClient withName(String name){
        this.name=name;
        return this;
    }

    public static UpdateNameClient ofBooking() {
        return instrumented(UpdateNameClient.class);
    }
    private static final Logger logger = LogManager.getLogger(UpdateNameClient.class);
    @Override

    public <T extends Actor> void performAs(T actor) {

        requestBooking ="{" + "\"firstname\":\""+name+"}";
        actor.attemptsTo(
                Patch.to("/booking")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body(requestBooking)
                        )
        );
        response= SerenityRest.lastResponse().asString();
        responseBooking= from(response).getObject("",ResponseBooking.class);
        bookingId=actor.recall(BOOKINGID);
        actor.attemptsTo(Ensure.that(responseBooking.getBookingid()).isEqualTo(bookingId));
        actor.remember(RESPONSE_BOOKING,responseBooking);
        logger.info("Actualizado el nombre de la reserva");

    }
}
