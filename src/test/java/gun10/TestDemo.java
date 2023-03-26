package gun10;


import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TestDemo extends BaseClassDemo implements LocatorsDemo {


    @Test(priority = 1)
    public void Test1Signup() {
        driver.get(url);
        click(xpath(HeaderMenu, "Sign up"));
        sendKeys(lSignupUsername, "Mustafa20");
        sendKeys(lSignupPassword, "98765");
        click(xpath(SignupandCloseButton, "Sign up"));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equalsIgnoreCase("already exist.")) {
            alert.accept();
           click(xpath(SignupandCloseButton, "Close"));
        } else {
            alert.accept();
        }

    }

    @Test(priority = 2)
    public void Test2Login() {
        click(xpath(HeaderMenu, "Log in"));
        sendKeys(lLoginUsername, "Mustafa20");
        sendKeys(lLoginPassword, "98765");
        click(lLoginButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginButton));
        sleep(1000);
    }

    @Test(priority = 3)
    public void Test3SelectProduct() {
        click(lPhones);
        click(xpath(phonesUrunler, "Samsung galaxy s6"));
        click(lAddToCart);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Test(priority = 4)
    public void Test4Cart() {
        click(xpath(HeaderMenu, "Cart"));
        click(lCartPlaceOrder);
        sendKeys(xpath(PlaceOrderBody, "name"), "Mustafa");
        sendKeys(xpath(PlaceOrderBody, "country"), "Turkiye");
        sendKeys(xpath(PlaceOrderBody, "city"), "Amasya");
        sendKeys(xpath(PlaceOrderBody, "card"), "1234567898765432");
        sendKeys(xpath(PlaceOrderBody, "month"), "05");
        sendKeys(xpath(PlaceOrderBody, "year"), "2025");
        click(xpath(CartClosePurch, "Purchase"));
        click(lThankOK);

    }
}
