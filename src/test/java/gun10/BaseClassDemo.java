package gun10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseClassDemo {
    WebDriver driver;
    WebDriverWait wait;



    @BeforeTest
    public void setup() {
        driver = DriverDemo1.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }

    public void click(WebElement element) {
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    public void sendKeys(WebElement element, String text) {
        WebElement element1 =wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.sendKeys(text);
    }

    public By xpath(String xpathStr, String label) {
        return By.xpath(String.format(xpathStr, label));
    }

    public void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException var4) {
            throw new RuntimeException(var4);
        }
    }

    @AfterTest
    public void tearDown() {
        DriverDemo1.quitDriver();
    }
}

