package loadtesting;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleHomePageTest {

    private WebDriver driver;
    String appURL = "http://google.com";

    @BeforeClass
    public void testSetUp() throws MalformedURLException {

        //driver = new FirefoxDriver();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("firefox");
        cap.setVersion("54.0");
        cap.setPlatform(org.openqa.selenium.Platform.LINUX);
        driver = new RemoteWebDriver(new URL("http://172.17.0.3:5555/wd/hub"), cap);
    }

    @Test
    public void verifyGooglePageTittle() {
        //driver.navigate().to(appURL);
        //String getTitle = driver.getTitle();
        //Assert.assertEquals(getTitle, "Google");
        driver.get("http://www.google.es");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
