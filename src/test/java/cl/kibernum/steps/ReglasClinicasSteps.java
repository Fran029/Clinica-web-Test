package cl.kibernum.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class ReglasClinicasSteps {

    private Integer edadPaciente;
    private String diagnostico;

    @When("el paciente es menor de {int} años")
    public void el_paciente_es_menor_de_años(Integer edadLimite) {
        edadPaciente = 10; // ejemplo, o traído de contexto
        assertTrue("Paciente no es menor de " + edadLimite, edadPaciente < edadLimite);
    }

    @Then("debe ser paciente {string}")
    public void debe_ser_paciente(String tipoPacienteEsperado) {
        diagnostico = "Pediátrico"; // ejemplo
        assertEquals(tipoPacienteEsperado, diagnostico);
    }

    @When("no se completa el tratamiento")
    public void no_se_completa_el_tratamiento() {
        // simular que el tratamiento está vacío o nulo
    }

    @Then("no se puede guardar la ficha clínica")
    public void no_se_puede_guardar_la_ficha_clínica() {
        // lógica para validar que no se guarda
        fail("No se puede guardar la ficha porque faltan datos");
    }
}

