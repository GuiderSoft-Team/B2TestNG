package utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    /*
        config.properties dosyasindan istenilen veriyi
        static method ile return edecek
     */
    static String file = "src/main/resources/config.properties";
    static Properties properties = new Properties();
    static FileReader fileReader;

    public static String get(String key){
        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);

            fileReader.close();
            return properties.getProperty(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public static Properties getProperties(){
        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);

            fileReader.close();
            return properties;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
