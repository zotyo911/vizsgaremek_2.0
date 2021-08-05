package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetails {

    WebDriver webDriver;

    public PersonalDetails(WebDriver webDriver) {
        this.webDriver = webDriver;
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
    private final By USER_OLD_PASSWORD_INPUT = By.id("oldPassword");
    private final By USER_NEW_PASSWORD_INPUT = By.id("password");
    private final By USER_CONFIRM_PASSWORD_INPUT = By.id("confirmPassword");
    private final By USER_CHANGE_PASSWORD_BUTTON = By.xpath("//*/div[3]/change-password/form/div/div/button");

    //user delete account elements
    private final By USER_DELETE_ACCOUNT = By.xpath("//*/div[5]/button/span");

    public void uploadPersonalDetails(String firstname, String surname, String nickname){
        webDriver.findElement(USER_FIRSTNAME_INPUT).clear();
        webDriver.findElement(USER_SURNAME_INPUT).clear();
        webDriver.findElement(USER_NICKNAME_INPUT).clear();
        webDriver.findElement(USER_FIRSTNAME_INPUT).sendKeys(firstname);
        webDriver.findElement(USER_SURNAME_INPUT).sendKeys(surname);
        webDriver.findElement(USER_NICKNAME_INPUT).sendKeys(nickname);
        webDriver.findElement(SAVE_USER_PERSONAL_DETAILS_BUTTON).click();
    }


}
