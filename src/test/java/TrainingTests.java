import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    @DisplayName("TR-01 Edzés adatainak mentése txt fájlba")
    public void TestSaveTrainingDetailsToFile() {
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.saveTrainingDatasToFile();
        landingPage.readTrainingDetailsFile();

    }

    @Test
    @Order(2)
    @DisplayName("TR-02 Edzés típusra keresés")
    public void testChooseTrainingType(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        boolean isContains = landingPage.chooseTrainingType(Constants.TRAINING_TYPE_JOGA);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(3)
    @DisplayName("TR-03 Edzés típusra keresés (nem létező edzés)")
    public void testChooseNotValidTrainingType(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        boolean isContains = landingPage.chooseTrainingType(Constants.TRAINING_TYPE_INVALID);

        Assertions.assertFalse(isContains);
    }

    @Test
    @Order(4)
    @DisplayName("TR-04 Felső menüsor tesztelése (JÓGA gomb)")
    public void testOfJogaButton(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.jogaButtonClick();
        boolean isContains = landingPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_JOGA);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(5)
    @DisplayName("TR-05 Felső menüsor tesztelése (NYÚJTÁS gomb)")
    public void testOfStrechingButton(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.stechingButtonClick();
        boolean isContains = landingPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_STRECHING);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(6)
    @DisplayName("TR-06 Felső menüsor tesztelése (MEDITÁCIÓ gomb)")
    public void testOfMeditationButton(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.meditationButtonClick();
        boolean isContains = landingPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_MEDITATON);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(7)
    @DisplayName("TR-07 Felső menüsor tesztelése (KARDIÓ gomb)")
    public void testOfKardioButton(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.kardioButtonClick();
        boolean isContains = landingPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_KARDIO);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(8)
    @DisplayName("TR-08 Felső menüsor tesztelése (PILATES gomb)")
    public void testOfPilatesButton(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.pilatesButtonClick();
        boolean isContains = landingPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_PILATES);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(9)
    @DisplayName("TR-09 Felső menüsor tesztelése (ALAKFORMÁLÓ gomb)")
    public void testOfBodyFitButton(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.bodyFitButtonClick();
        boolean isContains = landingPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_BODYFIT);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(10)
    @DisplayName("TR-10 Felső menüsor tesztelése (ERŐNLÉTI gomb)")
    public void testOfMuscleButton(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.muscleButtonClick();
        boolean isContains = landingPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_MUSCLE);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(11)
    @DisplayName("TR-11 Felső menüsor tesztelése (EGYÉB gomb)")
    public void testOfOtherButton(){
        landingPage =new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.muscleButtonClick();
        boolean isContains = landingPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_OTHER);

        Assertions.assertTrue(isContains);
    }



    @AfterEach
    public void Close() {
        webdriver.quit();
    }
}
