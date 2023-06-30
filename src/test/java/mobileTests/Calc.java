package mobileTests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Calc {
    private AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String ambiente = "remoto"; //<--Trocar para local se for rodar localmente
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL remoteUrl;
        switch (ambiente) {
            case "local":
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("deviceName", "emulator-5554");
                desiredCapabilities.setCapability("automationName", "uiautomator2");
                desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
                desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
                desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
                remoteUrl = new URL("https://localhost:4723/wd/hub");
                break;
            case "remoto":
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("platformVersion", "9.0");
                desiredCapabilities.setCapability("browserName", "");
                desiredCapabilities.setCapability("appiumVersion", "1.19.2");
                desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
                desiredCapabilities.setCapability("deviceOrientation", "Portrait");
                desiredCapabilities.setCapability("app", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");
                desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
                desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
                desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
                desiredCapabilities.setCapability("SAUCE_USERNAME", "");
                desiredCapabilities.setCapability("SAUCE_ACCESS_KEY", "");
                remoteUrl = new URL("https://username:accesskey@ondemand.us-west-1.saucelabs.com:443/wd/hub");
                break;
            default:
                remoteUrl = new URL("https://localhost:4723/wd/hub");
                break;
        }
        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
    }
    @Test
    public void Calc() {
        MobileElement btn7 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
        btn7.click();
        MobileElement btnMinus = (MobileElement) driver.findElementByAccessibilityId("minus");
        btnMinus.click();
        MobileElement btn3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        btn3.click();
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();
        MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals("4",lblResultado.getText());
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
