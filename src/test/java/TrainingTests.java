import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CalendarPage;
import pages.LandingPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TrainingTests {
    WebDriver webdriver;
    LandingPage landingPage;

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
    public void TestSaveTrainingDetailsToFile() {
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.saveTrainingDatasToFile();
        landingPage.readTrainingDetailsFile();

    }

    @Test
    @Order(2)
    public void testChooseTrainingType(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        boolean isContains = landingPage.chooseTrainingType("jóga");

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(3)
    public void testChooseNotValidTrainingType(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        boolean isContains = landingPage.chooseTrainingType("bmxct345gh");

        Assertions.assertFalse(isContains);
    }



    @AfterEach
    public void Close() {
        webdriver.quit();
    }
}
