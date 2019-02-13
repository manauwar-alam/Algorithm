package com.manauwar.cryptography;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class MessageDigestImp {

	public static void main(String[] args) {
		
		String text = "This is a test!";
		//createMessageDigest(text);
		
		createMessageDigestUsingKey(text);

	}
	
	
	static void createMessageDigest(String text)
	{
		byte [] plainText = null;
		MessageDigest messageDigest = null;
		
		try {
			plainText = text.getBytes("UTF8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		System.out.println("Provider used : ");
		System.out.println(messageDigest.getProvider().getInfo());
		
		//calculate digest and print
		messageDigest.update(plainText);
		System.out.println("\nDigest : ");
		
		try {
			System.out.println(new String(messageDigest.digest(),"UTF8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	
	static void createMessageDigestUsingKey(String text)
	{
		
		byte [] plainText = null;
		KeyGenerator keygen = null;
		 Mac mac = null;
		
		try {
			plainText = text.getBytes("UTF8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		//// get a key for the HmacMD5 algorithm
		System.out.println("Start generating key");
		
		try {
			 keygen = KeyGenerator.getInstance("HmacMD5");
			 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		 SecretKey MD5Key = keygen.generateKey();
		 
		 System.out.println("Finished Generating key");
		 
		 
		 //get MAC object and update it with plaintext
		
		try {
			mac = Mac.getInstance("HMacMD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		 try {
			mac.init(MD5Key);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		 
		 mac.update(plainText);
		 
		 //print out the provider used and MAC
		 System.out.println("\nMAC Provider : ");
		 System.out.println(mac.getProvider().getInfo());
		 
		 System.out.println("\n MAC : ");
		 try {
			System.out.println(new String(mac.doFinal(), "UTF8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
