package com.katus.maps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-16
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();

        FileInputStream stream = new FileInputStream("Languages/src/main/resources/color.properties");
        props.load(stream);

        System.out.println("01 = " + props.getProperty("01"));

        stream.close();
    }
}
