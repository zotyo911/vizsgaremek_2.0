package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final String LOGIN_EMAIL = "tesztedzo@igym.hu";
    private final String PASSWORD = "123456";


}
