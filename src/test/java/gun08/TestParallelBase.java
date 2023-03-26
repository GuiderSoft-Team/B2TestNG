package gun08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;

import java.time.Duration;

public class TestParallelBase {

   protected WebDriver driver;
   protected WebDriverWait wait;

    @BeforeTest
    public void beforeTest(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterTest
    public void afterTest(){
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

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    String url="https://opencart.abstracta.us/";
    By lMyAccount= By.xpath("//div[@id='top-links']//a[contains(.,'My Account')]");
    By lLogin=By.xpath("//div[@id='top-links']//a[contains(.,'Login')]");
    By lMail=By.xpath("//input [@name='email']");
    By lPassword=By.xpath("//input [@name='password']");
    By lLog=By.xpath("//input [@class='btn btn-primary']");
    By lMyAccount1=By.xpath("//div[@id='top-links']//span[contains(.,'My Account')]");
    By lLogout=By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(.,'Logout')]");




}
