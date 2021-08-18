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

        webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webdriver.manage().window().maximize();

    }

 /*   @AfterEach
    public void tearDown(){
        webdriver.quit();
    }*/

    @Test
    @Order(1)
    @DisplayName("PD-01 Regisztrált felhasználó (user) adatainak megadása")
    public void testUploadPersonaDetails(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadPersonalDetails(Constraints.USER_FIRSTNAME, Constraints.USER_SURNAME, Constraints.USER_NICKNAME);

        Assertions.assertEquals("Hello, " + Constraints.USER_FIRSTNAME, webdriver.findElement(By.xpath("//*/mat-toolbar-row[1]/div/div/span")).getText());

    }

    @Test
    @Order(2)
    @DisplayName("PD-02 Felhasználó jelszavának a módosítása rossz jelszót megadva")
    public void testAddWrongPasswordToChange(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constraints.NOT_VALID_PASSWORD, Constraints.USER_NEW_PASSWORD, Constraints.USER_NEW_PASSWORD);

        Assertions.assertEquals("assertive", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-live"));
    }

    @Test
    @Order(3)
    @DisplayName("PD-03 Felhasználó jelszavának módosítása, az új jelszó megerősítése helytelenül")
    public void testAddWrongConfirmPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constraints.PASSWORD, Constraints.USER_NEW_PASSWORD, Constraints.NOT_MATCH_PASSWORD);

        Assertions.assertEquals("polite", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-live"));
    }

    @Test
    @Order(4)
    @DisplayName("PD-04 Felhasználó jelszavának módosítása, helyes adatokkal")
    public void testChangePassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constraints.PASSWORD, Constraints.USER_NEW_PASSWORD, Constraints.USER_NEW_PASSWORD);

        Assertions.assertEquals("true", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-atomic"));
    }

    @Test
    @Order(5)
    @DisplayName("PD-05 Felhasználó számlázási adatainak megadása")
    public void testUploadUserBillingDetails(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constraints.EMAIL, Constraints.USER_NEW_PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadBillingDetails(Constraints.USER_FULLNAME, Constraints.USER_COUNTRY, Constraints.USER_POSTAL_CODE, Constraints.USER_CITY, Constraints.USER_ADDRESS);

        Assertions.assertTrue(webdriver.findElement(By.xpath("//*[contains(@class,'mat-simple-snackbar ng-star-inserted')]")).isDisplayed());

    }

    @Test
    @Order(6)
    @DisplayName("PD-06 Felhasználó jelszavának visszaállítása az eredetire")
    public void testChangeBackToOriginalPassword(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constraints.EMAIL, Constraints.USER_NEW_PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constraints.USER_NEW_PASSWORD, Constraints.USER_PASSWORD, Constraints.USER_PASSWORD);

        Assertions.assertEquals("true", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-atomic"));
    }

    @Test
    @Order(7)
    @DisplayName("PD-07 Felhasználó számlázási adatainak (címének) módosítása")
    public void testModifyUserBillingDetails(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadBillingDetails(Constraints.USER_FULLNAME, Constraints.USER_COUNTRY, Constraints.USER_MODIFIED_POSTAL_CODE, Constraints.USER_MODIFIED_CITY, Constraints.USER_MODIFIED_ADDRESS);

        Assertions.assertTrue(webdriver.findElement(By.xpath("//*[contains(@class,'mat-simple-snackbar ng-star-inserted')]")).isDisplayed());

    }

    @Test
    @Order(8)
    @DisplayName("PD-08 Felhasználó számlázási adatainak (kivéve név) törlése")
    public void testDeleteUserBillingDetails(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL(Constraints.URL);
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constraints.EMAIL, Constraints.PASSWORD);
        calendarPage = new CalendarPage(webdriver);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.deleteBillingDetails(Constraints.USER_FULLNAME);

        Assertions.assertTrue(webdriver.findElement(By.xpath("//*[contains(@class,'mat-simple-snackbar ng-star-inserted')]")).isDisplayed());

    }
}
