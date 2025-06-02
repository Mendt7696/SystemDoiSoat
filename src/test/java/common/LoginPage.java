package common;

import config.ConfigReader;
import org.bouncycastle.util.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
   WebDriver driver;
   WebDriverWait wait;

   public LoginPage(WebDriver driver){
       this.driver = driver;
       long explicitTimeout = Long.parseLong(ConfigReader.getProperty("explicitTimeout"));
       this.wait = new WebDriverWait(this.driver,Duration.ofSeconds(explicitTimeout));
   }
   //Locator
    By userName = By.xpath("//*[@name='username']");
   By password = By.xpath("//*[@name='password']");
   By clickButton = By.xpath("//*[@type='submit']");
   By dashBoardIsDisplayed = By.xpath("//*[@class='oxd-topbar-header-breadcrumb']//*[text()='Dashboard']");


   //Nhap user name
    public void Login_userName(String text){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        WebElement loginUserName = this.driver.findElement(userName);
        loginUserName.sendKeys(text);
    }
    //Nhap Pass Word
    public void Login_Password(String character){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        WebElement loginPassWord = this.driver.findElement(password);
        loginPassWord.sendKeys(character);
    }
    //Click login button
    public void Click_LoginButton(){
        this.wait.until(ExpectedConditions.elementToBeClickable(clickButton));
        WebElement clickLoginButton = this.driver.findElement(clickButton);
        clickLoginButton.click();
    }

    // Phương thức để kiểm tra Login thành công
    public boolean isDashboardDisplayed(){
        try{
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(dashBoardIsDisplayed));
            WebElement dashboardText = this.driver.findElement(dashBoardIsDisplayed);
            System.out.println(dashboardText);
            return  dashboardText.isDisplayed();
        } catch (RuntimeException e) {
            System.out.println("Timeout: Không thể tìm thấy text 'DashBoard' trong thời gian chờ");
            return false;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    /*try {
        // code có thể gây lỗi
    } catch (Exception e) {
        System.out.printlnk(e.getMessage());  // In ra thông điệp lỗi
        e.printStackTrace();                // In ra toàn bộ stack trace (vết lỗi)
    }*/

}
