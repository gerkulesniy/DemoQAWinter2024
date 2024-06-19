package com.demoqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    private ConfigReader(){
        //Singleton pattern
    }

    static {
        try {
            String path = "C:\\Users\\User\\IdeaProjects\\DemoQAWinter2024\\src\\main\\resources\\app.properties";
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
            fileInputStream.close();
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
