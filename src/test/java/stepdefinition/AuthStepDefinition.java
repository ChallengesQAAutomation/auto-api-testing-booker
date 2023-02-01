package stepdefinition;

import io.cucumber.java.en.Given;

import static stepdefinition.SetupStepDefinition.admin;
import static task.auth.AuthToken.getToken;

public class AuthStepDefinition {
    @Given("que el usuario administrador obtenien el token de seguridad")
    public void queElUsuarioAdministradorObtenienElTokenDeSeguridad() {
        admin.attemptsTo(getToken());

    }
}
