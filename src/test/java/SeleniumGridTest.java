

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;

import static junit.framework.Assert.assertTrue;


public class SeleniumGridTest {
    WebDriver driver;
    String baseUrl,nodeUrl;

    @Before
    public void setup() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/geckodriver/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Suchi\\workspacee");

        baseUrl="http://www.google.com";
        nodeUrl="http://192.168.0.16:5566/wd/hub";
        DesiredCapabilities capabilities=DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--disable-extensions");
       // capabilities.setCapability("chrome.binary","<<your chrome path>>");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);*/
        //capabilities.setVersion("43.0.1");
        //capabilities.setCapability("marionette", true);
        capabilities.setPlatform(Platform.ANY);
        driver=new RemoteWebDriver(new URL((nodeUrl)), capabilities);

    }

    @After
    public void afterTest() {
        driver.quit();
    }


    @Test
    public void simpleTest() {
        driver.navigate().to(baseUrl);
        System.out.println(driver.getTitle());
        assertTrue("true","Google".equalsIgnoreCase(driver.getTitle()));
    }


    }

