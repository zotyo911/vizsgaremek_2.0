package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver webDriver;

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final String email = "sooszoltan80@freemail.hu";
    private final String password = "Ca123456789";
    private final String notValidPassword = "Ca123";
    private final String notMatchPassword = "Ca123456788";

    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By confirmPasswordInput = By.id("confirmPassword");
    private final By termsCondtsInput = By.xpath("//*[@id=\"mat-checkbox-1\"]/label/div");
    private final By privacyPolicyInput = By.xpath("//*[@id=\"mat-checkbox-2\"]/label/div");
    private final By registerButton = By.cssSelector("button.button-accent.bigbuttR");

    public void noEmailRegistration(){
        webDriver.findElement(emailInput).sendKeys("");
        webDriver.findElement(passwordInput).sendKeys(password);
        webDriver.findElement(confirmPasswordInput).sendKeys(password);
        webDriver.findElement(termsCondtsInput).click();
        webDriver.findElement(privacyPolicyInput).click();
        webDriver.findElement(registerButton).click();
    }

    public void noPasswordRegistration(){
        webDriver.findElement(emailInput).sendKeys(email);
        webDriver.findElement(passwordInput).sendKeys("");
        webDriver.findElement(confirmPasswordInput).sendKeys(password);
        webDriver.findElement(termsCondtsInput).click();
        webDriver.findElement(privacyPolicyInput).click();
        webDriver.findElement(registerButton).click();
    }

    public void notValidPasswordRegistration(){
        webDriver.findElement(emailInput).sendKeys(email);
        webDriver.findElement(passwordInput).sendKeys(notValidPassword);
        webDriver.findElement(confirmPasswordInput).sendKeys(notValidPassword);
        webDriver.findElement(termsCondtsInput).click();
        webDriver.findElement(privacyPolicyInput).click();
        webDriver.findElement(registerButton).click();
    }

    public void notMatchPasswordRegistration(){
        webDriver.findElement(emailInput).sendKeys(email);
        webDriver.findElement(passwordInput).sendKeys(password);
        webDriver.findElement(confirmPasswordInput).sendKeys(notMatchPassword);
        webDriver.findElement(termsCondtsInput).click();
        webDriver.findElement(privacyPolicyInput).click();
        webDriver.findElement(registerButton).click();
    }

    public void noClickTermsCondtsRegistration(){
        webDriver.findElement(emailInput).sendKeys(email);
        webDriver.findElement(passwordInput).sendKeys(password);
        webDriver.findElement(confirmPasswordInput).sendKeys(password);
        webDriver.findElement(privacyPolicyInput).click();
        webDriver.findElement(registerButton).click();
    }

    public void noClickPrivacyPolicyRegistration(){
        webDriver.findElement(emailInput).sendKeys(email);
        webDriver.findElement(passwordInput).sendKeys(password);
        webDriver.findElement(confirmPasswordInput).sendKeys(notMatchPassword);
        webDriver.findElement(termsCondtsInput).click();
        webDriver.findElement(registerButton).click();
    }


}
