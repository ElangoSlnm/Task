package com.infinira.studentapp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader  {

    public static Properties getProperty(String propsName) {
        Properties prop = null;
        try (InputStream input = PropertyReader.class.getResourceAsStream("/conf/"+propsName+".properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find "+propsName+".properties");
                return null;
            }
            prop = new Properties();
            //load a properties file from class path, inside static method
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static void main(String[] args) {
        Properties prop = getProperty("db");
        System.out.println(prop.getProperty("url"));
    }

}