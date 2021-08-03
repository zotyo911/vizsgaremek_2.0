package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final String TRAINER_EMAIL = "tesztedzo@igym.hu";
    private final String TRAINER_PASSWORD = "123456";
    private final String TRAINER_WRONG_PASSWORD = "123455";

    private final String USER_EMAIL = "tesztuser@igym.hu";
    private final String USER_PASSWORD = "123456";
    private final String USER_WRONG_PASSWORD = "123457";

    private final By EMAIL_INPUT = By.id("emailOrUserName");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.cssSelector("button.button-accent");

    public void trainerLoginNoEmail(){
        webDriver.findElement(EMAIL_INPUT).sendKeys("");
        webDriver.findElement(PASSWORD_INPUT).sendKeys(TRAINER_PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void trainerLoginNoPassword(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(TRAINER_EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys("");
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void trainerLoginWrongPassword(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(TRAINER_EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(TRAINER_WRONG_PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void trainerLogin(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(TRAINER_EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(TRAINER_PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CalendarPage(webDriver);
    }

    public void userLoginNoEmail(){
        webDriver.findElement(EMAIL_INPUT).sendKeys("");
        webDriver.findElement(PASSWORD_INPUT).sendKeys(USER_PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void userLoginNoPassword(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(USER_EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys("");
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void userLoginWrongPassword(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(USER_EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(USER_WRONG_PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void userLogin(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(USER_EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(USER_PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CalendarPage(webDriver);
    }

}
