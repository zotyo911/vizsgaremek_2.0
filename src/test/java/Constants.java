import org.openqa.selenium.By;

public class Constants {

    public static final String TRAINER_EMAIL = "tesztedzo@igym.hu";
    public static final String TRAINER_PASSWORD = "123456";
    public static final String TRAINER_WRONG_PASSWORD = "123455";

    public static final String USER_EMAIL = "tesztuser@igym.hu";
    public static final String USER_PASSWORD = "123456";
    public static final String USER_WRONG_PASSWORD = "123457";

    public static final By EMAIL_INPUT = By.id("emailOrUserName");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.cssSelector("button.button-accent");
}
