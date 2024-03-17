import java.io.*;

public class Cmd_product
	{	
		public static void main(String args[])
		{
			int a=Integer.parseInt(args[0]);
			int b=Integer.parseInt(args[1]);
			System.out.println("Product of "+a+" and "+b+" is "+(a*b));
		}
	}