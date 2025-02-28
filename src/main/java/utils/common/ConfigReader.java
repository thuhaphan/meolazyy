package utils.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties props;

    /* Load .properties file */
    public void loadFile(String fileName) {
        props = new Properties();
        final InputStream inputStream;
        try {
            inputStream = new FileInputStream(fileName);
            try {
                props.load(inputStream);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* Returns value of a Property object */
    public String get(String property) {
        return props.getProperty(property);
    }
}