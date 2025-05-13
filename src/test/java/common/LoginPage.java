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
    By userName = By.xpath("//*[@type='text']");
   By password = By.xpath("//*[@type='password']");
   By clickButton = By.xpath("//*[@type='button']");
   By loginSuccessfull = By.xpath("//*[@data-pc-section='content']");
   By loginFail = By.xpath("//*[text()='invalid_grant']");


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
    // ✅ Method lấy text của toast
    public String getToastMessage_Valid(){
       this.wait.until(ExpectedConditions.visibilityOfElementLocated(loginSuccessfull));
       return this.driver.findElement(loginSuccessfull).getText();
    }
    public String getToastMessage_Fail(){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(loginFail));
        return  this.driver.findElement(loginFail).getText();
    }

    // Phương thức để kiểm tra hiển thị text HỆ THỐNG ĐỐI SOÁT trên Dashboard sau khi đăng nhập thành công
    public Boolean isDashboardDisplayed(){
        try{
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='HỆ THỐNG ĐỐI SOÁT ']")));
            WebElement dashboardText = this.driver.findElement(By.xpath("//*[text()='HỆ THỐNG ĐỐI SOÁT ']"));
            return dashboardText.isDisplayed();
        } catch (RuntimeException e) {
            System.out.println("Timeout: Không thể tìm thấy text 'HỆ THỐNG ĐỐI SOÁT' trong thời gian chờ");
            return false;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
