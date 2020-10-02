package Com.nopcommerce.Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

    private static  Properties properties;

    public void loadConfigFile() throws IOException {
        File f = new File("./ConfigurationDetails/applicationConfiguration.properties");
        FileInputStream fis = new FileInputStream(f);
        properties = new Properties();
        properties.load(fis);
    }

    public String getConfigProperty(String Propertyname) {
        return properties.getProperty(properties.getProperty(Propertyname) );
    }
}
