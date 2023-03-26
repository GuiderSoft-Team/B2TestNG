package gun05;

import org.openqa.selenium.By;

public class Locators05 {

    public static final String url="https://opensource-demo.orangehrmlive.com/";
    public static final String tittle="OrangeHRM";
    public static final By lUsername= By.cssSelector("input[name='username']");
    public static final By lPassword= By.cssSelector("input[name='password']");
    public static final By lLoginButton= By.cssSelector("button[type='submit']");
  //  public static final By lAdmin=By.cssSelector("a[class='oxd-main-menu-item active']");  //alltaki daha gelişmişi
    public static final String MenuLink="//aside//a[contains(., '%s')]";
    public static final String AddButton="//button[contains(.,'%s')]";
    public static final String Dropdown="//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-grid-item')]//div[@class='oxd-select-wrapper']";
    public static final String DROPDOWN_OPTION = "//div[@role='option' and .//span[contains(.,'%s')]]";
    public static final String AddUser= "//div[@class='oxd-select-text-input'][contains(.,'%s')]";
    public static final By lNewUserName=By.xpath("(//div[@class='orangehrm-card-container']//input[@class='oxd-input oxd-input--active'])[1]");
    public static final By lNewPassword=By.xpath("(//div[@class='orangehrm-card-container']//input[@class='oxd-input oxd-input--active'])[2]");
   // public static final By lNewConfirmPassword=By.xpath("(//div[@class='orangehrm-card-container']//input[@class='oxd-input oxd-input--active'])[3]");
    public static final By lNewConfirmPassword=By.xpath("(//input[@type='password'])[2]");
    public static final By lSave=By.cssSelector("button[type='submit']");
    public static final By lEmployeeName= By.xpath("//input[@placeholder='Type for hints...']");

}
