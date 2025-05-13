package tests;

import common.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//mvn clean test
//allure serve allure-results- tạo report
@Epic("LoginFeature")
public class LoginTest extends BaseTest {

    @Test(description = "Verify valid login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login with valid username and password")
    @Story("Valid login story")
    public void LoginSuccessful(){
        this.login.Login_userName("root");

        this.login.Login_Password("123456a@A");

        this.login.Click_LoginButton();
        //Assert
        String actual_Result = this.login.getToastMessage_Valid();
        System.out.println(actual_Result);
        String expected_Result = "Đăng nhập thành công, đang chuyển hướng! ";
        Assert.assertEquals(actual_Result.trim(),expected_Result.trim(),"Toast không hiển thị như mong đợi");

        Assert.assertTrue(this.login.isDashboardDisplayed(),"Dashboard không hiển thị sau khi đăng nhập");

    }

    @Test(description = "Verify Invalid login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login with Invalid username and password")
    @Story("InValid login story")
    public void LoginFail(){
        this.login.Login_userName("valid");

        this.login.Login_Password("1223");

        this.login.Click_LoginButton();
        String actualToast = this.login.getToastMessage_Fail();
        System.out.println(actualToast);
        String expectToast = "invalid_grant";
        Assert.assertEquals(actualToast,expectToast,"Toast Fail khong hien thi nhu mong doi");

    }
}
