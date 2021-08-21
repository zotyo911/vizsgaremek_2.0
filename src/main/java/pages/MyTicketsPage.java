package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MyTicketsPage {
    WebDriver webdriver;

    public MyTicketsPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private final By TICKET_LIST = By.xpath("//section[2]/mat-card");
    private final By TICKETS = By.xpath("//mat-card/app-ticket/div");
    private final By CALENDAR_MENU = By.xpath("//a[1]/div/span/div[1]");
    private final By LOGOUT_ICON = By.xpath("//mat-icon[2]");


    public void clickCalendarMenu(){
        webdriver.findElement(CALENDAR_MENU).click();
        new CalendarPage(webdriver);
    }

    public void logout() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.findElement(LOGOUT_ICON).click();
        new LandingPage(webdriver);
    }

    public int sumMyTickets() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> Tickets = new ArrayList<>();
        int sum = 0;
        List<WebElement> ticketList = webdriver.findElements(TICKET_LIST);
            for (WebElement tickets : ticketList) {
                List<WebElement> numberOfTickets = tickets.findElements(TICKETS);
                for (WebElement ticket : numberOfTickets) {
                    String ticketDetails = ticket.getText();
                    Tickets.add(ticketDetails);
                    sum = Tickets.size();
                }
            }
        return sum;
        }
    }


