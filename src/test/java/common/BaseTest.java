package common;

import config.ConfigReader;
import driver.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    //Project Object
    public LoginPage login;

    //WebDriver
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        DriverManager.initDriver();
        this.driver = DriverManager.getDriver();

        // Lấy timeout từ file config và chuyển sang kiểu int
        int implicite_Wait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicite_Wait));

        // Gọi URL từ file config.properties
        String url = ConfigReader.getProperty("url");
        this.driver.get(url);

        this.login = new LoginPage(this.driver);
    }
    @AfterMethod
    public void teardown(){
        DriverManager.quitDriver();
    }
}