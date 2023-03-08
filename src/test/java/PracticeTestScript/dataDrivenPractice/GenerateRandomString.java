package PracticeTestScript.dataDrivenPractice;

import java.util.Random;

public class GenerateRandomString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alp="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb=new StringBuilder();
		Random random=new Random();
		int length=7;
		for(int i=0;i<length;i++)
		{
			//get random number
			int index=random.nextInt(alp.length());
			
			char randomchar=alp.charAt(index);
			sb.append(randomchar);
		}
		String randomString=sb.toString();
		System.out.println("Random String is "+randomString);
		
		}
		
		
	}


