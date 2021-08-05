package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetails {

    WebDriver webdriver;

    public PersonalDetails(WebDriver webDriver) {
        this.webdriver = webDriver;
    }

    //user personal elements
    private final By USER_UPLOAD_PICTURE_ICON = By.xpath("//*/app-profile-pic-upload/div/div/img");
    private final By USER_PICTURE_DELETE_BUTTON = By.xpath("//*/div/span/mat-icon");
    private final By USER_FIRSTNAME_INPUT = By.id("firstName");
    private final By USER_SURNAME_INPUT = By.id("surName");
    private final By USER_NICKNAME_INPUT = By.id("nickName");
    private final By NEWSLETTER_CLICKBOX = By.xpath("//*[@id=\"mat-checkbox-1\"]/label/div");
    private final By SAVE_USER_PERSONAL_DETAILS_BUTTON = By.xpath("//*/div/form/div/div/button");

    //user address elements
    private final By USER_FULLNAME_INPUT = By.xpath("//*[@id=\"mat-input-9\"]");
    private final By USER_COUNTY_INPUT = By.xpath("//*[@id=\"mat-input-10\"]");
    private final By USER_POSTAL_CODE_INPUT = By.xpath("//*[@id=\"mat-input-11\"]");
    private final By USER_CITY_INPUT = By.xpath("//*[@id=\"mat-input-12\"]");
    private final By USER_ADDRESS_INPUT = By.xpath("//*[@id=\"mat-input-13\"]");
    private final By SAVE_USER_ADDRESS_DETAILS_BUTTON = By.xpath("//*/app-spinner-button/button/span");

    //user change password elements
    private final By USER_PASSWORD_INPUT = By.id("oldPassword");
    private final By USER_NEW_PASSWORD_INPUT = By.id("password");
    private final By USER_CONFIRM_PASSWORD_INPUT = By.id("confirmPassword");
    private final By SAVE_NEW_PASSWORD_BUTTON = By.xpath("//*/div[3]/change-password/form/div/div/button");

    //user delete account elements
    private final By USER_DELETE_ACCOUNT = By.xpath("//*/div[5]/button/span");

    public void uploadPersonalDetails(String firstname, String surname, String nickname){
        webdriver.findElement(USER_FIRSTNAME_INPUT).clear();
        webdriver.findElement(USER_SURNAME_INPUT).clear();
        webdriver.findElement(USER_NICKNAME_INPUT).clear();
        webdriver.findElement(USER_FIRSTNAME_INPUT).sendKeys(firstname);
        webdriver.findElement(USER_SURNAME_INPUT).sendKeys(surname);
        webdriver.findElement(USER_NICKNAME_INPUT).sendKeys(nickname);
        webdriver.findElement(SAVE_USER_PERSONAL_DETAILS_BUTTON).click();
    }

    public void changePassword(String password, String newpassword, String confirmpassword) {
        webdriver.findElement(USER_PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(USER_NEW_PASSWORD_INPUT).sendKeys(newpassword);
        webdriver.findElement(USER_CONFIRM_PASSWORD_INPUT).sendKeys(confirmpassword);
        webdriver.findElement(SAVE_NEW_PASSWORD_BUTTON).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
