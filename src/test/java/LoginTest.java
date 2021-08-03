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
    @DisplayName("LI-01 Bejelentkezés edzőként email cím megadása nélkül")
    public void TestTrainerLoginNoEmail(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLoginNoEmail();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(2)
    @DisplayName("LI-02 Bejelentkezés edzőként jelszó megadása nélkül")
    public void TestLoginNoPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLoginNoPassword();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(3)
    @DisplayName("LI-03 Bejelentkezés edzőként rossz jelszó megadásával")
    public void TestLoginWrongPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLoginWrongPassword();


        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(4)
    @DisplayName("LI-04 Bejelentkezés edzőként érvényes adatokkal")
    public void TestLogin(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin();

        Assertions.assertEquals("Hello, Edző", webdriver.findElement(By.cssSelector("mat-toolbar-row:nth-child(1) > div > div > span")).getText());
    }

    @Test
    @Order(5)
    @DisplayName("LI-05 Bejelentkezés felhasználóként email cím megadása nélkül")
    public void TestUserLoginNoEmail(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginNoEmail();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(6)
    @DisplayName("LI-06 Bejelentkezés felhasználóként jelszó megadása nélkül")
    public void TestUserLoginNoPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginNoPassword();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(7)
    @DisplayName("LI-07 Bejelentkezés felhasználóként rossz jelszó megadásával")
    public void TestUserLoginWrongPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginWrongPassword();


        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(8)
    @DisplayName("LI-08 Bejelentkezés felhasználóként érvényes adatokkal")
    public void TestUserLogin(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin();

        Assertions.assertEquals("Hello, Teszt", webdriver.findElement(By.cssSelector("mat-toolbar-row:nth-child(1) > div > div > span")).getText());
    }




    @AfterEach
    public void Close() {
        webdriver.quit();
    }
}
