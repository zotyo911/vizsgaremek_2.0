package pages;

import org.aspectj.apache.bcel.classfile.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver webdriver;

    public LoginPage(WebDriver webDriver) {
        this.webdriver = webDriver;
    }

    private final By EMAIL_INPUT = By.id("emailOrUserName");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.xpath("//*/div/button[1]");

    public void trainerLoginNoEmail(String password){
        webdriver.findElement(EMAIL_INPUT).sendKeys("");
        webdriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(LOGIN_BUTTON).click();
    }

    public void trainerLoginNoPassword(String email){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys("");
        webdriver.findElement(LOGIN_BUTTON).click();
    }

    public void trainerLoginWrongPassword(String email, String wrongPassword){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys(wrongPassword);
        webdriver.findElement(LOGIN_BUTTON).click();
    }

    public void trainerLogin(String email, String password){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(LOGIN_BUTTON).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CalendarPage(webdriver);
    }

    public void userLoginNoEmail(String password){
        webdriver.findElement(EMAIL_INPUT).sendKeys("");
        webdriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(LOGIN_BUTTON).click();
    }

    public void userLoginNoPassword(String email){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys("");
        webdriver.findElement(LOGIN_BUTTON).click();
    }

    public void userLoginWrongPassword(String email, String wrongPassword){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys(wrongPassword);
        webdriver.findElement(LOGIN_BUTTON).click();
    }

    public void userLogin(String email, String password){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(LOGIN_BUTTON).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new CalendarPage(webdriver);
    }

}
