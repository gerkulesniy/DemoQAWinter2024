package com.demoqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    public ConfigReader(){
        //Singleton pattern
    }

    static {
        try {
            InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("app.properties");

            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static String getValue(String key){
        return properties.getProperty(key).trim();
    }



}
