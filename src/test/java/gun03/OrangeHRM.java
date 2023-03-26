package gun03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Driver;

import java.time.Duration;
public class OrangeHRM {


    public class TestLogin {
        WebDriver driver;
        WebDriverWait wait;

        @BeforeTest
        public void setup(){
            driver = Driver.getDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get(url);
        }
        @AfterTest
        public void tearDown(){
            Driver.quitDriver();
        }

        String url= "https://opensource-demo.orangehrmlive.com/";
        By lUsername = By.cssSelector("input[name='username']");
        By lPassword = By.cssSelector("input[name='password']");
        By lSubmitButton = By.cssSelector("button[type='submit']");
        By lUserDropdown = By.cssSelector(".oxd-userdropdown");
        By lLogout = By.xpath("//a[text()='Logout']");
        By lSidePanel = By.cssSelector(".oxd-sidepanel");

        By lFailNotification = By.xpath("//p[text()='Invalid credentials']");

        @BeforeMethod
        public void beforeMethod(){
            clearForm();
        }
        @Test(dataProvider = "getUsers")
        public void test2(String username, String password,boolean pass){

            sendKeys(lUsername,username);
            sendKeys(lPassword,password);
            click(lSubmitButton);
            if (pass)
            {
                click(lUserDropdown);
                click(lLogout);
                waitForVisibility(lUsername);
            }else {
                waitForVisibility(lFailNotification);
            }
        }
        // Dataprovider --> test metodlari icin data kaynagidir
        // return Object[][]
        @DataProvider
        public Object[][] getUsers(){
            return new Object[][]
                    {
                            {"Admin","admin124",false},
                            {"Admin1","admin12432",false},
                            {"Admin2","admin124232",false},
                            {"Admin","admin123",true}
                    };
        }

        public void click(By locator){
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        }

        public void sendKeys(By locator,String text){
            //clear buraya eklenebilir
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
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
    }
}
