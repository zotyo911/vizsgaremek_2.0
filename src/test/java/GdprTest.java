import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.GdprPage;
import pages.LandingPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GdprTest {

    WebDriver webdriver;
    LandingPage landingPage;
    GdprPage gdprPage;

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
    public void TestOpenGDPR(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.openGDPR();
        gdprPage = new GdprPage(webdriver);
        gdprPage.switchWindow();
        landingPage.clickCookiesAcceptButton();

    }
}
