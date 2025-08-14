package cl.kibernum.steps;
import cl.kibernum.pages.FichaClinica;
import cl.kibernum.pages.LoginDoctor;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FichaClinicaSteps {
    private FichaClinica fichaClinica = new FichaClinica();
    private LoginDoctor loginDoctor = new LoginDoctor();

    @Given("que el usuario ingresa a ficha clínica accediendo con usuario {string} y clave {string}")
    public void que_el_usuario_ingresa_a_ficha_clínica_accediendo_con_usuario_y_clave(String usuario, String clave) {
        loginDoctor.navigateTo();
        loginDoctor.login(usuario, clave);
    }
  
   @When("^completa la ficha con (.+), (.+), (\\d+) y (.+)$")
    public void completa_la_ficha_con_paciente_diagnostico_edad_y_tratamiento(String paciente, String diagnostico, int edad, String tratamiento) {
        fichaClinica.enterMedicalFile(paciente, diagnostico, edad, tratamiento);
    }

    @Then("recibe el mensaje {string}")
    public void recibe_el_mensaje(List<String> mensajeEsperados) {
        List<String> mensajesObtenidos = fichaClinica.getMessage();

        Assertions.assertIterableEquals(mensajeEsperados, mensajesObtenidos);
    }


}