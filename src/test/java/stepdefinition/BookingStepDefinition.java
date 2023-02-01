package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import task.booking.DeleteBooking;
import task.booking.FindById;
import task.booking.FindByName;
import task.booking.UpdateNameClient;

import static stepdefinition.SetupStepDefinition.admin;
import static task.booking.CreateBooking.createBooking;

public class BookingStepDefinition {

    @Given("que el usuario admin crea una reserva para un cliente llega el {string} y se va el {string} con un {string}")
    public void queElUsuarioAdminCreaUnaReservaParaUnClienteLlegaElYSeVaElConUn(String checkin,String checkout,String additionalneeds) {
        admin.attemptsTo(createBooking().withAdditionalneeds(additionalneeds).withCheckout(checkout).withChekin(checkin));

    }
    @Then("el sistema debera de traer la reserva cuando la busca con filtro de nombre")
    public void elSistemaDeberaDeTraerLaReservaCuandoLaBuscaConFiltroDeNombre() {
        admin.attemptsTo(FindByName.ofClient());

    }

    @When("el usuario admin corrige el {string} del cliente")
    public void elUsuarioAdminCorrigueElLastnameDelCliente(String name) {
        admin.attemptsTo(UpdateNameClient.ofBooking().withName(name));
    }

    @Then("el sistema debera de traer la reserva cuando la busca con filtro de apellido")
    public void elSistemaDeberaDeTraerLaReservaCuandoLaBuscaConFiltroDeApellido() {
        
    }

    @And("usando el BookingId")
    public void usandoElBookingId() {
        admin.attemptsTo(FindById.ofBooking());
    }

    @Then("el usuario admin elimina la reserva")
    public void elUsuarioAdminEliminaLaReserva() {
        admin.attemptsTo(DeleteBooking.ofBooking());
    }

    @Then("el sistema debera de traer la reserva cuando la busca con filtro de checkin")
    public void elSistemaDeberaDeTraerLaReservaCuandoLaBuscaConFiltroDeCheckin() {
        
    }

    @Given("que el usuario admin obtiene el bookingId de una reserva existente")
    public void queElUsuarioAdminObtieneElBookingIdDeUnaReservaExistente() {
        
    }

    @And("obtenie los datos completos de la reserva")
    public void obtenieLosDatosCompletosDeLaReserva() {
        
    }

    @When("El usuario  admin actualiza la reserva enviando los datos completos de la reserva")
    public void elUsuarioAdminActualizaLaReservaEnviandoLosDatosCompletosDeLaReserva() {
        
    }

    @Then("Los datos de la reserva actualizada")
    public void losDatosDeLaReservaActualizada() {

    }


}
