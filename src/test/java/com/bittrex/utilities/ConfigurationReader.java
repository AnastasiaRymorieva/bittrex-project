package com.bittrex.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1- we create properties object
    //2 -get the path and store in String, or directly pass into fileInputStream obj
    //3- We need to open the file
    //4- We need to load the file
    //5- close.file

    private static Properties properties=new Properties();

    static {
        //2 -get the path and store in String, or directly pass into fileInputStream obj
        String path="configuration.properties";
        //3- We need to open the file
        //4- We need to load the file to properties object
        //5- close.file
        try {
            FileInputStream file=new FileInputStream(path);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Properties File not found!");
        }

    }
    //Our own custom method to read and get values from configuration.properties file
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);

    }
}
