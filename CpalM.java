import java.io.*;
import java.util.*;

class Cpalrev {
	public String reverse(String n) {
		String str=n;
		char ch;
		String nstr="";
		   for(int i=(str.length()-1);i>=0;i-- ) {
			ch= str.charAt(i);
			nstr=nstr+ch;
		   }
		return nstr;
			
	}
}

class CpalM {
	public static void main(String args[]) {
		String str,nstr;
		int i;
		Cpalrev r=new Cpalrev();
		System.out.println("Enter string");
		Scanner s =new Scanner(System.in);
		try {
			str=s.nextLine();
			nstr=r.reverse(str);
			if(str.toLowerCase().equals(nstr.toLowerCase() )) {
				System.out.println(str+" is a palindrome ");
			}
			else {
				System.out.println(str+" is not a palindrome ");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
			
			