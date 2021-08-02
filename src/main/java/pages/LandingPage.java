package pages;

import org.openqa.selenium.By;
import util.Util;

public class LandingPage {
    private static final By hamburgerButton = By.cssSelector("span > mat-icon");
    private static final By loginButton = By.cssSelector("a:nth-child(1) > div > span > div.text.ng-tns-c144-0");
    private static final By registrationButton = By.cssSelector("a:nth-child(2) > div > span > div.text.ng-tns-c144-0");
    private static final By calendarButton = By.cssSelector("a:nth-child(3) > div > span > div.text.ng-tns-c144-0");
    private static final By trainerButton = By.cssSelector("a:nth-child(4) > div > span > div.text.ng-tns-c144-0");


    public static void clickHamburgerButton(){
        Util.getDriver().findElement(hamburgerButton).click();
    }

    public static void clickLoginButton(){
        Util.getDriver().findElement(loginButton).click();
    }

    public static void clickRegistrationButton(){
        Util.getDriver().findElement(registrationButton).click();
    }

    public static void clickCalendarButton(){
        Util.getDriver().findElement(calendarButton).click();
    }

    public static void clickTrainerButton(){
        Util.getDriver().findElement(trainerButton);
    }

}
