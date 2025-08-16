package cl.kibernum.steps;

import org.junit.jupiter.api.Assertions;

import cl.kibernum.pages.LoginDoctorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDoctorSteps {
    private LoginDoctorPage loginDoctor = new LoginDoctorPage();

    @Given("que el usuario accede a la página de login")
    public void que_el_usuario_accede_a_la_página_de_login() {
        loginDoctor.navigateTo();
    }

    @When("ingresa credenciales válidas")
    public void ingresa_credenciales_validas() {
       loginDoctor.login("doctor", "password");
    }
    

    @Then("accede a la ficha clínica")
    public void accede_la_ficha_clinica() {
        Assertions.assertTrue(loginDoctor.failedLoginMessage().isEmpty(), "No debería haber mensaje de error");
    }

    @When("ingresa credenciales inválidas")
    public void ingresa_credenciales_invalidas() {
       loginDoctor.login("userError", "passwordError");
    }
    
     @Then("debería ver el mensaje de error de login")
    public void deberia_ver_el_mensaje_de_error_de_login() {
        Assertions.assertTrue(loginDoctor.failedLoginMessage().contains("Credenciales inválidas."), "Debiera arrojar mensaje de error");
    }
}