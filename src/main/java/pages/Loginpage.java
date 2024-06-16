package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Loginpage {
    WebDriver driver;
    WebDriverWait wait;


    By usernameField = By.name("user-name");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@id='login-button']");
    By errorText = By.xpath("//h3[@data-test='error']");

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void inputUser(String username) {
        driver.findElement(usernameField).sendKeys(username);

    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);

    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();

    }

    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }

    public String getTextError(){

        return driver.findElement(errorText).getText();
    }
}

