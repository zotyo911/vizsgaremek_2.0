import org.junit.jupiter.api.Test;
import pages.LandingPage;

public class TestRegistration {
    
    @Test
    public void testDemo(){
        LandingPage.clickHamburgerButton();
        LandingPage.clickLoginButton();
    }

    @Test
    public void testDemo1(){
        LandingPage.clickHamburgerButton();
        LandingPage.clickTrainerButton();
    }
}
