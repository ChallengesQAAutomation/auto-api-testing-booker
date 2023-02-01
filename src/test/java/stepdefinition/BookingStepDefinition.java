package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import task.booking.UpdateNameClient;

import static stepdefinition.SetupStepDefinition.admin;
import static task.booking.CreateBooking.createBooking;

public class BookingStepDefinition {
    @Given("que el usuario admin crea una reserva para un cliente llega el (.*) y se va el (.*) con un (.*)")
    public void queElUsuarioAdminCreaUnaReservaParaUnClienteLlegaElCheckinYSeVaElCheckoutConUnAdditionalneeds(String checkin,String checkout,String additionalneeds) {
        admin.attemptsTo(createBooking().withAdditionalneeds(additionalneeds).withCheckout(checkout).withChekin(checkin));
    }
    @Then("el sistema debera de traer la reserva cuando la busca con filtro de nombre")
    public void elSistemaDeberaDeTraerLaReservaCuandoLaBuscaConFiltroDeNombre() {

    }

    @When("el usuario admin corrige el (.*) del cliente")
    public void elUsuarioAdminCorrigueElLastnameDelCliente(String name) {
        admin.attemptsTo(UpdateNameClient.ofBooking().withName(name));
    }

    @Then("el sistema debera de traer la reserva cuando la busca con filtro de apellido")
    public void elSistemaDeberaDeTraerLaReservaCuandoLaBuscaConFiltroDeApellido() {
        
    }

    @And("usando el BookingId")
    public void usandoElBookingId() {
        
    }

    @Then("el usuario admin elimina la reserva")
    public void elUsuarioAdminEliminaLaReserva() {
        
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
