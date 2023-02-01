package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static question.ping.VerifyServices.verifyServices;
import static stepdefinition.SetupStepDefinition.admin;
import static task.ping.HealthCheck.consumePingServices;
import static task.ping.HealthCheck.verifyServices;

public class PingStepDefinition {
    @When("El usuario admin consume el servicio PING")
    public void elUsuarioAdminConsumeElServicioPING() {
        admin.attemptsTo(consumePingServices());

    }

    @Then("El servidor me responde el codigo de estado {int} con el mensaje CREATED")
    public void elServidorMeRespondeElCodigoDeEstadoConElMensajeCREATED(int code) {
        admin.should(seeThat(verifyServices()));
    }
}
