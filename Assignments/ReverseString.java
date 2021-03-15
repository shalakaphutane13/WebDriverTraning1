package Assignments;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the string");
		Scanner sc=new Scanner(System.in);
		
		String str=sc.nextLine();
		
		System.out.println("Entered String is "+ str);
		
		StringBuffer SB= new StringBuffer(str);
		StringBuffer SB2=SB.reverse();
		System.out.println("Reverse String    "+ SB2);
		System.out.println("Original String   "+ SB2.reverse());
		
		
		
	
	}

}
