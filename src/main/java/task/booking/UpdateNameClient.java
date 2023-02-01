package task.booking;

import io.restassured.http.Cookie;
import model.Booking.request.RequestBooking;
import model.Booking.response.ResponseBooking;
import model.Booking.response.update.ResponseBookingUpdate;
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
import static util.Contants.*;

public class UpdateNameClient implements Task {

    ResponseBookingUpdate responseBooking;
    String response,name="Luis",requestBooking="",token;
    Integer bookingId;
    Cookie cookie;

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

        requestBooking ="{\n" +
                "    \"firstname\" : \""+name+"\""+
                "}";
        bookingId=actor.recall(BOOKINGID);
        token=actor.recall(TOKEN);
        cookie = new Cookie.Builder("token", token).build();
        actor.attemptsTo(
                Patch.to("/booking/"+bookingId)
                        .with(requestSpec -> requestSpec.
                                cookie(cookie).
                                header("Content-Type", "application/json")
                               .body(requestBooking).log().all()
                        )
        );
        response= SerenityRest.lastResponse().asString();
        responseBooking= from(response).getObject("",ResponseBookingUpdate.class);
        logger.info("Actualizado el nombre de la reserva");

    }
}
