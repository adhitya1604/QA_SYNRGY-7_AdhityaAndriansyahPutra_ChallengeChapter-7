package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//span[@class='title']");
    By Items = By.xpath("//div[@class='inventory_item']");
    By sortDropdown = By.xpath("//select[@class='product_sort_container']");
    By itemPrices = By.xpath("//div[@class='inventory_item_price']");
    By addToCartButtons = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
    By cartIcon = By.xpath("//a[@class='shopping_cart_link']");

    public Homepage (WebDriver driver) {
        this.driver =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getTextDashboard(){
        return driver.findElement(dashboardText).getText();
    }

    public boolean isContentDisplayed() {
        return driver.findElements(Items).size() > 0;
    }

    public void sortItemsHighToLow() {
        WebElement dropdown = driver.findElement(sortDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[@value='hilo']")).click();
    }

    public List<WebElement> getItemPrices() {
        return driver.findElements(itemPrices);
    }

    public double getPriceFromText(String priceText) {
        return Double.parseDouble(priceText.replace("$", ""));
    }

    public void addFirstTwoItemsToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        if (buttons.size() >= 2) {
            buttons.get(0).click();
            buttons.get(1).click();
        }
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }
}
