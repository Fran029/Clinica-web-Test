package cl.kibernum.steps;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import cl.kibernum.pages.FichaClinicaPage;
import cl.kibernum.pages.LoginDoctorPage;

public class ReglasClinicasSteps {

    private FichaClinicaPage fichaClinicaPage = new FichaClinicaPage();
    private LoginDoctorPage loginDoctor = new LoginDoctorPage();

    @Given("que el doctor está en la página de la ficha clínica")
    public void que_el_usuario_ingresa_a_ficha_clínica_accediendo_con_usuario_y_clave() {
        loginDoctor.navigateTo();
        loginDoctor.login("doctor", "password");
    }

    @Given("^completa el nombre del paciente (.*), el diagnóstico (.*), la edad (.*) y el tratamiento (.*) y guarda la ficha$")
    public void completa_la_ficha_con_paciente_diagnostico_edad_y_tratamiento(String paciente, String diagnostico,
            String edad, String tratamiento) {
        fichaClinicaPage.enterMedicalFile(paciente, diagnostico, edad, tratamiento);
    }

    @Then("^debe ver el mensaje de error (.*)")
    public void debeVerElMensajeDeError(String mensajeEsperado) {
        List<String> diagnostico = fichaClinicaPage.getMessages();
        Assertions.assertTrue(diagnostico.contains(mensajeEsperado),
                "No se encontró el mensaje esperado.\nEsperado: "
                        + mensajeEsperado + "\nActuales: " + diagnostico);
    }

    @Then("debe ver los siguientes mensajes de error:")
    public void debeVerLosSiguientesMensajesDeError(DataTable dataTable) {
        List<String> mensajes = dataTable.asList();
        List<String> textoMensaje = fichaClinicaPage.getMessages();

        Assertions.assertTrue(mensajes.containsAll(textoMensaje));
    }
}