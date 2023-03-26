package configScroll;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class JsCodes {

    WebDriver driver;
    WebDriverWait wait;


    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By locator = By.xpath("//div[contains(text(), 'Eveniet veniam')]");
    By locator2 = By.xpath("//div[contains(text(), 'Explicabo tenetur')]");
    By locator3 = By.xpath("//p[contains(text(), 'Magnis feugiat')]");




    @Test   //hata veriyor
    public void test1(){

        //driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");

        while (true){

            List<WebElement> list = driver.findElements(locator3);
            if (list.get(0).isDisplayed()) {
                scrollIntoView(list.get(0));
                break;
            }
            scrollBy(10);
        }

    }

    By lAmazonSeachBox = By.xpath("//input[@id='nav-bb-search'] | //input[@id='twotabsearchtextbox']");

    By lAmazonSearcButton = By.id("nav-search-submit-button");

    By lAmazonProdsIphone = By.xpath("//div[@data-component-type='s-search-result' and .//*[contains(.,'iPhone')]]");
    By lAmazonSearchHeader = By.xpath("//span[text()='RESULTS']");
    @Test
    public void testAmazon(){
        driver.get("https://www.amazon.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lAmazonSeachBox)).sendKeys("phone", Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(lAmazonSearchHeader));
        List<WebElement> iphones = driver.findElements(lAmazonProdsIphone);
        for (WebElement iphone : iphones) {
            scrollIntoView(iphone);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        driver.quit();
    }





    public void scrollIntoView(WebElement element){
        scrollIntoView(element, true);
    }

    public void scrollIntoView(WebElement element, boolean toTheTop){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(" + toTheTop +");", element);
    }




    /*
        arguments[0].scrollIntoView(true)   // default  -> elementin üst kismi sayfanin üstünde
        arguments[0].scrollIntoView(false)  //          -> elementin alt kismi sayfanin altinda
     */

    public void scrollBy(int y){  //kaç birim aşagı kaydırsın
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + y + ");");
    }

    public void scrollTo(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + x + ", " + y + ");");
    }

    public void click(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }



}
