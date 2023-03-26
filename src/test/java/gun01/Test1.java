package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;


public class Test1 {

     WebDriver driver;
     WebDriverWait wait;


    String url = "https://demowebshop.tricentis.com/";
    String myUsername = "abc123@aa.com";
    String myPassword = "123456";
    By lLoginformUsername = By.id("Email");
    By lLoginformPassword = By.id("Password");
    By lLoginformSubmitButton = By.xpath("//input[@value='Log in']");
    By lLogout = By.xpath("//a[text()='Log out']");
    By lLogin = By.xpath("//a[text()='Log in']");


    @Test(priority = 0)
    public void gotoUrl(){
        // driver.get
        // title assert edilecek
        driver.get(url);
        Assert.assertEquals(driver.getTitle(),"Demo Web Shop");

    }

    @Test(priority = 1)
    public void clickLinkLogin(){
        // log in linkine tiklanacak
        driver.findElement(lLogin).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(lLogin)).click();
    }

    @Test (priority = 2)
    public void fulfillloginForm(){
        // loginform dolduruacak
        driver.findElement(lLoginformUsername).sendKeys(myUsername);
        driver.findElement(lLoginformPassword).sendKeys(myPassword);
       /* wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginformUsername)).sendKeys(myUsername);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginformPassword)).sendKeys(myPassword);*/
    }

    @Test(priority = 3)
    public void loginSubmitClick(){
        // loginform click butonuna tiklanacak
        driver.findElement(lLoginformSubmitButton).click();
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginformSubmitButton)).click();
    }

    @Test(priority = 4)
    public void loginAssert(){
        // login olundugu assert edilecek
        driver.findElement(lLogout);
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(lLogout));
    }

    @BeforeSuite
    public void BeforeDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       // wait=new WebDriverWait(driver, Duration.ofSeconds(12));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void afterDriverQuit(){
        driver.quit();
    }




}
