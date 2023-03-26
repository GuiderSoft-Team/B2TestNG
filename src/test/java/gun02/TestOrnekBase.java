package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestOrnekBase {
    WebDriver driver;
    WebDriverWait wait;

    String url=" https://opensource-demo.orangehrmlive.com";
    String username="Admin";
    String password="admin123";
    By lUsername= By.xpath("//input[@name='username']");
    By lPassword=By.xpath("//input[@type='password']");
    By lLogin=By.xpath("//button[@type='submit']");
    By lAdmin=By.xpath(".//a[.='Admin']");
    By lUserRoleAdmin=By.xpath("(//div[@class='data'][contains(.,'Admin')])[2]");

    public void Login(By locators ,String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators)).sendKeys(text);
        driver.findElement(locators).sendKeys(text);

    }
    public void click(By locators){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(locators)).click();
        driver.findElement(locators).click();

    }
}
