package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver webdriver;

    public LandingPage(WebDriver webdriver){
        this.webdriver = webdriver;
    }


    private final String URL = "https://igym-igym-dev.azurewebsites.net/";
    private final By HAMBURGER_BUTTON = By.cssSelector("span > mat-icon");
    private final By LOGIN_BUTTON = By.cssSelector("a:nth-child(1) > div > span > div.text.ng-tns-c144-0");
    private final By REGISTRATION_BUTTON = By.cssSelector("a:nth-child(2) > div > span > div.text.ng-tns-c144-0");
    private final By CALENDAR_BUTTON = By.cssSelector("a:nth-child(3) > div > span > div.text.ng-tns-c144-0");
    private final By TRAINER_BUTTON = By.cssSelector("a:nth-child(4) > div > span > div.text.ng-tns-c144-0");


    public void navigateToURL(){
        webdriver.get(URL);
    }

    public void clickHamburgerButton(){
        webdriver.findElement(HAMBURGER_BUTTON).click();
    }

    public void clickLoginButton(){
        webdriver.findElement(LOGIN_BUTTON).click();
        new LoginPage(webdriver);
    }

    public void clickRegistrationButton(){
        webdriver.findElement(REGISTRATION_BUTTON).click();
        new RegistrationPage(webdriver);
    }

    public void clickCalendarButton(){
        webdriver.findElement(CALENDAR_BUTTON).click();
    }

    public void clickTrainerButton(){
        webdriver.findElement(TRAINER_BUTTON);
    }

}
