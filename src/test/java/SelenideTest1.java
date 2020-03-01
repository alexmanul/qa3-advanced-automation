import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;


import java.net.MalformedURLException;


import static com.codeborne.selenide.Selenide.sleep;


public class SelenideTest1 {

    @Test
    public void testSelenide01()  {

        System.setProperty("selenide.browser", "Chrome");
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.browserSize = "2960x1440";

    Selenide.open("www.ss.lv");
    sleep(5000);
    }

    @Test
    public void testSelenide02() throws MalformedURLException {

        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.browserSize = "1920x1080";
//        open("www.ss.lv");
    }

}
