package cl.kibernum.steps;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import cl.kibernum.pages.FichaClinicaPage;

public class ReglasClinicasSteps {

    private FichaClinicaPage fichaClinicaPage = new FichaClinicaPage();;  

    @Then("debe ver el mensaje de error {string}")
    public void debeVerElMensajeDeError(String mensajeEsperado) {
        List<String> diagnostico = fichaClinicaPage.getMessages();
        assertTrue(diagnostico.contains(mensajeEsperado));
    }

    @Then("debe ver los siguientes mensajes de error:")
    public void debeVerLosSiguientesMensajesDeError(DataTable dataTable) {
        List<String> mensajes = dataTable.asList();
        List<String> textoMensaje = fichaClinicaPage.getMessages();
               
        assertEquals( textoMensaje, mensajes);
    }
}
