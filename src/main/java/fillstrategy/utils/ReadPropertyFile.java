package fillstrategy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
    private final String FILE_PATH = "src/main/resources/config.properties";
    private final Properties properties = new Properties();

    public ReadPropertyFile() {
        try(InputStream inputStream = new FileInputStream(FILE_PATH)){
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFilePath(){
        String propertyFilePath = properties.getProperty("file.path");
        if (propertyFilePath != null) {
            return propertyFilePath;
        } else{
            throw new RuntimeException("file path not specified in the config.properties file");
        }
    }
    public int getAmountObjectInFile(){
        String propertyAmountObject = properties.getProperty("file.amount-object");
        if (propertyAmountObject != null) {
            return Integer.parseInt(propertyAmountObject);
        } else{
            throw new RuntimeException("Amount object not specified in the config.properties file");
        }
    }

}
