package cl.kibernum.steps;

import cl.kibernum.pages.FichaClinicaPage;
import cl.kibernum.pages.LoginDoctorPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FichaClinicaSteps {
    private FichaClinicaPage fichaClinica = new FichaClinicaPage();
    private LoginDoctorPage loginDoctor = new LoginDoctorPage();

    @Given("que el usuario ingresa a ficha clínica accediendo con usuario {string} y clave {string}")
    public void que_el_usuario_ingresa_a_ficha_clínica_accediendo_con_usuario_y_clave(String usuario, String clave) {
        loginDoctor.navigateTo();
        loginDoctor.login("doctor", "password");
    }

    @When("^completa la ficha con (.*), (.*), (\\d*) y (.*)$")
    public void completa_la_ficha_con_paciente_diagnostico_edad_y_tratamiento(String paciente, String diagnostico,
            String edad, String tratamiento) {
        fichaClinica.enterMedicalFile(paciente, diagnostico, edad, tratamiento);
    }

    @Then("recibe los mensajes")
    public void recibe_los_mensajes(DataTable expectedMessages) {
        List<String> expected = expectedMessages.asList()
                .stream()
                .filter(msg -> msg != null && !msg.isBlank())
                .collect(Collectors.toList());
        System.out.println("mensaje esperado: " + expected);
        List<String> actual = fichaClinica.getMessages();
        System.out.println("mensaje recibido: " + actual);
        assertTrue(actual.containsAll(expected),
                "No se encontraron todos los mensajes esperados.\nEsperados: " + expected + "\nActuales: " + actual);
    }

}