package gun05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Driver;

import java.time.Duration;

public class BaseOdev05 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void setup(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterSuite
    public void tearDown(){
        Driver.quitDriver();
    }

    public void click(By locator){
       WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       click(element);
    }

    public void click(WebElement element){
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.click();
    }

    public void sendKeys(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        sendKeys(element,text);
    }

    public void sendKeys(WebElement element, String text){
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.sendKeys(text);
    }

    public By xpath(String xpathStr, String label) {
        return By.xpath(String.format(xpathStr, label));
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

