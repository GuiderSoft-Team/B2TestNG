package gun09;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class TestBelatrix extends HomePage3 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void setup(){
        driver= Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void Test(){
        driver.get(url);
        click(xpath(headerButton, "Home"));
        click(xpath(shop,"Falcon 9"));
        click(lBackHome);
        click(xpath(shop,"Proton Rocket"));
        click(lBackHome);
        click(xpath(shop,"Proton-M"));
        click(lBackHome);
        click(xpath(shop,"Saturn V"));
        click(lBackHome);
        scrollIntoView(lEkranKaydir);
        click(xpath(shop,"Falcon Heavy"));
        click(lBackHome);
        click(xpath(headerButton, "Blog"));
        click(xpath(headerButton, "Cart"));
        click(xpath(headerButton, "Checkout"));
        click(xpath(headerButton, "Contact Form"));
        click(xpath(headerButton, "My account"));
        click(xpath(headerButton, "Promotions"));





    }


    @AfterSuite
    public void tearDown(){
        Driver.quitDriver();
    }


    public void click(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public By xpath(String xpathStr, String label) {
        return By.xpath(String.format(xpathStr, label));
    }

    protected void scrollIntoView(By locator){

        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        scrollIntoView(element);
    }

    protected void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);

    }

}




