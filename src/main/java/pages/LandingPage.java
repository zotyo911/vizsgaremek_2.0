package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver webdriver;

    public LandingPage(WebDriver webdriver){
        this.webdriver = webdriver;
    }


    private final String URL = "https://igym-igym-dev.azurewebsites.net/";
    private final By hamburgerButton = By.cssSelector("span > mat-icon");
    private final By loginButton = By.cssSelector("a:nth-child(1) > div > span > div.text.ng-tns-c144-0");
    private final By registrationButton = By.cssSelector("a:nth-child(2) > div > span > div.text.ng-tns-c144-0");
    private final By calendarButton = By.cssSelector("a:nth-child(3) > div > span > div.text.ng-tns-c144-0");
    private final By trainerButton = By.cssSelector("a:nth-child(4) > div > span > div.text.ng-tns-c144-0");


    public void navigateToURL(){
        webdriver.get(URL);
    }

    public void clickHamburgerButton(){
        webdriver.findElement(hamburgerButton).click();
    }

    public void clickLoginButton(){
        webdriver.findElement(loginButton).click();
    }

    public void clickRegistrationButton(){
        webdriver.findElement(registrationButton).click();
    }

    public void clickCalendarButton(){
        webdriver.findElement(calendarButton).click();
    }

    public void clickTrainerButton(){
        webdriver.findElement(trainerButton);
    }
}
