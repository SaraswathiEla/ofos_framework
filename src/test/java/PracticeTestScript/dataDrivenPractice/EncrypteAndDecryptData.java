package PracticeTestScript.dataDrivenPractice;

import java.util.Base64;

public class EncrypteAndDecryptData {

	public static void encrypt(String encryptData) {
		 //encrypt
		byte[] byteA = encryptData.getBytes();
		byte[] byteB = Base64.getDecoder().decode(byteA);
		String s=new String(byteB);
		System.out.println(s);
		
	}
	public static void decrypt(String decryptData) {
		//decrypt
				 
				 
				byte[] byteA = decryptData.getBytes();
				byte[] byteB = Base64.getEncoder().encode(byteA);
				  String s = new String(byteB);
				System.out.println(s);
			
		
	}

	
	public static void main(String[] args) {
		// encrypt data convert(decode) and print
		String encryptData="YWJjZGVm";
		byte[] byteA = encryptData.getBytes();
		byte[] byteB = Base64.getDecoder().decode(byteA);
		String s=new String(byteB);
		//System.out.println(s);
	
		
		//decrypt
		String decryptData="rohanrohan";
		byteA = decryptData.getBytes();
		byteB = Base64.getEncoder().encode(byteA);
		  s=new String(byteB);
		System.out.println(s);
		//encrypt(encryptData);
	//	decrypt(decryptData);
	
	}

}
