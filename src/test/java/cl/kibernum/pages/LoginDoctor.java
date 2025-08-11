package cl.kibernum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginDoctor {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By entryClick = By.cssSelector("#login-form > button");
    private By validMessage = By.xpath("//header/div[@class='container']/h1[contains(text(), 'Ficha Clínica')]");
    private By invalidMessage = By.xpath("//*[@id='login-message']/div[@role='alert']");

    public LoginDoctor(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("http://127.0.0.1:5500/ficha.html");
    }

    public void enterName(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(entryClick).click();
    }


    public void login(String name, String password) {
        enterName(name);
        enterPassword(password);
        clickLoginButton();
    }

    public String failedLoginMessage() {
        return driver.findElement(invalidMessage).getText();
    }

    public String validLoginMessage() {
        return driver.findElement(validMessage).getText();
    }
}
