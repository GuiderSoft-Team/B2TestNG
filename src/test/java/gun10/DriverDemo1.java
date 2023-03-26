package gun10;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.Browsers;

public class DriverDemo1 {
    public static boolean startmaximized = false;
    public static String size = "";
    public static boolean headles = false;
    private static WebDriver driver;



    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {
        if (driver == null) {
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options1 = new FirefoxOptions();
                    options1.addArguments("--remote-allow-origins=*");
                    if (startmaximized) {
                        options1.addArguments("--start-maximized");
                    }

                    if (headles) {
                        options1.addArguments("--headles");
                    }

                    driver = new FirefoxDriver(options1);
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options2 = new EdgeOptions();
                    options2.addArguments("--remote-allow-origins=*");
                    if (startmaximized) {
                        options2.addArguments("--start-maximized");
                    }

                    if (headles) {
                        options2.addArguments("--headles");
                    }

                    driver = new EdgeDriver(options2);
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    if (startmaximized) {
                        options.addArguments("--start-maximized");
                    }

                    if (headles) {
                        options.addArguments("--headles");
                    }

                    driver = new ChromeDriver(options);
            }
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}