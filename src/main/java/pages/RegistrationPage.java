package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver webDriver;

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final String EMAIL = "sooszoltan80@freemail.hu";
    private final String PASSWORD = "Ca123456789";
    private final String NOT_VALID_PASSWORD = "Ca123";
    private final String NOT_MATCH_PASSWORD = "Ca123456788";

    private final By EMAIL_INPUT = By.id("email");
    private final By PASSWORD_INPUT = By.id("password");
    private final By CONFIRM_PASSWORD_INPUT = By.id("confirmPassword");
    private final By TERMS_CONDTS_CLICKBOX = By.xpath("//*[@id=\"mat-checkbox-1\"]/label/div");
    private final By PRIVACY_POLICY_CLICKBOX = By.xpath("//*[@id=\"mat-checkbox-2\"]/label/div");
    private final By REGISTER_BUTTON = By.cssSelector("button.button-accent.bigbuttR");

    public void noEmailRegistration(){
        webDriver.findElement(EMAIL_INPUT).sendKeys("");
        webDriver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webDriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webDriver.findElement(REGISTER_BUTTON).click();
    }

    public void noPasswordRegistration(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys("");
        webDriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webDriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webDriver.findElement(REGISTER_BUTTON).click();
    }

    public void notValidPasswordRegistration(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(NOT_VALID_PASSWORD);
        webDriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(NOT_VALID_PASSWORD);
        webDriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webDriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webDriver.findElement(REGISTER_BUTTON).click();
    }

    public void notMatchPasswordRegistration(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(NOT_MATCH_PASSWORD);
        webDriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webDriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webDriver.findElement(REGISTER_BUTTON).click();
    }

    public void noClickTermsCondtsRegistration(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webDriver.findElement(REGISTER_BUTTON).click();
    }

    public void noClickPrivacyPolicyRegistration(){
        webDriver.findElement(EMAIL_INPUT).sendKeys(EMAIL);
        webDriver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(PASSWORD);
        webDriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webDriver.findElement(REGISTER_BUTTON).click();
    }


}
