package cl.kibernum.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cl.kibernum.hooks.DriverHolder;
import java.time.Duration;

public class FichaClinicaPage {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    private By nameField = By.id("nombre");
    private By diagnosisField = By.id("diagnostico");
    private By ageField = By.id("edad");
    private By treatmentField = By.id("tratamiento");
    private By buttonSave = By.xpath("//*[@id='record-form']/button[@type='submit']");
    private By messageContainer = By.xpath("//*[@id='record-message']/div[@role='alert']");
    private By message = By.xpath("//*[@id='record-message']/div[@role='alert']/ul/li");

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
        getDriver().findElement(ageField).sendKeys(age);
    }

    public void enterTreatment(String treatment) {
        getDriver().findElement(treatmentField).clear();
        getDriver().findElement(treatmentField).sendKeys(treatment);
    }

    public void clickButtonSave() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSave)).click();
    }

    public List<String> getMessages() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(messageContainer));

            List<WebElement> elements = getDriver().findElements(message);

            if (elements.isEmpty()) {
                WebElement singleMessage = getDriver().findElement(messageContainer);
                String text = singleMessage.getText().trim();
                return text.isBlank() ? List.of() : List.of(text);
            }

            return elements.stream()
                    .map(e -> e.getText())
                    .filter(text -> !text.isBlank())
                    .collect(Collectors.toList());
        } catch (TimeoutException e) {
            return List.of();
        }
    }

    public void enterMedicalFile(String name, String diagnosis, String age, String treatment) {
        enterName(name);
        enterDiagnosis(diagnosis);
        enterAge(age);
        enterTreatment(treatment);
        clickButtonSave();
    }

    public String getName() {
        return getDriver().findElement(nameField).getAttribute("value");
    }

    public String getDiagnosis() {
        return getDriver().findElement(diagnosisField).getAttribute("value");
    }

    public Integer getAge() {
        String value = getDriver().findElement(ageField).getAttribute("value");
        return Integer.parseInt(value);
    }

    public String getTreatment() {
        return getDriver().findElement(treatmentField).getAttribute("value");
    }

}
