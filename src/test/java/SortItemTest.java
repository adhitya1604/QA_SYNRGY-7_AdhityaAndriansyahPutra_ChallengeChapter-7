import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Loginpage;

import java.util.List;

public class SortItemTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void SortItem() {
        Loginpage loginPage = new Loginpage(driver);
        Homepage homepage = new Homepage(driver);

        loginPage.inputUser("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertEquals(homepage.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homepage.getTextDashboard(), "Products");
        Assert.assertTrue(homepage.isContentDisplayed(), "Item tidak ditemukan di halaman beranda.");

        homepage.sortItemsHighToLow();

        List<WebElement> prices = homepage.getItemPrices();
        Assert.assertTrue(prices.size() > 1, "Kurang dari dua item ditemukan.");

        double firstPrice = homepage.getPriceFromText(prices.get(0).getText());
        double secondPrice = homepage.getPriceFromText(prices.get(1).getText());


        Assert.assertTrue(firstPrice > secondPrice, "Harga item pertama tidak lebih besar dari harga item kedua.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }
}
