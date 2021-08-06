package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LandingPage {

    WebDriver webdriver;

    public LandingPage(WebDriver webdriver){
        this.webdriver = webdriver;
    }

    private final By HAMBURGER_BUTTON = By.xpath("//*/mat-icon");
    private final By LOGIN_PAGE_BUTTON = By.xpath("//*/mat-nav-list/a[1]/div/span/div[1]");
    private final By REGISTRATION_PAGE_BUTTON = By.xpath("//*/mat-nav-list/a[2]/div/span/div[1]");
    private final By CALENDAR_BUTTON = By.xpath("//*/mat-nav-list/a[3]/div/span/div[1]");
    private final By TRAINER_BUTTON = By.xpath("//*/mat-nav-list/a[4]/div/span/div[1]");
    private final By GDPR_BUTTON = By.xpath("//*/section//a");
    private final By ACCEPT_COOKIES_BUTTON = By.xpath("//*/section/button");

    private final By TRAINING_LIST = By.xpath("//*[contains(@class,'container ng-star-inserted')]");


    public void navigateToURL(String url){
        webdriver.get(url);
    }

    public void clickHamburgerButton(){
        webdriver.findElement(HAMBURGER_BUTTON).click();
    }

    public void clickLoginButton(){
        webdriver.findElement(LOGIN_PAGE_BUTTON).click();
        new LoginPage(webdriver);
    }

    public void clickRegistrationButton(){
        webdriver.findElement(REGISTRATION_PAGE_BUTTON).click();
        new RegistrationPage(webdriver);
    }

    public void openGDPR(){
        webdriver.findElement(GDPR_BUTTON).click();
        new GdprPage(webdriver);
    }

    public void saveTrainingDatasToFile() {
        List<WebElement> trainings = webdriver.findElements(TRAINING_LIST);
        if(trainings.size()>0){
            String text = trainings.get(1).getText();
            try {
                FileWriter textFile = new FileWriter("trainingDetails.txt");
                textFile.append(text);
                textFile.close();
            } catch (IOException e) {
                System.out.println("An error occurred by reading trainingDetails.txt");
                e.printStackTrace();
            }
        }
    }

    public void clickCookiesAcceptButton(){
        webdriver.findElement(ACCEPT_COOKIES_BUTTON).click();
    }

    public void clickCalendarButton(){
        webdriver.findElement(CALENDAR_BUTTON).click();
    }

    public void clickTrainerButton(){
        webdriver.findElement(TRAINER_BUTTON);
    }

}
