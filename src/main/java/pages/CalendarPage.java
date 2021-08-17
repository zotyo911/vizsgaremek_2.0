package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarPage {
    WebDriver webdriver;

    public CalendarPage(WebDriver webDriver) {
        this.webdriver = webDriver;
    }

    private final By PROFILE_BUTTON = By.xpath("//*/mat-nav-list/a[4]/div/span/div[1]");
    private final By HAMBURGER_BUTTON = By.xpath("//*/span/mat-icon");
    private final By LOGIN_BUTTON = By.xpath("//*/mat-toolbar-row/div/div/span");
    private final By LOGOUT_ICON = By.xpath("//*/mat-icon[2]");
    private final By BUY_TICKET_BUTTON = By.xpath("//*/mat-toolbar-row[1]/div/div/button");
    private final By SIX_TIME_TRAINING = By.xpath("//*[@id=\"mat-option-0\"]/span");
    private final By TEN_TIME_TRAINING = By.xpath("//*[@id=\"mat-option-1\"]/span");
    private final By FOURTEEN_TIME_TRAINING = By.xpath("//*[@id=\"mat-option-2\"]/span");
    private final By LITE_TRAINING_CARD = By.xpath("//*/div[1]/app-package-card/div");
    private final By PLUS_TRAINING_CARD = By.xpath("//*/div[2]/app-package-card/div");
    private final By PRO_TRAINING_CARD = By.xpath("//*/div[3]/app-package-card/div");
    private final By ULTRA_TRAINING_CARD = By.xpath("//*/div[4]/app-package-card/div");
    private final By TRAINING_TICKET_PRICE = By.xpath("//*[contains(@class,'package-price')]");
    private final By TRAINING_TICKET_NAME = By.xpath("//*[contains(@class,'package-title')]");
    private final By TRAINING_TICKET_NUMBER_OF_WORKOUTS = By.xpath("//*[contains(@class,'ticket-count')]");
    private final By TRAINING_TICKET_PRICE_PER_TRAINING = By.xpath("//*[contains(@class,'price-divided')]");
    private final By NUMBER_OF_TICKETS_DROPDOWN = By.xpath("//*[contains(@role,'listbox')]");
    private final By NEXT_BUTTON = By.xpath("//*/app-package-type-select-step/div/div[3]/button");

    private final By TRAINING_TYPE = By.xpath("//*[contains(@class,'details')]");
    private final By TRAINING_NAME = By.xpath("//*[contains(@class,'name')]");
    private final By TRAINING_DATE = By.xpath("//*[contains(@class,'time')]");
    private final By TRAINING_PRICE = By.xpath("//*[contains(@class,'price')]");
    private final By TRAINER_BUTTON = By.xpath("//*/mat-nav-list/a[2]/div/span/div[1]");

    public void logout() {
        webdriver.findElement(LOGOUT_ICON).click();
    }

    public void profileButtonClick(){
        webdriver.findElement(PROFILE_BUTTON).click();
        new PersonalDetails(webdriver);
    }

    public void loginButtonClick(){
        webdriver.findElement(LOGIN_BUTTON).click();
        new LoginPage(webdriver);
    }

    public void clickHamburgerButton() {
        webdriver.findElement(HAMBURGER_BUTTON).click();
    }

    public void clickTrainerButton() {
        webdriver.findElement(TRAINER_BUTTON).click();
    }

    public void buyTicketButtonClick(){
        webdriver.findElement(BUY_TICKET_BUTTON).click();
    }

    public void checkTrainingLiteTicketPrice(){
        buyTicketButtonClick();
        webdriver.findElement(NUMBER_OF_TICKETS_DROPDOWN).click();
        webdriver.findElement(SIX_TIME_TRAINING).click();

    }

    public void checkTrainingPlusTicketPrice(){
        buyTicketButtonClick();
        webdriver.findElement(NUMBER_OF_TICKETS_DROPDOWN).click();
        webdriver.findElement(FOURTEEN_TIME_TRAINING).click();

    }

    public void checkTrainingProTicketPricePerTraining(){
        buyTicketButtonClick();
        webdriver.findElement(NUMBER_OF_TICKETS_DROPDOWN).click();
        webdriver.findElement(SIX_TIME_TRAINING).click();

    }

    public void checkTrainingUltraTicketPricePerTraining(){
        buyTicketButtonClick();
        webdriver.findElement(NUMBER_OF_TICKETS_DROPDOWN).click();
        webdriver.findElement(TEN_TIME_TRAINING).click();

    }

}


