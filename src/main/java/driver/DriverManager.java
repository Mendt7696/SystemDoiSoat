package driver;

import config.ConfigReader;
import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static enums.Browser.CHROME;
import static enums.Browser.FIREFOX;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //Gọi DriverManager.initDriver() để khởi tạo trình duyệ
    public static void initDriver() {
        String browserName = ConfigReader.getProperty("Browser");
        Browser browser = Browser.valueOf(browserName.toUpperCase());

        // Dùng TargetFactory để tạo WebDriver
        TargetFactory factory = new TargetFactory();
        driver.set(factory.createInstance(browser));
        getDriver().manage().window().maximize();
    }

    //Gọi DriverManager.getDriver() để lấy instance dùng trong test.
    public static WebDriver getDriver() {
        return driver.get();
    }

    //Gọi DriverManager.quitDriver() sau khi test xong
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
