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
public class TrainingTicketTests {

    WebDriver webdriver;
    LandingPage landingPage;
    CalendarPage calendarPage;
    LoginPage loginPage;

    @BeforeEach
    public void SetDriver() {
        WebDriverManager.chromedriver().setup();
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
    @DisplayName("TT-01 Lite bérlet árának validációja")
    public void TestLiteTicket(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.checkTrainingLiteTicketPrice();

        Assertions.assertEquals("5,000 FT", webdriver.findElement(By.xpath("//*/div[1]/app-package-card/div/*[contains(@class,'package-price')]")).getText());

    }

    @Test
    @Order(2)
    @DisplayName("TT-02 Plus bérlet árának validációja")
    public void TestPlusTicket(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.checkTrainingPlusTicketPrice();

        Assertions.assertEquals("15,000 FT", webdriver.findElement(By.xpath("//*/div[2]/app-package-card/div/*[contains(@class,'package-price')]")).getText());

    }

    @Test
    @Order(3)
    @DisplayName("TT-03 Pro bérlet egy edzés/ár validációja")
    public void TestProTicket(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.checkTrainingProTicketPricePerTraining();

        Assertions.assertEquals("1667 FT / EDZÉS", webdriver.findElement(By.xpath("//*/div[3]/app-package-card/div//*[contains(@class,'price-divided')]")).getText());

    }

    @Test
    @Order(4)
    @DisplayName("TT-04 Ultra bérlet egy edzésre eső árának validációja")
    public void TestUltraTicket(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.checkTrainingUltraTicketPricePerTraining();

        Assertions.assertEquals("3000 FT / EDZÉS", webdriver.findElement(By.xpath("//div[4]/app-package-card/div//*[contains(@class,'price-divided')]")).getText());

    }
}

