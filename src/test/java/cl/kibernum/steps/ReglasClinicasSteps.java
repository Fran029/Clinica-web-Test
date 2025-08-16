package cl.kibernum.steps;

import cl.kibernum.pages.FichaClinicaPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;

public class ReglasClinicasSteps {

    private final FichaClinicaPage fichaClinicaPage = new FichaClinicaPage();

    @When("el paciente es menor de {int} años")
    public void el_paciente_es_menor_de_12_años(int edadLimite) {
        Integer edad = fichaClinicaPage.getAge();        
        Assertions.assertTrue(edad < edadLimite);
    }

    @Then("debe ser paciente {string}")
    public void debe_ser_paciente(String tipoPacienteEsperado) {
        String diagnostico = fichaClinicaPage.getDiagnosis();
        assertEquals(tipoPacienteEsperado, diagnostico);
    }

    @When("no se completa el tratamiento")
    public void no_se_completa_el_tratamiento() {
        fichaClinicaPage.enterTreatment(null);
    }

    @Then("no se puede guardar la ficha clínica")
    public void no_se_puede_guardar_la_ficha_clínica() {
        List<String> mensajes = fichaClinicaPage.getMessages();
        assertFalse("No apareció mensaje de error", mensajes.isEmpty());
        assertTrue(
            "El mensaje de error no menciona tratamiento",
            mensajes.stream().anyMatch(m -> m.toLowerCase().contains("tratamiento"))
        );
    }
}
