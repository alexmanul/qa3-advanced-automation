//import io.appium.java_client.android.AndroidDriver;
//public class AppiumTest {

//    @BeforeEach
//    public void setUp() throws Exception {
//
//        //To create an object of Desired Capabilities
//        DesiredCapabilities capability = new DesiredCapabilities();
//
//        capability.setCapability(CapabilityType.VERSION,"10.0.0");
//        capability.setCapability("app", "C:\\AUTOMATION\\APPIUM\\LoginApp.apk");
//        capability.setCapability("deviceName", "Cat");
//        capability.setCapability("platformName", "Android");
//
//        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
//    }

//    @Test
//    public void testApp() throws MalformedURLException {
//
//        DesiredCapabilities cap = new DesiredCapabilities();
//
//        cap.setCapability("platformName", "Android");
//        cap.setCapability(CapabilityType.VERSION, "10.0.0");
//        cap.setCapability("deviceName", "Cat");
//        cap.setCapability("app", "C:\\AUTOMATION\\APPIUM\\LoginApp.apk");
//
//        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//        System.out.println("App launched");
//
//        driver.findElement(By.id("textInputEditTextEmail")).sendKeys("myemail@email.com");
//        driver.findElement(By.id("textInputEditTextPassword")).sendKeys("myemail@email.com");
//        driver.findElement(By.id("appCompatButtonLogin")).click();
//
//    }
//}
