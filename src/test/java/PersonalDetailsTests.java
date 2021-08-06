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
    @DisplayName("PD-01 Regisztrált felhasználó (user) adatainak megadása")
    public void testUploadPersonaDetails(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadPersonalDetails(Constants.USER_FIRSTNAME, Constants.USER_SURNAME, Constants.USER_NICKNAME);

        Assertions.assertEquals("Hello, " + Constants.USER_FIRSTNAME, webdriver.findElement(By.xpath("//*/mat-toolbar-row[1]/div/div/span")).getText());

    }

    @Test
    @Order(2)
    @DisplayName("PD-02 Felhasználó jelszavának a módosítása rossz jelszót megadva")
    public void testAddWrongPasswordToChange(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constants.NOT_VALID_PASSWORD, Constants.USER_NEW_PASSWORD, Constants.USER_NEW_PASSWORD);

        Assertions.assertEquals("assertive", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-live"));
    }

    @Test
    @Order(3)
    @DisplayName("PD-03 Felhasználó jelszavának módosítása, az új jelszó megerősítése helytelenül")
    public void testAddWrongConfirmPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constants.PASSWORD, Constants.USER_NEW_PASSWORD, Constants.NOT_MATCH_PASSWORD);

        Assertions.assertEquals("polite", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-live"));
    }

    @Test
    @Order(4)
    @DisplayName("PD-04 Felhasználó jelszavának módosítása, helyes adatokkal")
    public void testChangePassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constants.PASSWORD, Constants.USER_NEW_PASSWORD, Constants.USER_NEW_PASSWORD);

        Assertions.assertEquals("true", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-atomic"));
    }

    @Test
    @Order(5)
    @DisplayName("PD-05 Felhasználó számlázási adatainak megadása")
    public void testUploadUserBillingDetails(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.USER_NEW_PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadBillingDetails(Constants.USER_FULLNAME, Constants.USER_COUNTRY, Constants.USER_POSTAL_CODE, Constants.USER_CITY, Constants.USER_ADDRESS);

        Assertions.assertEquals("cdk-overlay-container", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-overlay-container')]")).getAttribute("class"));

    }

    @Test
    @Order(6)
    @DisplayName("PD-06 Felhasználó jelszavának visszaállítása az eredetire")
    public void testChangeBackToOriginalPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constants.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.USER_NEW_PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constants.USER_NEW_PASSWORD, Constants.USER_PASSWORD, Constants.USER_PASSWORD);

        Assertions.assertEquals("true", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-atomic"));
    }


    @AfterEach
    public void Close() {
        webdriver.quit();
    }

}
