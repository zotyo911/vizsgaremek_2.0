import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CalendarPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyTicketsPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EndToEnd {
    WebDriver webdriver;

    LandingPage landingPage;
    LoginPage loginPage;
    CalendarPage calendarPage;
    MyTicketsPage myTicketsPage;

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
    @DisplayName("EE-01 Feliratkozás edzésre")
    public void TestEndToEndApplyTraining(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickCookiesAcceptButton();
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.clickHamburgerButton();
        calendarPage.clickMyTickets();
        myTicketsPage = new MyTicketsPage(webdriver);
        int myTicketsNumber = myTicketsPage.sumMyTickets();
        myTicketsPage.clickCalendarMenu();
        calendarPage= new CalendarPage(webdriver);
        calendarPage.stechingButtonClick();

        calendarPage.applyOnTraining();
        calendarPage.clickMyTickets();
        myTicketsPage = new MyTicketsPage(webdriver);
        int actual = myTicketsPage.sumMyTickets();
        int expected = myTicketsNumber + 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    @DisplayName("EE-02 Leiratkozás edzésről")
    public void TestEndToEndDeleteTraining(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickCookiesAcceptButton();
        landingPage.loginButtonClick();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.clickHamburgerButton();
        calendarPage.clickMyTickets();
        myTicketsPage = new MyTicketsPage(webdriver);
        int myTicketsNumber = myTicketsPage.sumMyTickets();

        myTicketsPage.clickCalendarMenu();
        calendarPage= new CalendarPage(webdriver);
        calendarPage.stechingButtonClick();

        calendarPage.deleteTraining();
        calendarPage.clickMyTickets();
        myTicketsPage = new MyTicketsPage(webdriver);
        int actual = myTicketsPage.sumMyTickets();
        int expected = myTicketsNumber - 1;

        Assertions.assertEquals(expected,actual);
    }
}
