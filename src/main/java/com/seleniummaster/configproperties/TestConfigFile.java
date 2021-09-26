package com.seleniummaster.configproperties;

public class TestConfigFile {
    public static void main(String[] args) {
        String configFile="config.txt";
        String configFile1="config-qa.properties";
        ApplicationConfigDemo.readFromPropertiesFile(configFile,"qaurl");
        ApplicationConfigDemo.readFromPropertiesFile(configFile,"timeout");
        ApplicationConfigDemo.readFromPropertiesFile(configFile,"username");
        ApplicationConfigDemo.readFromPropertiesFile(configFile1,"username");
        ApplicationConfigDemo.readFromPropertiesFile(configFile1,"timeout");
        ApplicationConfigDemo.readFromPropertiesFile(configFile1,"password");

    }
}
