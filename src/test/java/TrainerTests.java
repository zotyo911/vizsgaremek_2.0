import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CalendarPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.TrainerPage;

import java.util.concurrent.TimeUnit;

public class TrainerTests {
    WebDriver webdriver;
    LandingPage landingPage;
    LoginPage loginPage;
    CalendarPage calendarPage;
    TrainerPage trainerPage;

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

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();

    }

    @AfterEach
    public void tearDown(){
        webdriver.quit();
    }

    @Test
    @Order(1)
    @DisplayName("TS-01 Edzők listájában edző nevére történő szűrés")
    public void TestSearchTrainer() {
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.clickHamburgerButton();
        calendarPage.clickTrainerButton();
        trainerPage = new TrainerPage(webdriver);
        trainerPage.searchForTrainer(Constraints.TRAINER_NAME);

        Assertions.assertEquals(Constraints.TRAINER_NAME, webdriver.findElement(By.xpath("//*/mat-card-content/div[1]")).getText());

    }

    @Test
    @Order(2)
    @DisplayName("TS-02 Edzők adatlapjának megnyitása a MÉG TÖBB INFO gombbal")
    public void TestMoreTrainerInfo() {
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.clickHamburgerButton();
        calendarPage.clickTrainerButton();
        trainerPage = new TrainerPage(webdriver);
        trainerPage.getTrainerAllDetails(Constraints.TRAINER_NAME);

        Assertions.assertTrue(webdriver.findElement(By.xpath("//*/app-rating-container/div/div[2]")).isDisplayed());
    }
}
