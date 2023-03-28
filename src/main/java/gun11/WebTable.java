package gun11;

import gun05.odev1.BaseOdev1;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WebTable extends BaseOdev1 {
    /*
        1.  https://demoqa.com/webtables
        2.  Tablodaki tüm verileri siliyoruz
        3.  3 adet yeni veri giriyoruz (DataProvider ile)
        4.  FirstName e göre siraliyoruz ve screenschot aliyoruz.
     */

    String url = "https://demoqa.com/webtables";
    By lDelButtons = By.cssSelector("span[id^='delete-record']");


    By lAddNewRecordButton = By.id("addNewRecordButton");

    By lFirstName = By.cssSelector("#firstName-wrapper input");
    By lLastName = By.cssSelector("#lastName-wrapper input");
    By lEMail = By.cssSelector("#userEmail-wrapper input");
    By lAge = By.cssSelector("#age-wrapper input");
    By lSalary = By.cssSelector("#salary-wrapper input");
    By lDepartment = By.cssSelector("#department-wrapper input");

    By lRegistrationFormSubmitButton = By.cssSelector("#submit");

    By lSortByName = By.xpath("//div[text()='First Name']");


    @Test
    public void test_gotoSite() {
        driver.get(url);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lDelButtons, 1));
    }

    @Test(priority = 1)
    public void test_clearList() {

        List<WebElement> dels = driver.findElements(lDelButtons);

        while (dels.size() > 0) {
            int initialSize = dels.size();
            //if (initialSize <= 0)
            //    break;
            click(dels.get(0));
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(lDelButtons, initialSize));

            dels = driver.findElements(lDelButtons);
        }

    }

    @Test(dataProvider = "data", priority = 2)
    public void fillTheList(String firstname, String lastname, String email, int age, int salary, String department) {
        click(lAddNewRecordButton);
        sendKeys(lFirstName, firstname);
        sendKeys(lLastName, lastname);
        sendKeys(lEMail, email);
        sendKeys(lAge, String.valueOf(age));
        sendKeys(lSalary, String.valueOf(salary));
        sendKeys(lDepartment, department);
        click(lRegistrationFormSubmitButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lFirstName));
    }

    @Test(dataProvider = "data", priority = 2)
    public void fillTheList2(Object...items) {
        By[] locators = {lFirstName,lLastName, lEMail, lAge, lSalary, lDepartment};

        click(lAddNewRecordButton);
        for (int i = 0; i < items.length; i++) {
            sendKeys(locators[i], items[i].toString());
        }

        click(lRegistrationFormSubmitButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lFirstName));
    }

    @Test(priority = 3)
    public void finish(){
        click(lSortByName);
        screenshot("DemoQA");
    }


    public void screenshot(String name){
        name += "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File target = new File("screenshots/" + name + ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][]{
                {"Aguste", "Brayfield", "abrayfield0@purevolume.com", 23, 33472, "Books"},
                {"Melamie", "Lougheid", "mlougheid1@msu.edu", 43, 711717, "Electronics"},
                {"Jerrylee", "Vodden", "jvodden2@naver.com", 45, 48395, "Home"},
                {"Damian", "Gaffney", "dgaffney3@icq.com", 65, 57812, "Beauty"},
                {"Hy", "Spadaro", "hspadaro4@example.com", 76, 63583, "Jewelry"},
                {"Ferdinande", "Woller", "fwoller5@discovery.com", 37, 42795, "Clothing"},
                {"Scarlett", "Pennycock", "spennycock6@woothemes.com", 34, 3692, "Beauty"},
                {"Moselle", "McKennan", "mmckennan7@chron.com", 23, 4367, "Health"},
                {"Henka", "Stickles", "hstickles8@bizjournals.com", 4, 4365, "Computers"},
                {"Valina", "McGlue", "vmcglue9@hubpages.com", 62, 39979, "Music"},
                {"Eloise", "Dymond", "edymonda@phoca.cz", 43, 8783, "Tools"}
        };
    }


    @Test
    public void calc(){
        int num = new Random().nextInt(10, 20);
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(num+1));


    }

    @Test
    public void testCalc(int num1, int num2, String islem, int sonuc){

    }

    @DataProvider
    public Object[][] calcData(){
        return new Object[][]{
                {1, 2, "+", 3},
                {10, 2, "-", 8},

        };
    }

}
