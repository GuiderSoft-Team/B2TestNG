package gun03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Driver;

import java.time.Duration;

public class TestDataProviderOrangeHRM {
    WebDriver driver;
    WebDriverWait wait;

    String url=" https://opensource-demo.orangehrmlive.com";
    By lUsername= By.cssSelector("input[name='username']");
    By lPassword=By.cssSelector("input[name='password']");
    By lLogin=By.xpath("//button[@type='submit']");
    By lUserDropDown = By.cssSelector(".oxd-userdropdown");
    By lLogout= By.xpath("//a[text()='Logout']");
    By lFail=By.xpath("//p[text()='Invalid credentials']");

    @BeforeTest
    public void setup(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(12));
        driver.get(url);
    }

    @DataProvider
    public Object[][] getUser(){
        return new Object[][]
                {
                        {"Admin", "admin124", false},
                        {"Admin1", "admin12412", false},
                        {"Admin2", "admin124234", false},
                        {"Admin3", "tadmin24234", false},
                        {"Admin4", "sadmin12423", false},
                        {"Admin5", "admin12434", false},
                        {"Admin6", "adming14234", false},
                        {"adxccv", "ad234", false},
                        {"jhbnbn", "admin", false},
                        {"Admin", "admin123", true},
                };
    }

    @BeforeMethod
    public void beforeMethod(){
        clearForm();
    }



    @Test(dataProvider = "getUser")
    public void Test1(String username, String password, boolean pass){
        sendKeys(lUsername,username);
        sendKeys(lPassword,password);
        click(lLogin);


        if (pass){
            click(lUserDropDown);
            click(lLogout);
            waitForVisibility(lUsername);

          //  System.out.println(username+","+password+"--Pass--");
        }
        else {

           waitForVisibility(lFail);


           // System.out.println(username+","+password+"--Fail--");
        }

    }

    
    public void sendKeys(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void click(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
    public void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clear(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }


    public void clearForm(){
        clear(lUsername);
        clear(lPassword);
    }

    @AfterTest
    public void tearDown(){
        Driver.quitDriver();
    }
}
