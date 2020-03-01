import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {

    @Test
    public void testApp() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability(CapabilityType.VERSION, "10.0.0");
        cap.setCapability("deviceName", "Cat");
        cap.setCapability("app", "C:\\AUTOMATION\\APPIUM\\LoginApp.apk");

        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        System.out.println("App launched");

        driver.findElement(By.id("textInputEditTextEmail")).sendKeys("myemail@email.com");
        driver.findElement(By.id("textInputEditTextPassword")).sendKeys("myemail@email.com");
        driver.findElement(By.id("appCompatButtonLogin")).click();

    }
}
