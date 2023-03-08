package PracticeTestScript.dataDrivenPractice;

import java.util.Random;

public class GenerateRandomContactNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		 int n1=random.nextInt(900)+100;
		 int n2=random.nextInt(643)+100;
		 int n3=random.nextInt(9000)+1000;
		  
		// System.out.println(n1+""+n2+""+n3);
		 
		 Random r=new Random();
		 
		 int i1=r.nextInt(8);
		 int i2=r.nextInt(8);
		 int i3=r.nextInt(8);
		int i4=r.nextInt(742);
		int i5=r.nextInt(1000);
		String phoneNumber=String.format("%d%d%d%03d%04d",i1,i2,i3,i4,i5);
		System.out.println(phoneNumber);
		
	
	
	
	}

}
