package gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAttribute1 {


    @Test(priority = 1, invocationCount = 3)    // invocationCount=3 -> bu test 3 sefer tekrar edilecek.
    public void test1(){
        int actual = sum(1,2,3,4,5,6,7,8,9,10);
        int expected = 55;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        int actual = fact(5);       // 5! = 5*4*3*2*1 = 120
        int expected = 120;
        Assert.assertEquals(actual, expected);
    }


    public int sum(int...nums){
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        return sum;
    }


    public int fact(int n){
        if (n==1)
            return 1;
        else
            return n * fact(n-1);
    }

}
