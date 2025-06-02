package common;

import config.ConfigReader;
import org.bouncycastle.util.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public AdminPage(WebDriver driver){
        this.driver = driver;
        long explicitTimeout = Long.parseLong(ConfigReader.getProperty("explicitTimeout"));
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(explicitTimeout));
    }

    //locator
    By adminButton = By.xpath("//*[@class='oxd-main-menu-item active']");
    By textVerify = By.xpath("//*[text()='System Users']");

    // Admin Screen displayed
    public void adminIsDisplayed(){
        this.wait.until(ExpectedConditions.elementToBeClickable(adminButton)).click();
        try {
            WebElement text = this.driver.findElement(textVerify);
            System.out.println(text.getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
