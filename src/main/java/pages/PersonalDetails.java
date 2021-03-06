package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PersonalDetails {

    WebDriver webdriver;

    public PersonalDetails(WebDriver webDriver) {
        this.webdriver = webDriver;
    }

    private final By USER_FIRSTNAME_INPUT = By.id("firstName");
    private final By USER_SURNAME_INPUT = By.id("surName");
    private final By USER_NICKNAME_INPUT = By.id("nickName");

    private final By USER_FULLNAME_INPUT = By.xpath("//*[@id=\"mat-input-9\"]");
    private final By USER_COUNTRY_INPUT = By.xpath("//*[@id=\"mat-input-10\"]");
    private final By USER_POSTAL_CODE_INPUT = By.xpath("//*[@id=\"mat-input-11\"]");
    private final By USER_CITY_INPUT = By.xpath("//*[@id=\"mat-input-12\"]");
    private final By USER_ADDRESS_INPUT = By.xpath("//*[@id=\"mat-input-13\"]");

    private final By USER_PASSWORD_INPUT = By.id("oldPassword");
    private final By USER_NEW_PASSWORD_INPUT = By.id("password");
    private final By USER_CONFIRM_PASSWORD_INPUT = By.id("confirmPassword");


    public void uploadPersonalDetails(String firstname, String surname, String nickname){
        webdriver.findElement(USER_FIRSTNAME_INPUT).clear();
        webdriver.findElement(USER_SURNAME_INPUT).clear();
        webdriver.findElement(USER_NICKNAME_INPUT).clear();
        webdriver.findElement(USER_FIRSTNAME_INPUT).sendKeys(firstname);
        webdriver.findElement(USER_SURNAME_INPUT).sendKeys(surname);
        webdriver.findElement(USER_NICKNAME_INPUT).sendKeys(nickname, Keys.ENTER);
    }

    public void changePassword(String password, String newpassword, String confirmpassword) {
        webdriver.findElement(USER_PASSWORD_INPUT).sendKeys(password);
        webdriver.findElement(USER_NEW_PASSWORD_INPUT).sendKeys(newpassword);
        webdriver.findElement(USER_CONFIRM_PASSWORD_INPUT).sendKeys(confirmpassword, Keys.ENTER);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void uploadBillingDetails(String name, String country, String postalcode, String city, String address) {
        webdriver.findElement(USER_FULLNAME_INPUT).clear();
        webdriver.findElement(USER_COUNTRY_INPUT).clear();
        webdriver.findElement(USER_POSTAL_CODE_INPUT).clear();
        webdriver.findElement(USER_CITY_INPUT).clear();
        webdriver.findElement(USER_ADDRESS_INPUT).clear();
        webdriver.findElement(USER_FULLNAME_INPUT).sendKeys(name);
        webdriver.findElement(USER_COUNTRY_INPUT).sendKeys(country);
        webdriver.findElement(USER_POSTAL_CODE_INPUT).sendKeys(postalcode);
        webdriver.findElement(USER_CITY_INPUT).sendKeys(city);
        webdriver.findElement(USER_ADDRESS_INPUT).sendKeys(address, Keys.ENTER);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteBillingDetails(String name) {
        webdriver.findElement(USER_FULLNAME_INPUT).clear();
        webdriver.findElement(USER_COUNTRY_INPUT).clear();
        webdriver.findElement(USER_POSTAL_CODE_INPUT).clear();
        webdriver.findElement(USER_CITY_INPUT).clear();
        webdriver.findElement(USER_ADDRESS_INPUT).clear();
        webdriver.findElement(USER_FULLNAME_INPUT).sendKeys(name, Keys.ENTER);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
