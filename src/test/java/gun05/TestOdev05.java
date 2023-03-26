package gun05;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static gun05.Locators05.*;

public class TestOdev05 extends BaseOdev05 {
    /*
1.  https://opensource-demo.orangehrmlive.com/
2.  Login olunuz
3.  Admin linkine tiklayin
4.  Add butonu ile kullanici eklenecek
5.  Ismi cecil olani employee olarak secin
6.  Diger bilgileri doldurun
7.  kaydedin ve user kaydi yapildigindan emin olun.
8.  Kaydedilen kullaniciyi bulun ve edit edin
9.  Kullanici adi sonuna 1 ekleyin ve kaydedin.
10. yeni kullaniciyi aratin ve silin
11. kullanicinin silindiginden emin olun.
     */

    @Test
    public void gotoUrl(){
        driver.get(url);
        wait.until(ExpectedConditions.titleIs(tittle));
    }

    @Test(dependsOnMethods = {"gotoUrl"})
    public void testLogin(){
        sendKeys(lUsername,"Admin");
        sendKeys(lPassword,"admin123");
        click(lLoginButton);
    }

    @Test (dependsOnMethods = {"testLogin"})
    public void testAdmin(){
        click(xpath(MenuLink,"Admin"));
        click(xpath(AddButton,"Add"));
        click(xpath(Dropdown,"User Role"));
        click(xpath(DROPDOWN_OPTION,"ESS"));
        sleep(2000);
        click(xpath(Dropdown,"Status"));
        click(xpath(DROPDOWN_OPTION,"Enabled"));
        sendKeys(lEmployeeName,"Cecil  Bonaparte");
        sendKeys(lNewUserName,"Mustafa");
        sendKeys(lNewPassword,"Mustafa05.");
        sendKeys(lNewConfirmPassword,"Mustafa05.");
        click(lSave);
        sleep(5000);

    }
}
