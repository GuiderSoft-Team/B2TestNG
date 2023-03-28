package gun11;

import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.Driver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class propertyClass {

    // read property file
    @Test
    public void propertyFile() {

        // properties Classina ihtiyac var
        Properties properties = new Properties();   // property nesnesi olusturulur

        properties.put("username", "myUser");          // nesneye ikili veri eklenir
        properties.put("password", "myPass");          // nesneye ikili veri eklenir


        String user = properties.getProperty("username");   // property den veri okuma
        String pass = properties.getProperty("password");   // property den veri okuma

        System.out.println(user + " , " + pass);

    }

    @Test
    public void readPropertyFromFile() throws IOException {

        Properties properties = new Properties();

        FileReader fileReader = new FileReader("src/main/java/gun11/config.properties");
        properties.load(fileReader);

        String url = properties.getProperty("opencart.url");
        String user = properties.getProperty("username");
        String pass = properties.getProperty("password");

        System.out.println(url);
        System.out.println(user);
        System.out.println(pass);

        // tüm verileri loop ile yazdirmak istenirse
        properties.forEach((k, v)->{
            System.out.println(k + " : " + v);
        });

        fileReader.close();
    }


    @Test
    public void writePropertyFromFile() throws IOException {

        Properties properties = new Properties();

        FileReader fileReader = new FileReader("src/main/java/gun11/config.properties");

        properties.load(fileReader);

        properties.remove("a");
        properties.remove("b");

        properties.put("browser", "firefox");

        FileWriter fileWriter = new FileWriter("src/main/java/gun11/config.properties");

        properties.store(fileWriter,"Aciklama 2");


        fileReader.close();
        fileWriter.close();

    }

    @Test
    public void testDeneme(){
        String browser = ConfigReader.get("browser");
        System.out.println(browser);

        Properties p = ConfigReader.getProperties();
        System.out.println(p.getProperty("browser"));
    }





}
