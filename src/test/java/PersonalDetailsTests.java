import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CalendarPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.PersonalDetails;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonalDetailsTests {

    WebDriver webdriver;
    LandingPage landingPage;
    LoginPage loginPage;
    CalendarPage calendarPage;
    PersonalDetails personalDetails;

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
    @DisplayName("PD-01 Felhasználó (user) adatainak feltöltése")
    public void testUploadPersonaDetails(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadPersonalDetails(Constants.USER_FIRSTNAME, Constants.USER_SURNAME, Constants.USER_NICKNAME);

        Assertions.assertEquals("Hello, " + Constants.USER_FIRSTNAME, webdriver.findElement(By.xpath("//*/mat-toolbar-row[1]/div/div/span")).getText());

    }


    @AfterEach
    public void Close() {
        webdriver.quit();
    }

}
