package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PingStepDefinition {
    @When("El usuario admin consume el servicio PING")
    public void elUsuarioAdminConsumeElServicioPING() {

    }

    @Then("El servidor me responde el codigo de estado {int} con el mensaje CREATED")
    public void elServidorMeRespondeElCodigoDeEstadoConElMensajeCREATED(int arg0) {
    }
}
