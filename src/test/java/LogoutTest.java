import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CalendarPage;
import pages.LandingPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LogoutTest {

    WebDriver webdriver;
    LandingPage landingPage;
    LoginPage loginPage;
    CalendarPage calendarPage;

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
    @DisplayName("LO-01 Trainer kijlentkezés")
    public void TestTrainerLogout() {
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.TRAINER_EMAIL, Constants.TRAINER_PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.logout();

        Assertions.assertEquals("BELÉPÉS", webdriver.findElement(By.cssSelector("mat-toolbar-row > div > div > span")).getText());
    }

    @Test
    @Order(2)
    @DisplayName("LO-02 User kijlentkezés")
    public void TestUserLogout() {
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.logout();

        Assertions.assertEquals("BELÉPÉS", webdriver.findElement(By.cssSelector("mat-toolbar-row > div > div > span")).getText());
    }

    @AfterEach
    public void Close() {
        webdriver.quit();
    }
}
