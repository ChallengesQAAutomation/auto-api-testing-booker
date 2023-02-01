package stepdefinition;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static util.DataReader.getData;

public class SetupStepDefinition {
    public static Actor admin;
    private static final Logger logger = LogManager.getLogger(SetupStepDefinition.class);
    @Before
    public void prepareStage() {
        String theRestApiBaseUrl = getData("base.url");
        logger.info("\n Running......Env \n {} con la Base Url \n {} ",System.getProperty("env"), theRestApiBaseUrl);
        admin = Actor.named("Administrador del gestor de reservas")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));
        OnStage.setTheStage(new OnlineCast());
    }

}
