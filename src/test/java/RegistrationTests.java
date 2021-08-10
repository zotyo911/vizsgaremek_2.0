import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LandingPage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests {

    WebDriver webdriver;
    LandingPage landingPage;
    RegistrationPage registrationPage;

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
    @DisplayName("RI-01 Regisztráció email cím megadása nélkül")
    public void testNoEmailRegistration(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.noEmailRegistration(Constants.PASSWORD);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(2)
    @DisplayName("RI-02 Regisztráció jelszó megadása nélkül")
    public void testNoPasswordRegistration(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.noPasswordRegistration(Constants.EMAIL);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(3)
    @DisplayName("RI-03 Regisztráció érvénytelen jelszó megadásával")
    public void testNotValidPasswordRegistration(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.notValidPasswordRegistration(Constants.EMAIL, Constants.NOT_VALID_PASSWORD);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(4)
    @DisplayName("RI-04 Regisztráció nem egyező jelszavak megadásával")
    public void testNotMatchPasswordRegistration(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.notMatchPasswordRegistration(Constants.EMAIL, Constants.PASSWORD, Constants.NOT_MATCH_PASSWORD);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(5)
    @DisplayName("RI-05 Regisztráció a felhasználási feltételek elfogadása nélkül")
    public void testNoClickTermsCondtsRegistration(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.noClickTermsCondtsRegistration(Constants.EMAIL, Constants.PASSWORD);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(6)
    @DisplayName("RI-06 Regisztráció az adatvédelmi feltételek elfogadása nélkül")
    public void testNoClickPrivacyPolicyRegistration(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.noClickPrivacyPolicyRegistration(Constants.EMAIL, Constants.PASSWORD);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

  /*  @Test
    @Order(7)
    @DisplayName("RI-07 Regisztráció minden érvényes adat megadásával")
    public void testRegistration(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.registration(Constants.EMAIL, Constants.PASSWORD);

        Assertions.assertEquals("Sikeres regisztráció, kérjük erősítse meg email címét", webdriver.findElement(By.xpath("//*//*simple-snack-bar/span")).getText());
    }*/
}