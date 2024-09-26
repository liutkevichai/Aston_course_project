package fillstrategy.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 * Class for interact with project properties.
 * It's file 'config.properties'.
 */
public class ReadPropertyFile {
    /***
     * Path to file where stay properties
     */
    private final String FILE_PATH = "src/main/resources/config.properties";
    private final Properties properties = new Properties();

    /***
     * Constructor for read properties from file in object {@link Properties}
     */
    public ReadPropertyFile() {
        try(InputStream inputStream = new FileInputStream(FILE_PATH)){
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /***
     * Method get path file from {@link Properties} and return it
     *
     * @return Path file for serialize object
     */
    public String getFilePath(){
        String propertyFilePath = properties.getProperty("file.path");
        if (propertyFilePath != null) {
            return propertyFilePath;
        } else{
            throw new RuntimeException("file path not specified in the config.properties file");
        }
    }
    /***
     * Method get count object for file from {@link Properties} and return it
     *
     * @return Amount object that will contain in file
     */
    public int getAmountObjectInFile(){
        String propertyAmountObject = properties.getProperty("file.amount-object");
        if (propertyAmountObject != null) {
            return Integer.parseInt(propertyAmountObject);
        } else{
            throw new RuntimeException("Amount object not specified in the config.properties file");
        }
    }
}
