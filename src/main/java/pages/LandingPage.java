package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver webdriver;

    public LandingPage(WebDriver webdriver){
        this.webdriver = webdriver;
    }

    private final By HAMBURGER_BUTTON = By.xpath("//*/mat-icon");
    private final By LOGIN_PAGE_BUTTON = By.xpath("//*/mat-nav-list/a[1]/div/span/div[1]");
    private final By REGISTRATION_PAGE_BUTTON = By.xpath("//*/mat-nav-list/a[2]/div/span/div[1]");
    private final By CALENDAR_BUTTON = By.xpath("//*/mat-nav-list/a[3]/div/span/div[1]");
    private final By TRAINER_BUTTON = By.xpath("//*/mat-nav-list/a[4]/div/span/div[1]");


    public void navigateToURL(String url){
        webdriver.get(url);
    }

    public void clickHamburgerButton(){
        webdriver.findElement(HAMBURGER_BUTTON).click();
    }

    public void clickLoginButton(){
        webdriver.findElement(LOGIN_PAGE_BUTTON).click();
        new LoginPage(webdriver);
    }

    public void clickRegistrationButton(){
        webdriver.findElement(REGISTRATION_PAGE_BUTTON).click();
        new RegistrationPage(webdriver);
    }

    public void clickCalendarButton(){
        webdriver.findElement(CALENDAR_BUTTON).click();
    }

    public void clickTrainerButton(){
        webdriver.findElement(TRAINER_BUTTON);
    }

}
