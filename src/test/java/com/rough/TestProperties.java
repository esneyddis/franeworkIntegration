package com.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {
        /**
         * Properties declaration
         */
        Properties p = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "src/test/resources/properties/config.properties");
        p.load(file);
        file = new FileInputStream(System.getProperty("user.dir") + "src/test/resources/properties/OR.properties");
        p.load(file);
    }
}
