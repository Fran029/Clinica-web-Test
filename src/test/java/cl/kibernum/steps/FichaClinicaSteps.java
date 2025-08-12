package cl.kibernum.steps;
import cl.kibernum.pages.FichaClinica;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FichaClinicaSteps {
    private FichaClinica fichaClinica;

    @Given("que el usuario está en el formulario de ficha clínica")
    public void que_el_usuario_está_en_el_formulario_de_ficha_clínica() {
        fichaClinica.navigateTo();
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