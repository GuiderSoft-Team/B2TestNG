package gun08;

import org.testng.annotations.Test;

public class TestParallel extends TestParallelBase{

    @Test
    public void test1(){
        driver.get(url);
        click(lMyAccount);
        click(lLogin);
    }

    @Test
    public void test2(){
        sendKeys(lMail,"deneme@deneme.com");
        sendKeys(lPassword, "deneme");
        click(lLog);
        click(lMyAccount1);
        click(lLogout);
    }
}
