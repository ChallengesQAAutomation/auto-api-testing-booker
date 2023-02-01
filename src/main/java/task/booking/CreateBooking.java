package task.booking;

import model.Auth.RequestAuth;
import model.Auth.ResponseAuth;
import model.Booking.request.RequestBooking;
import model.Booking.response.ResponseBooking;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static util.Contants.BOOKINGID;
import static util.Contants.TOKEN;

public class CreateBooking implements Task {
    RequestBooking requestBooking;
    ResponseBooking responseBooking;
    String response,checkin="2023-02-20",checkout="2023-03-02",additionalneeds="breakfast";
    public CreateBooking() {
    }

    public CreateBooking withChekin(String checkin){
        this.checkin=checkin;
        return this;
    }
    public CreateBooking withCheckout(String checkout){
        this.checkout=checkout;
        return this;
    }
    public CreateBooking withAdditionalneeds(String additionalneeds){
        this.additionalneeds=additionalneeds;
        return this;
    }
    public static CreateBooking createBooking() {
        return instrumented(CreateBooking.class);
    }
    private static final Logger logger = LogManager.getLogger(CreateBooking.class);
    @Override

    public <T extends Actor> void performAs(T actor) {

        requestBooking = new RequestBooking.Builder().withAdditionalneeds(additionalneeds).withDate(checkin,checkout).build();
        actor.attemptsTo(
                Post.to("/booking")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body(requestBooking)
                        )
        );
        response= SerenityRest.lastResponse().asString();
        responseBooking= from(response).getObject("",ResponseBooking.class);
        actor.remember(BOOKINGID,responseBooking.getBookingid());
        logger.info("Created Booking");

    }
}
