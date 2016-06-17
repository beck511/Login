package login;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*De-crypt a given String and returns the correct string.*/

public class Decryption {
	public String doDecrypt(String s) {
		String seed = "463563573";
		String myString = s;
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(seed);

		String decrypted = encryptor.decrypt(myString);
		return decrypted;

	}
}