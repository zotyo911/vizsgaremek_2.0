package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalendarPage {
    WebDriver webdriver;

    public CalendarPage(WebDriver webDriver) {
        this.webdriver = webDriver;
    }

    private final By PROFILE_BUTTON = By.xpath("//mat-nav-list/a[4]/div/span/div[1]");
    private final By HAMBURGER_BUTTON = By.xpath("//span/mat-icon");
    private final By LOGOUT_ICON = By.xpath("//mat-icon[2]");
    private final By MY_TICKETS_MENU = By.xpath("//mat-nav-list/a[3]/div/span/div[1]");
    private final By BUY_TICKET_BUTTON = By.xpath("//mat-toolbar-row[1]/div/div/button");
    private final By SIX_TIME_TRAINING = By.xpath("//*[@id=\"mat-option-0\"]/span");
    private final By TEN_TIME_TRAINING = By.xpath("//*[@id=\"mat-option-1\"]/span");
    private final By FOURTEEN_TIME_TRAINING = By.xpath("//*[@id=\"mat-option-2\"]/span");
    private final By UPPER_MENU_JOGA_BUTTON = By.cssSelector("div:nth-child(1) > button > mat-icon > svg");
    private final By UPPER_MENU_PILATES_BUTTON = By.cssSelector("div:nth-child(5) > button > mat-icon > svg");
    private final By UPPER_MENU_STRECHING_BUTTON = By.cssSelector("div:nth-child(2) > button > mat-icon > svg");
    private final By UPPER_MENU_OTHER_BUTTON = By.cssSelector("div:nth-child(8) > button > mat-icon > svg");
    private final By NUMBER_OF_TICKETS_DROPDOWN = By.xpath("//*[contains(@role,'listbox')]");
    private final By APPLY_BUTTON = By.xpath("//mat-card/button[2]");

    private final By TRAINER_BUTTON = By.xpath("//mat-nav-list/a[2]/div/span/div[1]");
    private final By TRAINING_LIST = By.xpath("//app-training-calendar-list-view");



    public void logout() {
        webdriver.findElement(LOGOUT_ICON).click();
    }

    public void profileButtonClick() {
        webdriver.findElement(PROFILE_BUTTON).click();
        new PersonalDetails(webdriver);
    }

    public void clickMyTickets(){
        webdriver.findElement(MY_TICKETS_MENU).click();
        new MyTicketsPage(webdriver);
    }

    public void clickHamburgerButton() {
        webdriver.findElement(HAMBURGER_BUTTON).click();
    }

    public void clickTrainerButton() {
        webdriver.findElement(TRAINER_BUTTON).click();
    }

    public void buyTicketButtonClick() {
        webdriver.findElement(BUY_TICKET_BUTTON).click();
    }

    public void stechingButtonClick() {
        webdriver.findElement(UPPER_MENU_STRECHING_BUTTON).click();
    }

    public void otherButtonClick() {
        webdriver.findElement(UPPER_MENU_OTHER_BUTTON).click();
    }

    public void jogaButtonClick() {
        webdriver.findElement(UPPER_MENU_JOGA_BUTTON).click();
    }

    public void pilatesButtonClick() {
        webdriver.findElement(UPPER_MENU_PILATES_BUTTON).click();
    }



    public void checkTrainingLiteTicketPrice() {
        buyTicketButtonClick();
        webdriver.findElement(NUMBER_OF_TICKETS_DROPDOWN).click();
        webdriver.findElement(SIX_TIME_TRAINING).click();
    }

    public void checkTrainingPlusTicketPrice() {
        buyTicketButtonClick();
        webdriver.findElement(NUMBER_OF_TICKETS_DROPDOWN).click();
        webdriver.findElement(FOURTEEN_TIME_TRAINING).click();
    }

    public void checkTrainingProTicketPricePerTraining() {
        buyTicketButtonClick();
        webdriver.findElement(NUMBER_OF_TICKETS_DROPDOWN).click();
        webdriver.findElement(SIX_TIME_TRAINING).click();
    }

    public void checkTrainingUltraTicketPricePerTraining() {
        buyTicketButtonClick();
        webdriver.findElement(NUMBER_OF_TICKETS_DROPDOWN).click();
        webdriver.findElement(TEN_TIME_TRAINING).click();
    }

    public void applyOnTraining() {
        List<WebElement> trainings = webdriver.findElements(TRAINING_LIST);

        for (WebElement training : trainings) {
            List<WebElement> trainingDetails = training.findElements(APPLY_BUTTON);
            for (WebElement apply : trainingDetails) {
                if (apply.getText().toUpperCase().contains("JELENTKEZEM!")) {
                    apply.click();
                    break;
                }
            }
        }
    }

    public void deleteTraining() {
        List<WebElement> trainings = webdriver.findElements(TRAINING_LIST);

        for (WebElement training : trainings) {
            List<WebElement> trainingDetails = training.findElements(APPLY_BUTTON);
            for (WebElement apply : trainingDetails) {
                if (apply.getText().toUpperCase().contains("LEMONDÁS")) {
                    apply.click();
                    break;
                }
            }
        }
    }
}



