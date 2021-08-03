package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final String LOGIN_EMAIL = "tesztedzo@igym.hu";
    private final String PASSWORD = "123456";
    private final String WRONG_PASSWORD = "123455";

    private final By EMAIL_INPUT = By.id("emailOrUserName");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.cssSelector("button.button-accent");

    public void loginNoEmail(){
        webDriver.findElement(EMAIL_INPUT).sendKeys("");
        webDriver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void loginNoPassword(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(LOGIN_EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys("");
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void loginWrongPassword(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(LOGIN_EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(WRONG_PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void login(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(LOGIN_EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(LOGIN_BUTTON).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CalendarPage(webDriver);
    }

}
