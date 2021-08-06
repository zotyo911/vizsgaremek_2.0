package pages;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class GdprPage {
    WebDriver webdriver;

    public GdprPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void switchWindow(){
        ArrayList<String> tabs2 = new ArrayList<String> (webdriver.getWindowHandles());
        webdriver.switchTo().window(tabs2.get(1));
        webdriver.close();
        webdriver.switchTo().window(tabs2.get(0));
    }
}

