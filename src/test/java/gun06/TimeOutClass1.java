package gun06;

import org.testng.annotations.Test;

public class TimeOutClass1 {

     // testlerin süreye tabi tutma ve verdigimiz süreden uzun sürerse hataya düşürmesi

    @Test
    public void test1(){
        count();
    }

    @Test(timeOut = 1000) //test 1 sn yeden fazla sürerse hataya düşürür
    public void test2(){
        count();
    }

    public void count(){
        for (int i = 0; i < 10; i++) {  //dongü toplam 2 sn sürüyor
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
