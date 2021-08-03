package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage {
    WebDriver webDriver;

    public CalendarPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By LOGOUT_ICON = By.xpath("//*/mat-icon[2]");

    public void logout() {
        webDriver.findElement(LOGOUT_ICON).click();
    }
}


