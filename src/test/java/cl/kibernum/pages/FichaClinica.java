package cl.kibernum.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cl.kibernum.hooks.DriverHolder;
import java.time.Duration;

public class FichaClinica {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    private By nameField = By.id("nombre");
    private By diagnosisField = By.id("diagnostico");
    private By ageField = By.id("edad");
    private By treatmentField = By.id("tratamiento");
    private By buttonSave = By.xpath("//*[@id='record-form']/button[@type='submit']");
    private By messageContainer = By.xpath("//*[@id='record-message']/div[@role='alert']");
    private By message = By.xpath("//*[@id='record-message']/div[@role='alert']/ul");

    WebDriver getDriver() {
        return DriverHolder.get();
    }

    public void enterName(String name) {
        getDriver().findElement(nameField).clear();
        getDriver().findElement(nameField).sendKeys(name);
    }

    public void enterDiagnosis(String diagnosis) {
        getDriver().findElement(diagnosisField).clear();
        getDriver().findElement(diagnosisField).sendKeys(diagnosis);
    }

    public void enterAge(String age) {
        getDriver().findElement(ageField).clear();
        //String stringAge = String.valueOf(age);
        getDriver().findElement(ageField).sendKeys(age);
    }

    public void enterTreatment(String treatment) {
        getDriver().findElement(treatmentField).clear();
        getDriver().findElement(treatmentField).sendKeys(treatment);
    }

    public void clickButtonSave() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSave)).click();
        // wait.until(ExpectedConditions.presenceOfElementLocated(messageContainer));
    }

public List<String> getMessages() {
    // Esperamos a que aparezca el contenedor de mensajes
    wait.until(ExpectedConditions.visibilityOfElementLocated(messageContainer));

    // Buscamos <li> dentro del mensaje
    List<WebElement> elements = getDriver().findElements(message);

    if (elements.isEmpty()) {
        // Si no hay <li>, devolvemos el mensaje único
        WebElement singleMessage = getDriver().findElement(messageContainer);
        String text = singleMessage.getText().trim();
        return text.isBlank() ? List.of() : List.of(text);
    }

    // Si hay <li>, devolvemos todos
    return elements.stream()
            .map(WebElement::getText)
            .filter(text -> !text.isBlank())
            .collect(Collectors.toList());
}

    public void enterMedicalFile(String name, String diagnosis, String age, String treatment) {
        enterName(name);
        enterDiagnosis(diagnosis);
        enterAge(age);
        enterTreatment(treatment);
        clickButtonSave();
    }

    public String getName() {
        return getDriver().findElement(nameField).getText();
    }

    public String getDiagnosis() {
        return getDriver().findElement(diagnosisField).getText();
    }

    public int getAge() {
        String value = getDriver().findElement(ageField).getText();
        return Integer.parseInt(value);
    }

    public String getTreatment() {
        return getDriver().findElement(treatmentField).getText();
    }
}
