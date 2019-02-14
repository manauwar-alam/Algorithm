package com.manauwar.cryptography;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DigitalSignatureUsingMD {

	public static void main(String[] args) {

		String text = "This is a test!";
		byte [] plainText = null;
		byte [] messageDigest = null;
		Cipher cipher = null;
		KeyPair keyPair = null;
		byte [] cipherText = null;
		byte [] newMD = null;
		byte[] oldMD = null;
		
		
		try {
			
			plainText = text.getBytes("UTF8");
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		try {
			
			messageDigest = createMessageDigest(plainText);
		    System.out.println( "\nDigest: " );
			System.out.println( new String( messageDigest, "UTF8") );
			
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		try {
			
			keyPair = getRSAKeyPair();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		try {
			
			cipher = getRSACipher();
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		
		/* encrypt message digest to create signature with RSA private Key */
		try {
			
			cipherText = encrypt(keyPair, cipher, messageDigest);
			System.out.println("Encrypted text is : "+ new String(cipherText, "UTF8") );
			
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		/*  to verify start decrypting the signature with RSA public key*/
		try {
			
			newMD = decrypt(cipher, cipherText, keyPair);
			 System.out.println("Decrypted text is : "+ new String(newMD, "UTF8") );
			
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		/* Recreate the message digest from plaintext to simulate what a recipient must do	 */
		
		try {
			
			oldMD = recreateMessageDigest(plainText);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		/* verify that the two message digests match */
	    int len = newMD.length;
	    if (len > oldMD.length) {
	      System.out.println( "Signature failed, length error");
	      System.exit(1);
	    }
	    for (int i = 0; i < len; ++i)
	      if (oldMD[i] != newMD[i]) {
	        System.out.println( "Signature failed, element error" );
	        System.exit(1);
	      }
	    System.out.println( "Signature verified" );
	}
	
	
	
	static byte[] createMessageDigest(byte[] plainText) throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		
		
		
	    // get an MD5 message digest object and compute the plaintext digest
	    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	    System.out.println( "\nMessage Digest Provider : " + messageDigest.getProvider().getInfo() );
	    messageDigest.update(plainText);
	    byte[] md = messageDigest.digest();
	  //  System.out.println( "\nDigest: " );
	 //   System.out.println( new String( md, "UTF8") );
	    return md;
	}
	
	static KeyPair getRSAKeyPair() throws NoSuchAlgorithmException
	{
		// generate an RSA keypair
	    System.out.println( "\nStart generating RSA key" );
	    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	    keyGen.initialize(1024);
	    KeyPair keyPair = keyGen.generateKeyPair();
	    System.out.println( "Finish generating RSA key" );
	    return keyPair;
	}
	
	
	static Cipher getRSACipher() throws NoSuchAlgorithmException, NoSuchPaddingException
	{
		// get an RSA cipher and list the provider
	    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	    System.out.println( "\nRSA Cipher Provider : " + cipher.getProvider().getInfo() );
	    return cipher;
	}
	
	
	static byte [] encrypt(KeyPair keyPair, Cipher cipher, byte [] md) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		// encrypt the message digest with the RSA private key to create the signature
	    System.out.println( "\nStart encryption" );
	    cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
	    byte[] cipherText = cipher.doFinal(md);
	    System.out.println( "Finish encryption: " );
	   // System.out.println( new String(cipherText, "UTF8") );
	    
	    return cipherText;
	}
	
	
	static byte [] decrypt(Cipher cipher, byte [] cipherText, KeyPair keyPair) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		// to verify, start by decrypting the signature with the
	    // RSA private key
	    System.out.println( "\nStart decryption" );
	    cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
	 
	    byte[] newMD = cipher.doFinal(cipherText);
	    System.out.println( "Finish decryption: " );
	    //System.out.println( new String(newMD, "UTF8") );
	    return newMD;
		
	}
	
	
	static byte [] recreateMessageDigest(byte [] plainText) throws NoSuchAlgorithmException
	{
		// then, recreate the message digest from the plaintext to simulate what a recipient must do
	    System.out.println( "\nStart signature verification" );
	    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	    messageDigest.update(plainText);
	    byte[] oldMD = messageDigest.digest();
	    return oldMD;
	}


}






/* 
// This program demonstrates the digital signature technique at the
// primative level by generating a message digest of the plaintext
// and signing it with an RSA private key, to create the signature.
// To verify the signature, the message digest is again generated from
// the plaintext and compared with the decryption of the signature
// using the public key.  If they match, the signature is verified.
public class DigitalSignature1Example {
 
  public static void main (String[] args) throws Exception {
    //
    // check args and get plaintext
    if (args.length !=1) {
      System.err.println("Usage: java DigitalSignature1Example text");
      System.exit(1);
    }
    byte[] plainText = args[0].getBytes("UTF8");
    //
    // get an MD5 message digest object and compute the plaintext digest
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    System.out.println( "\n" + messageDigest.getProvider().getInfo() );
    messageDigest.update( plainText );
    byte[] md = messageDigest.digest();
    System.out.println( "\nDigest: " );
    System.out.println( new String( md, "UTF8") );
    //
    // generate an RSA keypair
    System.out.println( "\nStart generating RSA key" );
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    keyGen.initialize(1024);
    KeyPair key = keyGen.generateKeyPair();
    System.out.println( "Finish generating RSA key" );
    //
    // get an RSA cipher and list the provider
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    System.out.println( "\n" + cipher.getProvider().getInfo() );
    //
    // encrypt the message digest with the RSA private key
    // to create the signature
    System.out.println( "\nStart encryption" );
    cipher.init(Cipher.ENCRYPT_MODE, key.getPrivate());
    byte[] cipherText = cipher.doFinal(md);
    System.out.println( "Finish encryption: " );
    System.out.println( new String(cipherText, "UTF8") );
    //
    // to verify, start by decrypting the signature with the
    // RSA private key
    System.out.println( "\nStart decryption" );
    cipher.init(Cipher.DECRYPT_MODE, key.getPublic());
 
    byte[] newMD = cipher.doFinal(cipherText);
    System.out.println( "Finish decryption: " );
    System.out.println( new String(newMD, "UTF8") );
    //
    // then, recreate the message digest from the plaintext
    // to simulate what a recipient must do
    System.out.println( "\nStart signature verification" );
    messageDigest.reset();
    messageDigest.update(plainText);
    byte[] oldMD = messageDigest.digest();
    //
    // verify that the two message digests match
    int len = newMD.length;
    if (len > oldMD.length) {
      System.out.println( "Signature failed, length error");
      System.exit(1);
    }
    for (int i = 0; i < len; ++i)
      if (oldMD[i] != newMD[i]) {
        System.out.println( "Signature failed, element error" );
        System.exit(1);
      }
    System.out.println( "Signature verified" );
  }
}        
 
 * */
