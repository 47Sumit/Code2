package commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils1 {

	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\resources\\data3.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
