package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class Driver {

    //private static WebDriver driver;
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    //public static ThreadLocal<Properties> props = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser){
        //if (driver == null){
        if (drivers.get() == null){
            switch (browser){
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    //driver = new FirefoxDriver();
                    drivers.set(new FirefoxDriver());
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");       // version 111 socket hatasi icin
                    //options.addArguments("--start-maximized");              // ilk acilista maximized acilir
                    //options.addArguments("--headless");                   // arka planda calisir
                    //options.addArguments("user-data-dir=" + System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\User Data");
                    drivers.set(new ChromeDriver(options));
                    break;
            }
        }
        return drivers.get();
    }

    public static void quitDriver(){
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }

}
