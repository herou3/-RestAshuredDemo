package utils;

import app_context.AppContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {
    public static void getRequestProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/request.properties")) {
            properties.load(fileInputStream);
            AppContext.put("url", properties.getProperty("site.url"));
            AppContext.put("login", properties.getProperty("site.login"));
            AppContext.put("password", properties.getProperty("site.password"));
            AppContext.put("domainName", properties.getProperty("site.domainName"));
            AppContext.put("protocolType", properties.getProperty("site.protocolType"));
            AppContext.put("urlForLogin", (properties.getProperty("site.protocolType") + "://"
                    + properties.getProperty("site.login")
                    + ":"
                    + properties.getProperty("site.password")
                    + "@"
                    + properties.getProperty("site.domainName")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getResponseProperties() {
        Properties properties = new Properties();
        Map<String, String> propertiesMap = new HashMap<>();

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/response.properties")) {
            properties.load(fileInputStream);
            propertiesMap.put("anyValue", properties.getProperty("site.anyValue"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertiesMap;
    }
}
