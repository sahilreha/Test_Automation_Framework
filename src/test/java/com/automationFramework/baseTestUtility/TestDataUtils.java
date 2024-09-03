package com.automationFramework.baseTestUtility;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestDataUtils {

    private static <T> T loadJsonData(String bundleName, String fileName, Class<T> type) {
        String location = System.getProperty("user.dir") +
                File.separator + "src" + File.separator + "test" + File.separator + "resources" +
                File.separator + bundleName + File.separator + fileName + ".json";
        File file = new File(location);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON data from file: " + location, e);
        }
    }

    public static <T> T fetchMobileTestData(String fileName, Class<T> type) {
        return loadJsonData("mobile_automation_test_data_config", fileName, type);
    }

    public static <T> T fetchWebTestData(String fileName, Class<T> type) {
        return loadJsonData("webtestdata", fileName, type);
    }

    public static <T> T fetchApiTestData(String fileName, Class<T> type) {
        return loadJsonData("api_automation_test_data_config", fileName, type);
    }
}
