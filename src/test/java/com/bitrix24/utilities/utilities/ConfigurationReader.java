package com.bitrix24.utilities.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;
    static {
        try {
            //location of properties file
            String path = System.getProperty("user.dir")+"/configuration.properties";
            //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //create object of properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    /**
     *
     * @param keyName
     * @return
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }

}
