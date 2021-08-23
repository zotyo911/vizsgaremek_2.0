import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LandingPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests {

    WebDriver webdriver;
    LandingPage landingPage;
    LoginPage loginPage;

    @BeforeEach
    public void SetDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        webdriver = new ChromeDriver(options);

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();
    }

    @Test
    @Order(1)
    @DisplayName("LI-01 Bejelentkezés felhasználóként email cím megadása nélkül")
    public void TestUserLoginNoEmail(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginPageButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginNoEmail(Constraints.PASSWORD);

        Assertions.assertTrue(webdriver.findElement(By.id("mat-error-2")).isDisplayed());
    }

    @Test
    @Order(2)
    @DisplayName("LI-02 Bejelentkezés felhasználóként jelszó megadása nélkül")
    public void TestUserLoginNoPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginPageButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginNoPassword(Constraints.EMAIL);

        Assertions.assertFalse(webdriver.findElement(By.xpath("//div/button[1]")).isEnabled());
    }

    @Test
    @Order(3)
    @DisplayName("LI-03 Bejelentkezés felhasználóként rossz jelszó megadásával")
    public void TestUserLoginWrongPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginPageButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginWrongPassword(Constraints.EMAIL, Constraints.USER_WRONG_PASSWORD);

        Assertions.assertTrue(webdriver.findElement(By.xpath("//notifier-container/ul/li/notifier-notification/p")).isDisplayed());
    }

    @Test
    @Order(4)
    @DisplayName("LI-04 Bejelentkezés felhasználóként érvényes adatokkal")
    public void TestUserLogin(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginPageButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);

        Assertions.assertEquals("Hello, " + Constraints.USER_FIRSTNAME, webdriver.findElement(By.xpath("//mat-toolbar-row[1]/div/div/span")).getText());
    }

    @AfterEach
    public void tearDown(){
        webdriver.quit();
    }
}
