import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.GdprPage;
import pages.LandingPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests {

    WebDriver webdriver;
    LandingPage landingPage;
    LoginPage loginPage;

    @BeforeAll
    public static void Init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void SetDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        webdriver = new ChromeDriver(options);

        webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();

    }

    @AfterEach
    public void tearDown(){
        webdriver.quit();
    }


    @Test
    @Order(1)
    @DisplayName("LI-01 Bejelentkezés felhasználóként email cím megadása nélkül")
    public void TestUserLoginNoEmail(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginNoEmail(Constants.PASSWORD);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(2)
    @DisplayName("LI-02 Bejelentkezés felhasználóként jelszó megadása nélkül")
    public void TestUserLoginNoPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginNoPassword(Constants.EMAIL);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(3)
    @DisplayName("LI-03 Bejelentkezés felhasználóként rossz jelszó megadásával")
    public void TestUserLoginWrongPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginWrongPassword(Constants.EMAIL, Constants.USER_WRONG_PASSWORD);


        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(4)
    @DisplayName("LI-04 Bejelentkezés felhasználóként érvényes adatokkal")
    public void TestUserLogin(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);

        Assertions.assertEquals("Hello, " + Constants.USER_FIRSTNAME, webdriver.findElement(By.cssSelector("mat-toolbar-row:nth-child(1) > div > div > span")).getText());
    }
}
