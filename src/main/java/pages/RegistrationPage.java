package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver webdriver;

    public RegistrationPage(WebDriver webDriver) {
        this.webdriver = webDriver;
    }

    private final By EMAIL_INPUT = By.id("email");
    private final By PASSWORD_INPUT = By.id("password");
    private final By CONFIRM_PASSWORD_INPUT = By.id("confirmPassword");
    private final By TERMS_CONDTS_CLICKBOX = By.xpath("//*[@id=\"mat-checkbox-1\"]/label/div");
    private final By PRIVACY_POLICY_CLICKBOX = By.xpath("//*[@id=\"mat-checkbox-2\"]/label/div");
    private final By REGISTER_BUTTON = By.xpath("//*/div/button[1]");

    public void noEmailRegistration(String password){
        webdriver.findElement(EMAIL_INPUT).sendKeys("");
        webdriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webdriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webdriver.findElement(REGISTER_BUTTON).click();
    }

    public void noPasswordRegistration(String email){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys("");
        webdriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys("");
        webdriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webdriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webdriver.findElement(REGISTER_BUTTON).click();
    }

    public void notValidPasswordRegistration(String email, String notValidPassword){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys(notValidPassword);
        webdriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(notValidPassword);
        webdriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webdriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webdriver.findElement(REGISTER_BUTTON).click();
    }

    public void notMatchPasswordRegistration(String email, String password, String notMatchPassword){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(notMatchPassword);
        webdriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webdriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webdriver.findElement(REGISTER_BUTTON).click();
    }

    public void noClickTermsCondtsRegistration(String email, String password){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webdriver.findElement(REGISTER_BUTTON).click();
    }

    public void noClickPrivacyPolicyRegistration(String email, String password){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webdriver.findElement(REGISTER_BUTTON).click();
    }

    public void registration(String email, String password){
        webdriver.findElement(EMAIL_INPUT).sendKeys(email);
        webdriver.findElement(PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(TERMS_CONDTS_CLICKBOX).click();
        webdriver.findElement(PRIVACY_POLICY_CLICKBOX).click();
        webdriver.findElement(REGISTER_BUTTON).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
