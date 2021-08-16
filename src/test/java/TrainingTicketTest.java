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
public class TrainingTicketTest {

    WebDriver webdriver;
    LandingPage landingPage;
    CalendarPage calendarPage;
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
    //    options.addArguments("--headless");
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
    @DisplayName("")
    public void TestLiteTicket(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.checkTrainingLiteTicketPrice();

        Assertions.assertEquals("5,000 FT", webdriver.findElement(By.xpath("//*/div[1]/app-package-card/div/*[contains(@class,'package-price')]")).getText());

    }

    @Test
    @Order(2)
    @DisplayName("")
    public void TestPlusTicket(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.checkTrainingPlusTicketPrice();

        Assertions.assertEquals("15,000 FT", webdriver.findElement(By.xpath("//*/div[2]/app-package-card/div/*[contains(@class,'package-price')]")).getText());

    }

    @Test
    @Order(3)
    @DisplayName("")
    public void TestProTicket(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.checkTrainingProTicketPricePerTraining();

        Assertions.assertEquals("1667 FT / EDZÉS", webdriver.findElement(By.xpath("//*/div[3]/app-package-card/div//*[contains(@class,'price-divided')]")).getText());

    }

    @Test
    @Order(3)
    @DisplayName("")
    public void TestUltraTicket(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.checkTrainingUltraTicketPricePerTraining();

        Assertions.assertEquals("3000 FT / EDZÉS", webdriver.findElement(By.xpath("//*/div[4]/app-package-card/div//*[contains(@class,'price-divided')]")).getText());

    }
}

