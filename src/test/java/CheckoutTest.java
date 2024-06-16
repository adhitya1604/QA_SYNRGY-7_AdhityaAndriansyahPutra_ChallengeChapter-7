import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.Loginpage;
import pages.Cartpage;
import pages.Checkoutpage;

public class CheckoutTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void CheckoutTest() {
        Loginpage loginPage = new Loginpage(driver);
        Homepage homepage = new Homepage(driver);
        Cartpage cartpage = new Cartpage(driver);
        Checkoutpage checkoutpage = new Checkoutpage(driver);

        loginPage.inputUser("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertEquals(homepage.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homepage.getTextDashboard(), "Products");
        Assert.assertTrue(homepage.isContentDisplayed(), "Item tidak ditemukan di halaman beranda.");

        //Bagian Cart TEST
        homepage.addFirstTwoItemsToCart();
        homepage.clickCartIcon();
        cartpage.clickCheckoutButton();

      //Bagian Checout Test
        checkoutpage.enterCheckoutInformation("Adhitya", "Andriansyah", "40124");
        checkoutpage.clickContinueButton();
        checkoutpage.clickFinishButton();


        Assert.assertTrue(checkoutpage.isSuccessMessageDisplayed(), "Pesan sukses tidak ditampilkan.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }
}