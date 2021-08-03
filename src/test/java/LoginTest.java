import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LandingPage;
import pages.LoginPage;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver webdriver;
    LandingPage landingPage;
    LoginPage loginPage;

    @BeforeEach
    public void Init()
    {
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
    public void TestDemo1(){
        landingPage = new LandingPage(webdriver);
        landingPage.navigateToURL();
        landingPage.clickHamburgerButton();
        landingPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        
    }



    @AfterEach
    public void Close()
    {
        webdriver.quit();
    }



}
