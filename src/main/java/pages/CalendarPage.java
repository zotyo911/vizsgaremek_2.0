package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage {
    WebDriver webdriver;

    public CalendarPage(WebDriver webDriver) {
        this.webdriver = webDriver;
    }

    private final By PROFILE_BUTTON = By.xpath("//*/mat-nav-list/a[4]/div/span/div[1]");

    private final By LOGOUT_ICON = By.xpath("//*/mat-icon[2]");
    private final By TRAINING_TYPE = By.xpath("//*[contains(@class,'details')]");
    private final By TRAINING_NAME = By.xpath("//*[contains(@class,'name')]");
    private final By TRAINING_DATE = By.xpath("//*[contains(@class,'time')]");
    private final By TRAINING_PRICE = By.xpath("//*[contains(@class,'price')]");

    public void logout() {
        webdriver.findElement(LOGOUT_ICON).click();
    }

    public void profileButtonClick(){
        webdriver.findElement(PROFILE_BUTTON).click();
        new PersonalDetails(webdriver);
    }

}


