package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cartpage {
    WebDriver driver;
    WebDriverWait wait;

    By checkoutButton = By.id("checkout");

    public Cartpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}
