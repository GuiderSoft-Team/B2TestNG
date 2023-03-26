package gun10;

import org.openqa.selenium.By;

public interface LocatorsDemo {

    String url = "https://demoblaze.com/";
    String HeaderMenu = "//div[@id='navbarExample']//li/a[contains(.,'%s')]";
    By lSignupUsername = By.xpath("//input[@id='sign-username']");
    By lSignupPassword = By.xpath("//input[@id='sign-password']");
    String SignupandCloseButton = "//div[@class='modal-footer']//button[contains(.,'%s')]";
    By lLoginUsername = By.xpath("//input[@id='loginusername']");
    By lLoginPassword = By.xpath("//input[@id='loginpassword']");
    By lLoginButton = By.xpath("//div[@class='modal-footer']//button[contains(.,'Log in')]");
    By lPhones = By.xpath("//div[@class='list-group']//a[contains(.,'Phones')]");
    String phonesUrunler = "//div[@class='col-lg-9']//h4/a[contains(.,'%s')]";
    By lAddToCart = By.xpath("//a[contains(.,'Add to cart')]");
    By lCartPlaceOrder = By.cssSelector("div.col-lg-1 button ");
    String PlaceOrderBody = "//div[@class='modal-body']//input[@id='%s']";
    String CartClosePurch = "//div[@class='modal-footer']//button[contains(.,'%s')]";
    By lThankOK = By.xpath("//button[contains(.,'OK')]");


}
