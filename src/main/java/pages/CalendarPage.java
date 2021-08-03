package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage {
    WebDriver webDriver;

    public CalendarPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By LOGOUT_ICON = By.xpath("//*/mat-icon[2]");
    private final By TRAINING_TYPE = By.xpath("//*[contains(@class,'details')]");
    private final By TRAINING_NAME = By.xpath("//*[contains(@class,'name')]");
    private final By TRAINING_DATE = By.xpath("//*[contains(@class,'time')]");
    private final By TRAINING_PRICE = By.xpath("//*[contains(@class,'price')]");


    public void logout() {
        webDriver.findElement(LOGOUT_ICON).click();
    }

}


