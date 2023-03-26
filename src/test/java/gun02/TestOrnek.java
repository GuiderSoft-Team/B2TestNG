package gun02;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Driver;

import java.time.Duration;

public class TestOrnek extends TestOrnekBase{


/*
    BeforeSuit
    driver, wait set edin
    BeforeTest
    https://opensource-demo.orangehrmlive.com/  gidin

    Test 1
    login :
    Test 2
    Menüden admin'e tikla
    User Role -> Admin  secin
    Search edilecek
    Listelenen kullanicilarin tümünün User Rolü'nünü Admin oldugu assert edilecek


    AfterSuite
            TearDown
            */


    @BeforeSuite
    public void drivers(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
  /*  @BeforeTest
    public void gotoUrl(){
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));
    }

    @Test(priority = 0)
    public void Test1(){
        Login(lUsername,username);
        Login(lPassword,password);
        click(lLogin);*/


/*
    }
    @Test(priority = 1)
    public void Test2(){
        click(lAdmin);

    }*/
    @AfterSuite
    public void tearDown(){
        Driver.quitDriver();
    }

}
