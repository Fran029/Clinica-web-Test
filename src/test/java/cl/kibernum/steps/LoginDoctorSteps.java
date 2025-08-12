package cl.kibernum.steps;

import cl.kibernum.pages.LoginDoctor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDoctorSteps {
    private LoginDoctor loginDoctor;

    @Given("ue el usuario accede a la página de login")
    public void que_el_usuario_accede_a_la_página_de_login() {
        loginDoctor.navigateTo();
    }

    @When("ingresa el usuario (.+) y la clave (.+)")
    public void ingresa_el_usuario_y_la_clave(String usuario, String password) {
       loginDoctor.login(usuario, password);
    }
    

    @Then("debería ver el mensaje '{string}'")
    public void debería_ver_el_mensaje() {
        loginDoctor.failedLoginMessage();
    }

}