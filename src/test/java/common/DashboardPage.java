/*
package common;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        long explicitTimeout = Long.parseLong(ConfigReader.getProperty("explicitTimeout"));
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(explicitTimeout));
    }

    //Locator
    By titleDashboard = By.xpath("//*[text()='HỆ THỐNG ĐỐI SOÁT ']");
    By BBXNSL_Tab = By.xpath("//*[contains(text(),'Biên bản xác nhận số liệu')]");
    By KHThuong_Tab = By.xpath("//*[contains(text(),'Khách hàng thường')]");
    By BKCTDSKHThuong_Tab = By.xpath("//span[contains(text(),'Bản kê chi tiết đối soát KH thường')]");
    By donviSelect = By.xpath("//*[@id='pn_id_57']/following::*[@role='combobox'][1]");
    By itemdonvi = By.xpath("//*[contains(text(),'Trung chuyển nội tỉnh (100958)')]");
    By locButton = By.xpath("//*[@icon='pi pi-search']");

    //Method check IsDisplayed
    public String getDashboardTitle(){
        try {
            this.driver.findElement(titleDashboard).isDisplayed();
            return this.driver.findElement(titleDashboard).getText();
        }catch (Exception e){
           return e.getMessage();
        }
    }
    public void filter_KHT(){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(BBXNSL_Tab));
        this.driver.findElement(BBXNSL_Tab).click();
        this.driver.findElement(KHThuong_Tab).click();
        this.driver.findElement(BKCTDSKHThuong_Tab).click();
        //Filter -- Do dropdown khong phai the HTML truyen thong ma la the Custom div, ul, li
        //Chinh vi vay khong the dung Select duoc
        this.wait.until(ExpectedConditions.elementToBeClickable(donviSelect)).click();

        this.wait.until(ExpectedConditions.elementToBeClickable(itemdonvi)).click();

        this.driver.findElement(locButton).click();
    }

}
*/
