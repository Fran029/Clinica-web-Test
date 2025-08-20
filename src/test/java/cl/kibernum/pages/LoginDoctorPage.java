package cl.kibernum.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cl.kibernum.hooks.DriverHolder;

public class LoginDoctorPage {

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By entryClick = By.cssSelector("#login-form > button");
    private By invalidMessage = By.xpath("//*[@id='login-message']/div[@role='alert']");

    private WebDriver getDriver() {
        return DriverHolder.get();
    }

    public void navigateTo() {
        getDriver().get("https://clinica-modular.netlify.app/");
    }

    public void enterName(String username) {
        getDriver().findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        getDriver().findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        getDriver().findElement(entryClick).click();
    }

    public void login(String name, String password) {
        enterName(name);
        enterPassword(password);
        clickLoginButton();
    }

    public String failedLoginMessage() {
        List<WebElement> messageErrors = getDriver().findElements(invalidMessage);
        return messageErrors.isEmpty() ? "" : messageErrors.get(0).getText().trim();
    }
}
