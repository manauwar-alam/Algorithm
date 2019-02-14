package com.manauwar.cryptography;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class DESPrivateKeyImp {

	public static void main(String[] args) {
		Key key = null;
		Cipher cipher = null;
		String text = "This is a test!";
		byte [] cipherText = null;
		byte [] decryptedText = null;
		

		System.out.println("Text to be encrypted is : "+text);
		
		try {
			key = getKey();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		try {
			cipher = getCipherObject();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		
		try {
			
			cipherText = encrypt(text, cipher, key);
			System.out.println("Encrypted text is : " + new String(cipherText,"UTF8"));
			
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
				| IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		
		try {
			
			decryptedText = decrypt(text, cipher, key, cipherText);
			System.out.println("Decrypted text is : "+new String(decryptedText,"UTF8"));
			
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	
	static byte [] encrypt(String text, Cipher cipher, Key key) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		byte plainText [] = text.getBytes("UTF8");
		
		//start encryption
		System.out.println("\nStart Encryption");
		cipher.init(Cipher.ENCRYPT_MODE,key);
		byte [] cipherText = cipher.doFinal(plainText);
		System.out.println("Finish Encryption : ");
		//System.out.println(new String(cipherText,"UTF8"));
		return cipherText;
				
	}
	
	static byte [] decrypt(String text, Cipher cipher, Key key, byte [] cipherText) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		//decrypt the cipher text using same key
		System.out.println("\nStart Decryption");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte [] newPlainText = cipher.doFinal(cipherText);
		System.out.println("Finish Decryption");
		//System.out.println(new String(newPlainText,"UTF8"));
		return newPlainText;
		
	}


	static Cipher getCipherObject() throws NoSuchAlgorithmException, NoSuchPaddingException {
		//get a DES cipher object and print the provider
		////specifying the algorithm, mode, and padding.
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		System.out.println("\n Provider : " + cipher.getProvider().getInfo() );
		return cipher;
	}


	private static Key getKey() throws NoSuchAlgorithmException {
		//get a DES private key
		System.out.println("\nStart generating DES key");
		KeyGenerator keygen = KeyGenerator.getInstance("DES");
		keygen.init(56);
		Key key = keygen.generateKey();
		System.out.println("Finished generating key");
		return key;
		
	}

}
