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
public class LogoutTests {

    WebDriver webdriver;
    LandingPage landingPage;
    LoginPage loginPage;
    CalendarPage calendarPage;

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

    @RepeatedTest(5)
    @Order(1)
    @DisplayName("LO-01 User kijlentkezés")
    public void TestUserLogout() {
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.logout();

        Assertions.assertEquals("BELÉPÉS", webdriver.findElement(By.cssSelector("mat-toolbar-row > div > div > span")).getText());
    }
}
