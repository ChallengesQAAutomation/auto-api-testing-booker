package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static stepdefinition.SetupStepDefinition.admin;
import static task.ping.HealthCheck.verifyServices;

public class PingStepDefinition {
    @When("El usuario admin consume el servicio PING")
    public void elUsuarioAdminConsumeElServicioPING() {
        admin.attemptsTo(verifyServices());

    }

    @Then("El servidor me responde el codigo de estado {int} con el mensaje CREATED")
    public void elServidorMeRespondeElCodigoDeEstadoConElMensajeCREATED(int arg0) {
    }
}
