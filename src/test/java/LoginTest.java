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
public class LoginTest {

    WebDriver webdriver;
    LandingPage landingPage;
    LoginPage loginPage;

    @BeforeEach
    public void Init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        webdriver = new ChromeDriver(options);

        webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();

    }

    @Test
    @Order(1)
    @DisplayName("LI-01 Bejelentkezés email cím megadása nélkül")
    public void TestLoginNoEmail(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.loginNoEmail();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(2)
    @DisplayName("LI-02 Bejelentkezés jelszó megadása nélkül")
    public void TestLoginNoPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.loginNoPassword();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(3)
    @DisplayName("LI-03 Bejelentkezés rossz jelszó megadásával")
    public void TestLoginWrongPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.loginWrongPassword();


        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(4)
    @DisplayName("LI-04 Bejelentkezés")
    public void TestLogin(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.login();

        Assertions.assertEquals("Hello, Edző", webdriver.findElement(By.cssSelector("mat-toolbar-row:nth-child(1) > div > div > span")).getText());
    }

    @AfterEach
    public void Close() {
        webdriver.quit();
    }



}
