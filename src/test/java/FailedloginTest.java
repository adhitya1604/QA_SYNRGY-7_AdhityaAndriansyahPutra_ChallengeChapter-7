import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Loginpage;

public class FailedloginTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLogininvalid() {
        Loginpage loginPage = new Loginpage(driver);

        loginPage.inputUser("adhitya");
        loginPage.inputPassword("12345678");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getTextError(), "Epic sadface: Username and password do not match any user in this service");

    }

    @AfterTest
    public void tearDown() {
            driver.quit();

    }
}
