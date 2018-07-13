package com.xlh.crm.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wwz on 2016/12/1.
 */
public class PropertiesUtil {

    private static final Logger LOGGER = LogManager.getLogger(PropertiesUtil.class.getName());

    private static Properties properties;

    static {
        properties = new Properties();
        FileInputStream in = null;
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            System.exit(1);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    public static synchronized String getValue(String key) {
        return (String) properties.get(key);
    }
}