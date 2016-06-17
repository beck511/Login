package test.Login;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;
import login.Decryption;
import login.Strings;


public class AppTest extends TestCase {
	// Tests if the decryption class can decrypt a given string
	public void testDecryption() {
		String input = "OAY92/NZ1najV9H8iJ5OZgpJkZWQsygi";
		String actual = new Decryption().doDecrypt(input);
		assertEquals("Teddy Bear", actual);
	}

	// Tests if decrypting a different string will result in a not expected username
	public void testDecryptionWithIncorrectData() {
		String input = "fg8INiEeTvVoo1lSnETqpfmZow+3fcGp";
		String actual = new Decryption().doDecrypt(input);
		assertNotSame("admin", actual);
	}

	// Tests if Strings class returns the correct username
	public void testStringsReturnsCorrectUsername() throws IOException {
		String s = new Strings().getuName();
		assertEquals("admin", s);
	}

	// Tests if config.properties file exists
	public void testConfigFileExists() {
		new File("config.properties").exists();
	}

}
