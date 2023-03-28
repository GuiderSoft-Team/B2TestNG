package gun11;

import gun05.odev1.BaseOdev1;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Browsers;
import utils.ConfigReader;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OrangeHRM extends OrangeHRMBase {

    By lUsername = By.xpath("//input[@name='username']");
    By lPassword = By.xpath("//input[@name='password']");
    By lLoginButton = By.xpath("//button[.=' Login ']");
    By lUserHeader = By.cssSelector(".oxd-topbar-header-userarea");

    @BeforeTest
    public void beforeTest(){
        String browser = ConfigReader.get("browser");
        driver = Driver.getDriver(Browsers.valueOf(browser.toUpperCase()));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        driver.manage().window().maximize();
    }

    @Test
    public void login(){
        String url = ConfigReader.get("orangehrm.url");
        String username = ConfigReader.get("orangehrm.username");
        String password = ConfigReader.get("orangehrm.password");

        driver.get(url);

        sendKeys(lUsername, username);
        sendKeys(lPassword, password);
        click(lLoginButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUserHeader));
        tScreenShot("OrangeHRM");
    }


    public void tScreenShot(String fileName){
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File target = new File("screenshots/" + fileName + ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @AfterTest
    public void afterTest(){
        Driver.quitDriver();
    }





}
