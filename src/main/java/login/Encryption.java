package login;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*Encrypts a given string (Used to create the data in config.properties by a developer)*/

public class Encryption {
	public String doEncryption(String s) {
		String seed = "463563573";
		String myString = s;

		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(seed);
		String encrypted = encryptor.encrypt(myString);
		return encrypted;
	}
}