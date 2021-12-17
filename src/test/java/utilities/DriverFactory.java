package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private DriverFactory() {
        //Empty class instructor
    }
    private static final DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() { return instance; }

    //Thread local driver object for WebDriver
    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        WebDriverManager.chromedriver().setup();
        //can be replaced with other browser drivers
        return new ChromeDriver();
    });

    //call this method to get the driver object and launch the browser
    public WebDriver getDriver() { return driver.get(); }

    //Quits the driver and closes the browser
    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
