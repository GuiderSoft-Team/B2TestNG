package gun11;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample {


    @Test(dataProvider = "getData")
    public void testDP1(String fName, String lName, int age, String email, double salary, String department){
        System.out.println(fName + "\t" + lName + "\t" + age + "\t" + email + "\t" + salary + "\t" + department);
    }

    @Test(dataProvider = "getData")
    public void testDP2(Object...datas){
        for (Object data : datas) {
            System.out.print(data + "\t");
        }
        System.out.println();
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"Firstname", "LastName", 19, "Email", 1200, "Department"},
                {"Firstname", "LastName", 21, "Email@email.co,", 12.000, "Department1"},
                {"Firstname", "LastName", 23, "Email", 1565, "Department"},
                {"Firstname", "LastName", 54, "Email", 2323, "Department"},
                {"Firstname", "LastName", 12, "Email", 3245, "Department"}

        };
    }

    @org.testng.annotations.DataProvider
    public Object[][] getDataCalculetor(){
        return new Object[][]{
                {1, 2, "+"},
                {5, 2, "-"},
                {4, 2, "x"},
                {8, 2, "÷"}

        };
    }

}
