package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*Small attempt at hiding username and password for app (Not yet complete, still to add encryption and possibly save user data externally.)*/

public class Strings {
	

	public String getuName() throws IOException {
		File file = new File("config.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties db = new Properties();
		db.load(fis);
		String login = db.getProperty("db.login");
		return login;
	}

	public String getpWord() throws IOException {
		File file = new File("config.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties db = new Properties();
		db.load(fis);
		String password = db.getProperty("db.password");
		return password;
	}

}
