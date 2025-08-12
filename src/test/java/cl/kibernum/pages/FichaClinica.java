package cl.kibernum.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FichaClinica {
    private WebDriver driver;

    private By nameField = By.id("nombre");
    private By diagnosisField = By.id("diagnostico");
    private By ageField = By.id("edad");
    private By treatmentField = By.id("tratamiento");
    private By buttonSave = By.xpath("//*[@id='record-form']/button[@type='submit']");
    private By messageContainer = By.xpath("//*[@id='record-message']/div[@role='alert']");
    private By messageList = By.xpath("//*[@id='record-message']/div[@role='alert']/ul/li");

    public FichaClinica(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("http://127.0.0.1:5500/ficha.html");
    }

    public void enterName(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterDiagnosis(String diagnosis) {
        driver.findElement(diagnosisField).clear();
        driver.findElement(diagnosisField).sendKeys(diagnosis);
    }

    public void enterAge(int age) {
        driver.findElement(ageField).clear();
        driver.findElement(ageField).sendKeys(String.valueOf(age));
    }

    public void enterTreatment(String treatment) {
        driver.findElement(treatmentField).clear();
        driver.findElement(treatmentField).sendKeys(treatment);
    }

    public void clickButtonSave() {
        driver.findElement(buttonSave).click();
    }

    public List<String> getMessage() {
        List<WebElement> elements = driver.findElements(messageList);

        // Si no hay lista, intentamos buscar el contenedor único
        if (elements.isEmpty()) {
            elements = List.of(driver.findElement(messageContainer));
        }

        return elements.stream()
                .map(e -> e.getText())
                .filter(text -> !text.isBlank())
                .collect(Collectors.toList());
    }

    public String getName() {
        return driver.findElement(nameField).getText();
    }

    public String getDiagnosis() {
        return driver.findElement(diagnosisField).getText();
    }

    public int getAge() {
        String value = driver.findElement(ageField).getText();
        return Integer.parseInt(value);
    }

    public String getTreatment() {
        return driver.findElement(treatmentField).getText();
    }

    public void file(String name, String diagnosis, int age, String treatment) {
        enterName(name);
        enterDiagnosis(diagnosis);
        enterAge(age);
        enterTreatment(treatment);
        clickButtonSave();
    }
}
