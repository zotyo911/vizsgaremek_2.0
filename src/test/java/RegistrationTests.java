import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
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

    @BeforeEach
    public void Init()
    {
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
    @DisplayName("RI-01 Regisztráció email cím megadása nélkül")
    public void testDemo1(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.noEmailRegistration();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(2)
    @DisplayName("RI-02 Regisztráció jelszó megadása nélkül")
    public void testDemo2(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.noPasswordRegistration();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(3)
    @DisplayName("RI-03 Regisztráció érvénytelen jelszó megadásával")
    public void testDemo3(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.notValidPasswordRegistration();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(4)
    @DisplayName("RI-04 Regisztráció nem egyező jelszavak megadásával")
    public void testDemo4(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.notMatchPasswordRegistration();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(5)
    @DisplayName("RI-05 Regisztráció a felhasználási feltételek elfogadása nélkül")
    public void testDemo5(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.noClickTermsCondtsRegistration();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @Test
    @Order(6)
    @DisplayName("RI-06 Regisztráció az adatvédelmi feltételek elfogadása nélkül")
    public void testDemo6(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickRegistrationButton();
        registrationPage = new RegistrationPage(webdriver);
        registrationPage.noClickPrivacyPolicyRegistration();

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/registration", webdriver.getCurrentUrl());
    }

    @AfterEach
    public void Close() {
        webdriver.quit();
    }
}