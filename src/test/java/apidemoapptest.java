import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class apidemoapptest {
    @Test
    public void LaunchApk() throws MalformedURLException, URISyntaxException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Medium Phone");
        options.setPlatformName("Android");
        options.setApp("C:\\Users\\USER\\Downloads\\ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        System.out.println("Appium Driver is Successfully initialized");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Access'ibility\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility Node Provider\"]\n")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility Node Provider\"]\n")).click();
        driver.navigate().back();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility Node Querying\"]\n")).click();
        // Wait until the element is visible
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ListView")));

        // Fetch all the options in the list
        List<WebElement> optionsList = driver.findElements(AppiumBy.className("android.widget.TextView"));

        // Print all the option texts
        for (WebElement option : optionsList) {
            System.out.println("Option: " + option.getText());
        }

        // Optionally navigate back
        driver.navigate().back();


    }


}