package cl.kibernum.steps;
import cl.kibernum.pages.FichaClinica;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TransferenciaSteps {
    private WebDriver driver;
    private FichaClinica transferencia;

    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        transferencia = new FichaClinica(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("que el usuario ha iniciado sesión")
    public void que_el_usuario_ha_iniciado_sesion() {
        transferencia.navigateTo();
    }
     
    //@When("^transfiere (-?\\d+(\\.\\d+)?) a la cuenta (\\d{9})$")
    @When("^transfiere (-?\\d+) a la cuenta (\\d{9})$")
    public void transfiere_monto_a_la_cuenta(int monto, String cuenta) {
       transferencia.transfer(monto, cuenta);
    }

    @Then("debería ver el mensaje {string}")
    public void deberia_ver_el_mensaje(String mensajeEsperado) {
        String successMessage = transferencia.getSuccessTransferMessage();
        Assertions.assertEquals(mensajeEsperado, successMessage);
    }


}