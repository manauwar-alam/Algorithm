package com.manauwar.cryptography;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAPublicKeyImp {
	
	/* RSA. This algorithm is the most popular public key cipher, but it's not supported 
	 * in JDK 1.4. You must use a third-party library like BouncyCastle to get this support. */
	
	/* Diffie-Hellman. This algorithm is technically known as a key-agreement algorithm . 
	 * It cannot be used for encryption, but can be used to allow two parties to derive a 
	 * secret key by sharing information over a public channel. This key can then be used
	 *  for private key encryption. */

	public static void main(String[] args) {

		Cipher cipher = null;
		String text = "This is a test!";
		byte [] cipherText = null;
		byte [] decryptedText = null;
		KeyPair key = null;
		
		
		try {
			key = getRSAKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			cipher = getCipherObject();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			cipherText = encrypt(cipher, key, text);
			System.out.println("Encrypted text is : " + new String(cipherText,"UTF8"));
			
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
						e.printStackTrace();
		}
		
		try {
			
			decryptedText = decrypt(cipher, key, cipherText);
			System.out.println("Decrypted text is : "+new String(decryptedText,"UTF8"));
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	//generate RSA key 
	
	static KeyPair getRSAKey() throws NoSuchAlgorithmException
	{
		
		System.out.println("\nStart generating RSA Key");
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	    keyGen.initialize(1024);
	    KeyPair key = keyGen.generateKeyPair();
	    System.out.println("\nFinished generating RSA Key");
	    return key;
		
	}
	
	static Cipher getCipherObject() throws NoSuchAlgorithmException, NoSuchPaddingException
	{
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		System.out.println("\n"+cipher.getProvider().getInfo());
		return cipher;
	}
	
	static byte []  encrypt(Cipher cipher, KeyPair key, String text) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		byte plainText [] = text.getBytes("UTF8");
		
		System.out.println("\nStart Encryption");
		cipher.init(Cipher.ENCRYPT_MODE, key.getPublic());
		byte [] cipherText = cipher.doFinal(plainText);
		System.out.println("Finish Encryption : ");
		return cipherText;
		
	}
	
	static byte [] decrypt(Cipher cipher, KeyPair key, byte [] cipherText) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		System.out.println("\nStart Decryption");
		cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());
		byte [] newPlainText = cipher.doFinal(cipherText) ;
		System.out.println("Finish Decryption");
		return newPlainText;
	}

}
