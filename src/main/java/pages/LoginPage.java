package pages;

import org.aspectj.apache.bcel.classfile.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By EMAIL_INPUT = By.id("emailOrUserName");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.cssSelector("button.button-accent");

    public void trainerLoginNoEmail(String password){
        webDriver.findElement(EMAIL_INPUT).sendKeys("");
        webDriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void trainerLoginNoPassword(String email){
        webDriver.findElement(EMAIL_INPUT).sendKeys(email);
        webDriver.findElement(PASSWORD_INPUT).sendKeys("");
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void trainerLoginWrongPassword(String email, String wrongPassword){
        webDriver.findElement(EMAIL_INPUT).sendKeys(email);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(wrongPassword);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void trainerLogin(String email, String password){
        webDriver.findElement(EMAIL_INPUT).sendKeys(email);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webDriver.findElement(LOGIN_BUTTON).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CalendarPage(webDriver);
    }

    public void userLoginNoEmail(String password){
        webDriver.findElement(EMAIL_INPUT).sendKeys("");
        webDriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void userLoginNoPassword(String email){
        webDriver.findElement(EMAIL_INPUT).sendKeys(email);
        webDriver.findElement(PASSWORD_INPUT).sendKeys("");
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void userLoginWrongPassword(String email, String wrongPassword){
        webDriver.findElement(EMAIL_INPUT).sendKeys(email);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(wrongPassword);
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void userLogin(String email, String password){
        webDriver.findElement(EMAIL_INPUT).sendKeys(email);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webDriver.findElement(LOGIN_BUTTON).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CalendarPage(webDriver);
    }

}
